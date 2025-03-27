package com.atguigu.iot.platform.handler;

import cn.hutool.core.util.ReUtil;
import com.atguigu.iot.common.constant.GuiguEmqxConstants;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/***
 * 平台消息的接口类
 */
@Service
public class MessageServiceHandlerFactoryImpl implements MessageServiceHandlerFactory,
        ApplicationContextAware {

    //私有的全局变量,存储MessageHandler的所有的实现类, key=事件 value=实现类
    private Map<String, MessageHandler> messageHandlerMap = new ConcurrentHashMap<>();
    /**
     * 在项目启动完成以后,spring的容器将所有的bean都保存到容器以后,触发这个方法
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //获取MessageHandler类型的所有的bean
        messageHandlerMap = applicationContext.getBeansOfType(MessageHandler.class);
    }

    /**
     * 根据事件获取具体的实现类
     *
     * @param topic
     * @return
     */
    @Override
    public MessageHandler getHandler(String topic) {
        //实现类的名字去进行获取: sys/im5ev3616a/nkrtfj13ugc34x5/service/AddTemp
        //属性设置匹配
        String format =
                MessageFormat.format(GuiguEmqxConstants.TOPIC_PROPERTY_SET,
                        "[A-Za-z0-9]+",
                        "[A-Za-z0-9]+");
        if(ReUtil.isMatch(format, topic)){
            return messageHandlerMap.get("propertiesSetHandler");
        }
        //属性上报
        format =
                MessageFormat.format(GuiguEmqxConstants.TOPIC_PROERTY_POST,
                        "[A-Za-z0-9]+",
                        "[A-Za-z0-9]+");
        if(ReUtil.isMatch(format, topic)){
            return messageHandlerMap.get("propertiesPostHandler");
        }
        //属性上报响应
        format = MessageFormat.format(GuiguEmqxConstants.TOPIC_PROERTY_POST_REPLY,
                        "[A-Za-z0-9]+",
                        "[A-Za-z0-9]+");
        if(ReUtil.isMatch(format, topic)){
            return messageHandlerMap.get("propertiesPostReplyHandler");
        }
        //事件上报
        format = MessageFormat.format(GuiguEmqxConstants.TOPIC_EVENT_POST,
                "[A-Za-z0-9]+",
                "[A-Za-z0-9]+",
                "[A-Za-z0-9]+");
        if(ReUtil.isMatch(format, topic)){
            return messageHandlerMap.get("eventPostHandler");
        }
        //事件上报响应
        format = MessageFormat.format(GuiguEmqxConstants.TOPIC_EVENT_POST_REPLY,
                "[A-Za-z0-9]+",
                "[A-Za-z0-9]+",
                "[A-Za-z0-9]+");
        if(ReUtil.isMatch(format, topic)){
            return messageHandlerMap.get("eventPostReplyHandler");
        }
        //服务上报: sys/[A-Za-z0-9]/[A-Za-z0-9]/service/[A-Za-z0-9]
        format = MessageFormat.format(GuiguEmqxConstants.TOPIC_SERVICE,
                        "[A-Za-z0-9]+",
                        "[A-Za-z0-9]+",
                        "[A-Za-z0-9]+");
        if(ReUtil.isMatch(format, topic)){
            //返回服务上报的实现类
            return messageHandlerMap.get("servicePostHandler");
        }
        //服务上报响应
        format = MessageFormat.format(GuiguEmqxConstants.TOPIC_SERVICE_REPLY,
                "[A-Za-z0-9]+",
                "[A-Za-z0-9]+",
                "[A-Za-z0-9]+");
        if(ReUtil.isMatch(format, topic)){
            //返回服务上报的实现类
            return messageHandlerMap.get("servicePostReplyHandler");
        }
        return null;
    }
}
