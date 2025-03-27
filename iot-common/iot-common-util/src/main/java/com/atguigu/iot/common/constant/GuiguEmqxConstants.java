package com.atguigu.iot.common.constant;

import java.text.MessageFormat;

/***
 * emqx的事件常量定义
 */
public class GuiguEmqxConstants {
    
    //客户端上线事件
    public final static String EVENT_CONNECTD = "client.connected";
    //客户端下线事件
    public final static String EVENT_DISCONNECTD = "client.disconnected";
    //客户端订阅事件
    public final static String TEVENT_SUBSCRIBED = "session.subscribed";
    //客户端订取消订阅事件
    public final static String EVENT_UNSUBSCRIBED = "session.unsubscribed";
    //平台自定义事件
    public final static String EVENT_PUBLISH = "message.publish";

    //属性设置
    public final static String TOPIC_PROPERTY_SET = "sys/{0}/{1}/property/set";
    //属性上报
    public final static String TOPIC_PROERTY_POST = "sys/{0}/{1}/property/post";
    //属性上报响应
    public final static String TOPIC_PROERTY_POST_REPLY = "sys/{0}/{1}/property/post_reply";
    //事件上报
    public final static String TOPIC_EVENT_POST = "sys/{0}/{1}/event/{2}/post";
    //事件上报响应
    public final static String TOPIC_EVENT_POST_REPLY = "sys/{0}/{1}/event/{2}/post_reply";
    //服务调用 : sys/im5ev3616a/nkrtfj13ugc34x5/service/AddTemp
    public final static String TOPIC_SERVICE = "sys/{0}/{1}/service/{2}";
    //服务调用响应
    public final static String TOPIC_SERVICE_REPLY = "sys/{0}/{1}/service/{2}/reply";
    //自定义
    public final static String TOPIC_CUSTOM = "custom/{0}/{1}/{2}";
}
