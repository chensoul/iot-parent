package com.atguigu.iot.platform.handler;

import com.alibaba.fastjson2.JSONObject;
import com.atguigu.iot.common.constant.GuiguEmqxConstants;
import com.atguigu.iot.platform.emqx.GuiguEmqx;
import com.atguigu.iot.platform.service.DeviceSubscribeTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * 订阅事件处理的实现类
 */
@Service
@GuiguEmqx(event = GuiguEmqxConstants.TEVENT_SUBSCRIBED)
public class SubscribeHandler implements MessageHandler {

    @Autowired
    private DeviceSubscribeTopicService deviceSubscribeTopicService;

    /**
     * 订阅事件处理
     *
     * @param message
     */
    @Override
    public void handleMessage(JSONObject message) {
        deviceSubscribeTopicService.saveDeviceSubscribeTopic(
                GuiguEmqxConstants.TEVENT_SUBSCRIBED,
                message);
    }
}
