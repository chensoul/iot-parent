package com.atguigu.iot.platform.util;

import jakarta.websocket.Session;
import lombok.extern.log4j.Log4j2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/***
 * WebSocket工具类
 */
@Log4j2
public class WebSocketLocalContainerUtil {

    //建立pageId与websocket Session的对应关系容器，通过pageId能够获取Session会话信息
    private static Map<String, Session> sessionMap = new ConcurrentHashMap<>();

    public static void addSession(String pageId, Session session) {
        WebSocketLocalContainerUtil.sessionMap.put(pageId, session);
    }

    public static void removeSession(String pageId) {
        WebSocketLocalContainerUtil.sessionMap.remove(pageId);
    }

    public static Session getSession(String pageId) {
        return WebSocketLocalContainerUtil.sessionMap.get(pageId);
    }

    /**
     * 群发消息
     *
     * @param socketMsg
     */
    public static void sendMsg(String pageId, String socketMsg) {
        log.info("发送socket消息：pageId={}，消息={}", pageId, socketMsg);
        Session session = sessionMap.get(pageId);
        if (null != session) {
            session.getAsyncRemote().sendText(socketMsg);//异步发送消息.
        }
    }
}