package com.atguigu.iot.platform.handler;

import com.alibaba.fastjson2.JSONObject;
import com.atguigu.iot.common.constant.GuiguEmqxConstants;
import com.atguigu.iot.platform.emqx.GuiguEmqx;
import com.atguigu.iot.platform.service.DeviceAttrDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * 属性上报的实现类
 */
@Service
@GuiguEmqx(event = GuiguEmqxConstants.TOPIC_PROERTY_POST)
public class PropertiesPostHandler implements MessageHandler {


    @Autowired
    private DeviceAttrDataService deviceAttrDataService;



    /**
     * 具体事先和消息的处理方法逻辑
     *
     * @param message
     */
    @Override
    public void handleMessage(JSONObject message) {
        //记录设备的属性操作
        deviceAttrDataService.saveDeviceAttrData(message);
    }
}
