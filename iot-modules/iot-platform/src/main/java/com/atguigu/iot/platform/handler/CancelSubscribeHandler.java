package com.atguigu.iot.platform.handler;

import com.alibaba.fastjson2.JSONObject;
import com.atguigu.iot.common.constant.GuiguEmqxConstants;
import com.atguigu.iot.platform.emqx.GuiguEmqx;
import com.atguigu.iot.platform.service.DeviceSubscribeTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * 取消订阅事件处理的实现类
 */
@Service
@GuiguEmqx(event = GuiguEmqxConstants.EVENT_UNSUBSCRIBED)
public class CancelSubscribeHandler implements MessageHandler {

    @Autowired
    private DeviceSubscribeTopicService deviceSubscribeTopicService;

    /**
     * 取消订阅事件处理
     *
     * @param message
     */
    @Override
    public void handleMessage(JSONObject message) {
        deviceSubscribeTopicService.saveDeviceSubscribeTopic(
                GuiguEmqxConstants.EVENT_UNSUBSCRIBED,
                message);
    }
}
