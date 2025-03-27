package com.atguigu.iot.platform.service;

import com.alibaba.fastjson2.JSONObject;
import com.atguigu.iot.platform.pojo.DeviceSubscribeTopic;
import com.baomidou.mybatisplus.extension.service.IService;

/***
 * 设备订阅topic的接口类
 */
public interface DeviceSubscribeTopicService extends IService<DeviceSubscribeTopic> {
    /**
     * 保存设备订阅和取消订阅的topic事件
     * @param event
     * @param message
     */
    void saveDeviceSubscribeTopic(String event, JSONObject message);
}
