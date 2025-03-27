package com.atguigu.iot.platform.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.atguigu.iot.common.constant.GuiguEmqxConstants;
import com.atguigu.iot.platform.emqx.EmqxConfig;
import com.atguigu.iot.platform.mapper.DeviceAttrDataMapper;
import com.atguigu.iot.platform.mapper.DeviceOptionLogMapper;
import com.atguigu.iot.platform.mapper.ProductInfoMapper;
import com.atguigu.iot.platform.mapper.ProductModelAttrMapper;
import com.atguigu.iot.platform.pojo.*;
import com.atguigu.iot.platform.service.DeviceAttrDataService;
import com.atguigu.iot.platform.service.DeviceInfoService;
import com.atguigu.iot.platform.util.WebSocketLocalContainerUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.websocket.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/***
 * 设备属性操作的服务接口类的实现类
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DeviceAttrDataServiceImpl implements DeviceAttrDataService {

    @Autowired
    private DeviceInfoService deviceInfoService;

    @Autowired
    private ProductModelAttrMapper productModelAttrMapper;

    @Autowired
    private DeviceAttrDataMapper deviceAttrDataMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private DeviceOptionLogMapper deviceOptionLogMapper;

    @Autowired
    private EmqxConfig emqxConfig;

    @Autowired
    private ProductInfoMapper productInfoMapper;

    /**
     * 保存设备的属性操作
     * @param message
     */
    @Override
    public void saveDeviceAttrData(JSONObject message) {
        //获取消息id
        String id = message.get("id").toString();
        //处理并发的情况--TODO-重复的隐患
        Boolean aBoolean = redisTemplate.opsForValue().setIfAbsent(id, "1", 10, TimeUnit.SECONDS);
        if(!aBoolean){
            return;
        }
        //判断消息是否被处理过
        Long count = deviceAttrDataMapper.selectCount(
                new LambdaQueryWrapper<DeviceAttrData>()
                        .eq(DeviceAttrData::getMessageId, id));
        if(count > 0){
            return;
        }
        //获取topic
        String topic = message.get("topic").toString();
        //对主题进行切分
        String[] split = topic.split("/");
        //获取clientid
        String clientid = split[2];
        //获取设备的信息
        DeviceInfo deviceInfo =
                deviceInfoService.getOne(
                        new LambdaQueryWrapper<DeviceInfo>()
                                .eq(DeviceInfo::getClientId, clientid)
                                .eq(DeviceInfo::getStatus, "1"));
        if(deviceInfo == null){
            return;
        }
        //获取到本次设置的属性有哪些
        JSONObject payload = JSONObject.parseObject(message.get("payload").toString());
        //获取属性的名字
        Set<String> keySet = payload.keySet();
        //设备存在,查询这个产品的属性
        List<ProductModelAttr> productModelAttrs =
                productModelAttrMapper.selectList(
                        new LambdaQueryWrapper<ProductModelAttr>()
                                .eq(ProductModelAttr::getProductId, deviceInfo.getProductId())
                                .eq(ProductModelAttr::getStatus, "1")
                                .in(ProductModelAttr::getIdentifier, keySet));
        //保存上报属性的信息到设备的表中去
        productModelAttrs.forEach(productModelAttr -> {
            //保存到设备的属性表
            DeviceAttrData deviceAttrData = new DeviceAttrData();
            deviceAttrData.setMessageId(id);
            deviceAttrData.setProductId(productModelAttr.getProductId());
            deviceAttrData.setDeviceId(deviceInfo.getId());
            deviceAttrData.setModelAttrId(productModelAttr.getId());
            deviceAttrData.setDataTypeId(productModelAttr.getDataTypeId());
            deviceAttrData.setDataValue(payload.get(productModelAttr.getIdentifier()).toString());
            deviceAttrData.setStatus("1");
            deviceAttrDataMapper.insert(deviceAttrData);
        });
        //记录设备的操作日志
        DeviceOptionLog deviceOptionLog = new DeviceOptionLog();
        deviceOptionLog.setProductId(deviceInfo.getProductId());
        deviceOptionLog.setDeviceId(deviceInfo.getId());
        deviceOptionLog.setMessageId(id);
        deviceOptionLog.setOptionType("1");
        deviceOptionLog.setTopic(message.get("topic").toString());
        deviceOptionLog.setRequestParams(message.toJSONString());
        deviceOptionLog.setRequestTime(new Date());
        deviceOptionLog.setIsFinish("0");
        deviceOptionLog.setStatus("1");
        deviceOptionLog.setDimensionTime(new Date());
        //保存设备的操作日志
        deviceOptionLogMapper.insert(deviceOptionLog);
        //响应EMQX服务器,告诉它属性上报完成: 1.连接上EMQX 2.发送消息
        String replyTopic = GuiguEmqxConstants.TOPIC_PROERTY_POST_REPLY;
        //查询产品的信息
        ProductInfo productInfo = productInfoMapper.selectById(deviceInfo.getProductId());
        //转换
        replyTopic = MessageFormat.format(replyTopic, productInfo.getProductKey(), deviceInfo.getClientId());
        //发送消息
        emqxConfig.sendMessage(replyTopic, id);
    }

    /**
     * 属性上报响应的操作结束掉
     *
     * @param message
     */
    @Override
    public void updateDeviceAttrData(JSONObject message) {
        String messageId = message.get("payload").toString();
        //查询设备的操作日志
        DeviceOptionLog deviceOptionLog =
                deviceOptionLogMapper.selectOne(
                        new LambdaQueryWrapper<DeviceOptionLog>()
                                .eq(DeviceOptionLog::getMessageId, messageId)
                                .eq(DeviceOptionLog::getStatus, "1")
                                .eq(DeviceOptionLog::getIsFinish, "0"));
        if(deviceOptionLog == null){
            return;
        }
        //设置结束
        deviceOptionLog.setIsFinish("1");
        deviceOptionLog.setResponseData(message.toJSONString());
        deviceOptionLog.setResponseCode("0");
        deviceOptionLog.setResponseTime(new Date());
        deviceOptionLogMapper.updateById(deviceOptionLog);
    }

    /**
     * 属性设置
     *
     * @param message
     */
    @Override
    public void propertiesSet(JSONObject message) {
        //获取topic
        String topic = message.get("topic").toString();
        //对主题进行切分
        String[] split = topic.split("/");
        //获取clientid
        String clientid = split[2];
        //查询设备的信息
        DeviceInfo deviceInfo =
                deviceInfoService.getOne(
                        new LambdaQueryWrapper<DeviceInfo>()
                                .eq(DeviceInfo::getClientId, clientid)
                                .eq(DeviceInfo::getStatus, "1"));
        if(deviceInfo == null){
            return;
        }
        //获取到本次设置的属性的数据
        JSONObject payload =
                JSONObject.parseObject(message.get("payload").toString());
        //获取本次设置的属性的全部的标识符
        Set<String> keySet = payload.keySet();
        //获取产品的id
        Long productId = deviceInfo.getProductId();
        //获取产品的全部属性的信息
        List<ProductModelAttr> productModelAttrs =
                productModelAttrMapper.selectList(
                        new LambdaQueryWrapper<ProductModelAttr>()
                                .eq(ProductModelAttr::getProductId, productId)
                                .in(ProductModelAttr::getIdentifier, keySet));
        if(productModelAttrs == null){
            return;
        }
        //遍历保存本次设置的属性
        productModelAttrs.stream().forEach(productModelAttr -> {
            DeviceAttrData deviceAttrData = new DeviceAttrData();
            deviceAttrData.setMessageId(message.get("id").toString());
            deviceAttrData.setProductId(productModelAttr.getProductId());
            deviceAttrData.setDeviceId(deviceInfo.getId());
            deviceAttrData.setModelAttrId(productModelAttr.getId());
            deviceAttrData.setDataTypeId(productModelAttr.getDataTypeId());
            deviceAttrData.setDataValue(payload.get(productModelAttr.getIdentifier()).toString());
            deviceAttrData.setStatus("1");
            deviceAttrDataMapper.insert(deviceAttrData);
        });
        //保存设备的操作日志
        DeviceOptionLog deviceOptionLog = new DeviceOptionLog();
        deviceOptionLog.setProductId(deviceInfo.getProductId());
        deviceOptionLog.setDeviceId(deviceInfo.getId());
        deviceOptionLog.setMessageId(message.get("id").toString());
        deviceOptionLog.setOptionType("1");
        deviceOptionLog.setTopic(message.get("topic").toString());
        deviceOptionLog.setRequestParams(message.toJSONString());
        deviceOptionLog.setRequestTime(new Date());
        //属性设置直接保存完数据就算结束!!!
        deviceOptionLog.setIsFinish("1");
        deviceOptionLog.setStatus("1");
        deviceOptionLog.setDimensionTime(new Date());
        //保存设备的操作日志
        deviceOptionLogMapper.insert(deviceOptionLog);
        //响应websocket,显示在线日志
        String pageId = payload.get("pageId").toString();
        Session session = WebSocketLocalContainerUtil.getSession(pageId);
        if(session != null){
            deviceOptionLog.setDeviceName(deviceInfo.getName());
            WebSocketLocalContainerUtil.sendMsg(pageId, JSONObject.toJSONString(deviceOptionLog));
        }
    }
}
