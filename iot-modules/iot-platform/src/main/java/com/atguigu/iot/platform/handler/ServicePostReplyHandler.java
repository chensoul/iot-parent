package com.atguigu.iot.platform.handler;

import com.alibaba.fastjson2.JSONObject;
import com.atguigu.iot.common.constant.GuiguEmqxConstants;
import com.atguigu.iot.platform.emqx.GuiguEmqx;
import com.atguigu.iot.platform.service.DeviceServiceDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * 服务调用响应的实现类
 */
@Service
@GuiguEmqx(event = GuiguEmqxConstants.TOPIC_SERVICE_REPLY)
public class ServicePostReplyHandler implements MessageHandler {

    @Autowired
    private DeviceServiceDataService deviceServiceDataService;
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
            //修改服务调用上报的状态为结束
            deviceServiceDataService.updateDeviceServiceData(message);
        }
    }
}
