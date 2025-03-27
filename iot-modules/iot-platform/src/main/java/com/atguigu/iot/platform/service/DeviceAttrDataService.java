package com.atguigu.iot.platform.service;

import com.alibaba.fastjson2.JSONObject;

/***
 * 设备属性操作的服务接口类
 */
public interface DeviceAttrDataService {


    /**
     * 保存设备的属性操作
     * @param message
     */
    void saveDeviceAttrData(JSONObject message);

    /**
     * 属性上报响应的操作结束掉
     * @param message
     */
    void updateDeviceAttrData(JSONObject message);

    /**
     * 属性设置
     * @param message
     */
    void propertiesSet(JSONObject message);
}
