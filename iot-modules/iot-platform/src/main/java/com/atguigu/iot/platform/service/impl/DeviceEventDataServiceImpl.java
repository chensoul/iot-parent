package com.atguigu.iot.platform.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.atguigu.iot.common.constant.GuiguEmqxConstants;
import com.atguigu.iot.platform.emqx.EmqxConfig;
import com.atguigu.iot.platform.mapper.DeviceEventDataMapper;
import com.atguigu.iot.platform.mapper.DeviceInfoMapper;
import com.atguigu.iot.platform.mapper.DeviceOptionLogMapper;
import com.atguigu.iot.platform.mapper.ProductModelEventMapper;
import com.atguigu.iot.platform.pojo.*;
import com.atguigu.iot.platform.service.DeviceEventDataService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Date;

/***
 * 设备事件上报的相关接口的实现类
 */
@Service
public class DeviceEventDataServiceImpl implements DeviceEventDataService {

    @Autowired
    private DeviceInfoMapper deviceInfoMapper;

    @Autowired
    private ProductModelEventMapper productModelEventMapper;

    @Autowired
    private DeviceEventDataMapper deviceEventDataMapper;

    @Autowired
    private DeviceOptionLogMapper deviceOptionLogMapper;

    @Autowired
    private EmqxConfig emqxConfig;

    /**
     * 保存设备的上报事件
     *
     * @param message
     */
    @Override
    public void saveDeviceEventData(JSONObject message) {
        //获取topic
        String topic = message.get("topic").toString();
        //对主题进行切分
        String[] split = topic.split("/");
        //获取clientid
        String clientid = split[2];
        //查询设备的信息
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
        //获取本次事件的标识符
        String identifier = split[4];
        //获取产品的事件的信息
        ProductModelEvent productModelEvent =
                productModelEventMapper.selectOne(
                        new LambdaQueryWrapper<ProductModelEvent>()
                                .eq(ProductModelEvent::getProductId, productId)
                                .eq(ProductModelEvent::getIdentifier, identifier)
                                .eq(ProductModelEvent::getStatus, "1"));
        if(productModelEvent == null){
            return;
        }
        //获取消息的id
        String messageId = message.get("id").toString();
        //保存设备的事件信息
        DeviceEventData deviceEventData = new DeviceEventData();
        deviceEventData.setMessageId(messageId);
        deviceEventData.setProductId(productId);
        deviceEventData.setDeviceId(deviceInfo.getId());
        deviceEventData.setModelEventId(productModelEvent.getId());
        //获取本次上报的信息内容
        deviceEventData.setOutputValues(message.get("payload").toString());
        deviceEventData.setStatus("1");
        //保存设备事件到数据库
        deviceEventDataMapper.insert(deviceEventData);
        //记录设备的操作日志
        DeviceOptionLog deviceOptionLog = new DeviceOptionLog();
        deviceOptionLog.setProductId(deviceInfo.getProductId());
        deviceOptionLog.setDeviceId(deviceInfo.getId());
        deviceOptionLog.setMessageId(messageId);
        deviceOptionLog.setOptionType("2");
        deviceOptionLog.setTopic(message.get("topic").toString());
        deviceOptionLog.setRequestParams(message.toJSONString());
        deviceOptionLog.setRequestTime(new Date());
        deviceOptionLog.setIsFinish("0");
        deviceOptionLog.setStatus("1");
        deviceOptionLog.setDimensionTime(new Date());
        //保存设备的操作日志
        deviceOptionLogMapper.insert(deviceOptionLog);
        //响应EMQX服务器,告诉它属性上报完成: 1.连接上EMQX 2.发送消息
        String replyTopic = GuiguEmqxConstants.TOPIC_EVENT_POST_REPLY;
        //转换
        replyTopic = MessageFormat.format(replyTopic, split[1], split[2], split[4]);
        //发送消息
        emqxConfig.sendMessage(replyTopic, messageId);
    }

    /**
     * 修改设备的事件上报的操作日志,为完成
     *
     * @param message
     */
    @Override
    public void updateDeviceEventData(JSONObject message) {
        //获取本次响应的数据
        String messageId = message.get("payload").toString();
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
    }
}
