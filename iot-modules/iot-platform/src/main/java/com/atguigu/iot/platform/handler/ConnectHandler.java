package com.atguigu.iot.platform.handler;

import com.alibaba.fastjson2.JSONObject;
import com.atguigu.iot.common.constant.GuiguEmqxConstants;
import com.atguigu.iot.platform.emqx.GuiguEmqx;
import com.atguigu.iot.platform.service.DeviceConnectLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * 处理设备连接的实现类
 */
@Service
@GuiguEmqx(event = GuiguEmqxConstants.EVENT_CONNECTD)
public class ConnectHandler implements MessageHandler {

    @Autowired
    private DeviceConnectLogService deviceConnectLogService;

    /**
     * 设备连接处理
     *
     * @param message
     */
    @Override
    public void handleMessage(JSONObject message) {
        deviceConnectLogService.saveDeviceConnectLog(GuiguEmqxConstants.EVENT_CONNECTD, message);
    }
}
