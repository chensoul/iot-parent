package com.atguigu.iot.platform.handler;

/***
 * 通过事件的event属性获取具体的实现类是哪个,返回操作-->
 */
public interface EventServiceHandlerFactory {

    /**
     * 根据事件获取具体的实现类
     * @param event
     * @return
     */
    public MessageHandler getHandler(String event);
}
