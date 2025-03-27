package com.atguigu.iot.platform.service;

import com.alibaba.fastjson2.JSONObject;

/***
 * 设备连接日志相关的接口类
 */
public interface DeviceConnectLogService {

    /**
     * 设备连接和断开连接的处理
     * @param event
     * @param message
     */
    void saveDeviceConnectLog(String event, JSONObject message);
}
