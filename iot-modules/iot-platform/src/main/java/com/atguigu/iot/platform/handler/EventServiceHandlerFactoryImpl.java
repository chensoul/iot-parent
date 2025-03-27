package com.atguigu.iot.platform.handler;

import com.atguigu.iot.platform.emqx.GuiguEmqx;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class EventServiceHandlerFactoryImpl implements EventServiceHandlerFactory,
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
        Map<String, MessageHandler> beansOfType =
                applicationContext.getBeansOfType(MessageHandler.class);
        //遍历获取所有bean
        beansOfType.entrySet().stream().forEach(bean->{
            //获取每个bean对象
            MessageHandler messageHandler = bean.getValue();
            //获取自定义的注解
            GuiguEmqx guiguEmqx = messageHandler.getClass().getAnnotation(GuiguEmqx.class);
            //获取注解的event的值
            String event = guiguEmqx.event();
            //保存
            messageHandlerMap.put(event, messageHandler);
        });
    }

    /**
     * 根据事件获取具体的实现类
     *
     * @param event
     * @return
     */
    @Override
    public MessageHandler getHandler(String event) {
        return messageHandlerMap.get(event);
    }
}
