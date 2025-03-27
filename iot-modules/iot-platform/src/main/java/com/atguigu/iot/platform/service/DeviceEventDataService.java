package com.atguigu.iot.platform.service;

import com.alibaba.fastjson2.JSONObject;

/***
 * 设备事件上报的相关接口
 */
public interface DeviceEventDataService {

    /**
     * 保存设备的上报事件
     * @param message
     */
    void saveDeviceEventData(JSONObject message);

    /**
     * 修改设备的事件上报的操作日志,为完成
     * @param message
     */
    void updateDeviceEventData(JSONObject message);
}
