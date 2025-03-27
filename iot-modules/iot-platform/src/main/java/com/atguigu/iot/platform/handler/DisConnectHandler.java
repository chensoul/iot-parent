package com.atguigu.iot.platform.handler;

import com.alibaba.fastjson2.JSONObject;
import com.atguigu.iot.common.constant.GuiguEmqxConstants;
import com.atguigu.iot.platform.emqx.GuiguEmqx;
import com.atguigu.iot.platform.service.DeviceConnectLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * 处理设备断开连接的实现类
 */
@Service
@GuiguEmqx(event = GuiguEmqxConstants.EVENT_DISCONNECTD)
public class DisConnectHandler implements MessageHandler {

    @Autowired
    private DeviceConnectLogService deviceConnectLogService;

    /**
     * 设备断开连接处理
     *
     * @param message
     */
    @Override
    public void handleMessage(JSONObject message) {
        deviceConnectLogService.saveDeviceConnectLog(GuiguEmqxConstants.EVENT_DISCONNECTD, message);
    }
}
