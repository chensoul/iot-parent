package com.atguigu.iot.platform.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.atguigu.iot.common.constant.GuiguEmqxConstants;
import com.atguigu.iot.platform.emqx.EmqxConfig;
import com.atguigu.iot.platform.mapper.*;
import com.atguigu.iot.platform.pojo.*;
import com.atguigu.iot.platform.service.DeviceServiceDataService;
import com.atguigu.iot.platform.util.WebSocketLocalContainerUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.websocket.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Date;

/***
 * 设备服务调用的接口类的实现类
 */
@Service
public class DeviceServiceDataServiceImpl implements DeviceServiceDataService {

    @Autowired
    private DeviceInfoMapper deviceInfoMapper;

    @Autowired
    private ProductModelServiceMapper productModelServiceMapper;

    @Autowired
    private DeviceServiceDataMapper deviceServiceDataMapper;

    @Autowired
    private DeviceOptionLogMapper deviceOptionLogMapper;

    @Autowired
    private EmqxConfig emqxConfig;

    @Autowired
    private ProductInfoMapper productInfoMapper;

    /**
     * 记录设备的服务调用
     *
     * @param message
     */
    @Override
    public void saveDeviceServiceData(JSONObject message) {
        //获取topic
        String topic = message.get("topic").toString();
        //对主题进行切分
        String[] split = topic.split("/");
        //获取clientid
        String clientid = split[2];
        //查询设备
        DeviceInfo deviceInfo =
                deviceInfoMapper.selectOne(
                        new LambdaQueryWrapper<DeviceInfo>()
                                .eq(DeviceInfo::getClientId, clientid)
                                .eq(DeviceInfo::getStatus, "1"));
        if(deviceInfo == null){
            return;
        }
        //获取产品的id
        Long productId = deviceInfo.getProductId();
        //获取产品的服务信息
        ProductModelService productModelService =
                productModelServiceMapper.selectOne(
                        new LambdaQueryWrapper<ProductModelService>()
                                .eq(ProductModelService::getProductId, productId)
                                .eq(ProductModelService::getIdentifier, split[4])
                                .eq(ProductModelService::getStatus, "1"));
        if(productModelService == null){
            return;
        }
        //获取消息的id
        String messageId = message.get("id").toString();
        //记录设备的服务调用的信息
        DeviceServiceData deviceServiceData = new DeviceServiceData();
        deviceServiceData.setMessageId(messageId);
        deviceServiceData.setProductId(productId);
        deviceServiceData.setDeviceId(deviceInfo.getId());
        deviceServiceData.setModelServiceId(productModelService.getId());
        deviceServiceData.setInputValues(message.get("payload").toString());
        deviceServiceData.setStatus("1");
        //保存设备服务的调用信息
        deviceServiceDataMapper.insert(deviceServiceData);
        //记录设备的操作日志
        DeviceOptionLog deviceOptionLog = new DeviceOptionLog();
        deviceOptionLog.setProductId(deviceInfo.getProductId());
        deviceOptionLog.setDeviceId(deviceInfo.getId());
        deviceOptionLog.setMessageId(messageId);
        deviceOptionLog.setOptionType("3");
        deviceOptionLog.setTopic(message.get("topic").toString());
        deviceOptionLog.setRequestParams(message.toJSONString());
        deviceOptionLog.setRequestTime(new Date());
        deviceOptionLog.setIsFinish("0");
        deviceOptionLog.setStatus("1");
        deviceOptionLog.setDimensionTime(new Date());
        //保存设备的操作日志
        deviceOptionLogMapper.insert(deviceOptionLog);
        //获取pageid
        JSONObject payload = JSONObject.parseObject(message.get("payload").toString());
        String pageId = null;
        if(payload.get("pageId") != null){
            pageId = payload.get("pageId").toString();
            //查询产品的信息
            ProductInfo productInfo = productInfoMapper.selectById(productId);
            //判断是否websocket还在连接
            Session session = WebSocketLocalContainerUtil.getSession(pageId);
            if(session != null){
                deviceOptionLog.setDeviceName(deviceInfo.getName());
                deviceOptionLog.setProductName(productInfo.getName());
                WebSocketLocalContainerUtil.sendMsg(pageId, JSONObject.toJSONString(deviceOptionLog));
            }
        }
        //响应EMQX服务器,告诉它属性上报完成: 1.连接上EMQX 2.发送消息
        String replyTopic = GuiguEmqxConstants.TOPIC_SERVICE_REPLY;
        //转换
        replyTopic = MessageFormat.format(replyTopic, split[1], split[2], split[4]);
        //发送消息
        emqxConfig.sendMessage(replyTopic, messageId + ":" + pageId);
    }

    /**
     * 修改服务调用上报的状态为结束
     *
     * @param message
     */
    @Override
    public void updateDeviceServiceData(JSONObject message) {
        String[] payload = message.get("payload").toString().split(":");
        //获取本次响应的数据
        String messageId =payload[0];
        //查询这条消息的处理记录
        DeviceOptionLog deviceOptionLog =
                deviceOptionLogMapper.selectOne(
                        new LambdaQueryWrapper<DeviceOptionLog>()
                                .eq(DeviceOptionLog::getStatus, "1")
                                .eq(DeviceOptionLog::getMessageId, messageId)
                                .eq(DeviceOptionLog::getIsFinish, "0")
                                .last("limit 1"));
        if(deviceOptionLog == null){
            return;
        }
        //修改为完成
        deviceOptionLog.setIsFinish("1");
        deviceOptionLog.setResponseData(message.toJSONString());
        deviceOptionLog.setResponseTime(new Date());
        deviceOptionLog.setResponseCode("0");
        deviceOptionLogMapper.updateById(deviceOptionLog);
        //判断是否websocket还在连接
        if(payload.length>1){
            //查询设备
            DeviceInfo deviceInfo = deviceInfoMapper.selectById(deviceOptionLog.getDeviceId());
            //查询产品
            ProductInfo productInfo = productInfoMapper.selectById(deviceInfo.getProductId());
            String pageId = payload[1];
            Session session = WebSocketLocalContainerUtil.getSession(pageId);
            if(session != null){
                deviceOptionLog.setDeviceName(deviceInfo.getName());
                deviceOptionLog.setProductName(productInfo.getName());
                WebSocketLocalContainerUtil.sendMsg(pageId, JSONObject.toJSONString(deviceOptionLog));
            }
        }

    }
}
