package com.atguigu.iot.lock.constant;

public class LockConstants {

    //客户端上下线事件
    public final static String EVENT_CONNECTD = "client.connected";
    public final static String EVENT_DISCONNECTD = "client.disconnected";

    //客户端订阅与取消订阅事件
    public final static String TEVENT_SUBSCRIBED = "session.subscribed";
    public final static String EVENT_UNSUBSCRIBED = "session.unsubscribed";

    public final static String EVENT_PUBLISH = "message.publish";

    //属性设置
    public final static String TOPIC_PROPERTY_SET = "sys/{0}/{1}/property/set";

    //属性上报
    public final static String TOPIC_PROERTY_POST = "sys/{0}/{1}/property/post";
    public final static String TOPIC_PROERTY_POST_REPLY = "sys/{0}/{1}/property/post_reply";

    //事件上报
    public final static String TOPIC_EVENT_POST = "sys/{0}/{1}/event/{2}/post";
    public final static String TOPIC_EVENT_POST_REPLY = "sys/{0}/{1}/event/{2}/post_reply";

    //服务调用
    public final static String TOPIC_SERVICE = "sys/{0}/{1}/service/{2}";
    public final static String TOPIC_SERVICE_REPLY = "sys/{0}/{1}/service/{2}/reply";

    public final static String TOPIC_CUSTOM = "custom/{0}/{1}/{2}";

    //锁属性：电量
    public static final String ATTR_ELECTRIC = "Electric";
}
