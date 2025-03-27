package com.atguigu.iot.platform.handler;

import com.alibaba.fastjson2.JSONObject;
import com.atguigu.iot.common.constant.GuiguEmqxConstants;
import com.atguigu.iot.platform.emqx.GuiguEmqx;
import com.atguigu.iot.platform.service.DeviceEventDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * 事件上报的实现类
 */
@Service
@GuiguEmqx(event = GuiguEmqxConstants.TOPIC_EVENT_POST)
public class EventPostHandler implements MessageHandler {

    @Autowired
    private DeviceEventDataService deviceEventDataService;

    /**
     * 具体事先和消息的处理方法逻辑
     *
     * @param message
     */
    @Override
    public void handleMessage(JSONObject message) {
        //获取消息的类型
        String event = message.get("event").toString();
        if(event.equals("message.publish")){
            //保存设备的事件信息
            deviceEventDataService.saveDeviceEventData(message);
        }
    }
}
