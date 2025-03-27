package com.atguigu.iot.controller.websocket;

import com.atguigu.iot.platform.util.WebSocketLocalContainerUtil;
import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

/***
 * 和前端页面保持通讯,实时展示调试数据细节的控制层
 */
@ServerEndpoint(value = "/platform/websocket/{pageId}")
@Component
@Log4j2
public class WebSocketController {

    /**
     * 连接会话
     * @param session
     * @param pageId
     */
    @OnOpen
    public void onOpen(Session session,
                       @PathParam(value = "pageId") String pageId){
        WebSocketLocalContainerUtil.addSession(pageId, session);
        log.info(pageId + "连接上了会话!!!!");
    }


    /**
     * 数据交互
     * @param session
     * @param message
     */
    @OnMessage
    public void onMessage(Session session, String message){
        log.info( "发送了消息,消息的内容为:" + message);
    }


    /**
     * 断开连接
     * @param session
     * @param pageId
     */
    @OnClose
    public void onClose(Session session, @PathParam(value = "pageId") String pageId){
        WebSocketLocalContainerUtil.removeSession(pageId);
        log.info(pageId + "断开了连接!!!!");
    }


    /**
     * 发生错误
     * @param session
     * @param e
     */
    @OnError
    public void nError(Session session, Throwable e){
        e.printStackTrace();
        log.info("发生了错误,错误的内容为:" + e.getMessage());
    }
}
