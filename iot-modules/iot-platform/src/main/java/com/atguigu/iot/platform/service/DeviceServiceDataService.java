package com.atguigu.iot.platform.service;

import com.alibaba.fastjson2.JSONObject;

/***
 * 设备服务调用的接口类
 */
public interface DeviceServiceDataService {
    /**
     * 记录设备的服务调用
     * @param message
     */
    void saveDeviceServiceData(JSONObject message);

    /**
     * 修改服务调用上报的状态为结束
     * @param message
     */
    void updateDeviceServiceData(JSONObject message);
}
