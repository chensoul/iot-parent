package com.atguigu.iot.controller.webhook;

import com.alibaba.fastjson2.JSONObject;
import com.atguigu.iot.platform.handler.EventPublishHandler;
import com.atguigu.iot.platform.handler.EventServiceHandlerFactory;
import com.atguigu.iot.platform.handler.MessageHandler;
import com.atguigu.iot.platform.handler.MessageServiceHandlerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * 数据集成的控制层
 */
@Slf4j
@RestController
@RequestMapping(value = "/webhook")
public class WebhookController {

    @Autowired
    private EventPublishHandler eventPublishHandler;

    @Autowired
    private EventServiceHandlerFactory eventServiceHandlerFactory;


    /**
     * 系统事件的监听
     *
     * @param eventJson
     * @return
     */
    @PostMapping(value = "/event")
    public ResponseEntity event(@RequestBody JSONObject eventJson) {
        //获取事件的内容
        String event = eventJson.get("event").toString();
        //根据不同的event,获取不同的实现类来处理这个事件
        MessageHandler messageHandler = eventServiceHandlerFactory.getHandler(event);
        //判断非空
        if (messageHandler != null) {
            //业务处理
            messageHandler.handleMessage(eventJson);
            //通知app端
            eventPublishHandler.handleMessage(eventJson);
        }
        return new ResponseEntity("ok", HttpStatus.OK);
    }


    @Autowired
    private MessageServiceHandlerFactory messageServiceHandlerFactory;

    /**
     * 平台消息集成
     *
     * @param message
     * @return
     */
    @PostMapping(value = "/message")
    public ResponseEntity message(@RequestBody JSONObject message) {
        log.info("message: {}", message);
        //获取当前消息的topic:  sys/im5ev3616a/nkrtfj13ugc34x5/service/AddTemp
        String topic = message.get("topic").toString();
        //获取具体的实现类是哪个
        MessageHandler messageHandler =
                messageServiceHandlerFactory.getHandler(topic);
        //非空
        if (messageHandler != null) {
            //处理平台消息
            messageHandler.handleMessage(message);
            //通知app端
            eventPublishHandler.handleMessage(message);
        }
        return new ResponseEntity("ok", HttpStatus.OK);
    }
}
