package com.atguigu.iot.lock.consumer;

import cn.hutool.core.util.ReUtil;
import com.alibaba.fastjson2.JSONObject;
import com.atguigu.iot.lock.constant.LockConstants;
import com.atguigu.iot.lock.service.LockAttrDataService;
import com.atguigu.iot.lock.service.LockOptionLogService;
import com.atguigu.iot.web.user.UserDeviceInterface;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

/***
 * app端接受中控平台传递的两种消息: 1.SYS-系统事件 2.IOT-平台消息
 */
@Component
@Log4j2
public class LockConsumer {

    @Autowired
    private UserDeviceInterface userDeviceInterface;


    /**
     * 系统事件监听
     * @param content
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(name = "sys_event_iot_exchange", durable = "true"),
            value = @Queue(name = "sys_event_queue", durable = "true"),
            key = "sys"))
    public void sysEventConsumer(String content){
        //将消息转换为json数据
        JSONObject message = JSONObject.parseObject(content);
        //获取客户端的id
        String clientid = message.get("clientid").toString();
        //获取event属性
        String event = message.get("event").toString();
        if(event.equals(LockConstants.EVENT_CONNECTD)){
            //设备连接: 设备修改为在线状态
            userDeviceInterface.updateUserDeviceRunStatus(clientid, "1");
        }else if(event.equals(LockConstants.EVENT_DISCONNECTD)){
            //断开连接: 将设备修改为离线状态
            userDeviceInterface.updateUserDeviceRunStatus(clientid, "0");
        } else{
            //其他未处理的事件
            log.warn("事件未处理:" + content);
        }
    }

    @Autowired
    private LockAttrDataService lockAttrDataService;

    @Autowired
    private LockOptionLogService lockOptionLogService;
    /**
     * 平台消息监听
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(name = "sys_event_iot_exchange", durable = "true"),
            value = @Queue(name = "sys_message_queue", durable = "true"),
            key = "iot"))
    public void sysMessageConsumer(String message){
        try {
            //message反序列化
            JSONObject jsonObject = JSONObject.parseObject(message);
            //获取topic
            String topic = jsonObject.get("topic").toString();
            //获取clientid
            String clientid = jsonObject.get("clientid").toString();
            if(topic.indexOf(clientid) > 0){
                //匹配对象初始化
                String match = MessageFormat.format(LockConstants.TOPIC_PROERTY_POST, "[A-Za-z0-9]+", "[A-Za-z0-9]+");
                //属性上报
                if(ReUtil.isMatch(match, topic)){
                    //记录属性信息
                    lockAttrDataService.saveLockAttrData(clientid, JSONObject.parseObject(jsonObject.get("payload").toString()));
                }
                //事件上报匹配
                match = MessageFormat.format(LockConstants.TOPIC_EVENT_POST, "[A-Za-z0-9]+", "[A-Za-z0-9]+", "[A-Za-z0-9]+");
                if(ReUtil.isMatch(match, topic)){
                    lockOptionLogService.saveLockOptionLog(clientid, jsonObject.get("iotEventName").toString());
                }
            }
        }catch (Exception e){
            log.error("消息未成功处理,消息内容为:" + message);
        }
    }
}
