package com.atguigu.iot.platform.handler;


import com.alibaba.fastjson2.JSONObject;

/***
 * 处理系统事件和平台消息的接口类: 为不同的事件和不同的消息创建不同的实现类
 */
public interface MessageHandler {

    /**
     *  具体事先和消息的处理方法逻辑
     * @param message
     */
    void handleMessage(JSONObject message);
}
