package com.atguigu.iot.platform.emqx;

import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson2.JSONObject;
import jakarta.annotation.PostConstruct;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttClientPersistence;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Emqx客户端对象和连接对象初始化
 */
@Component
@Log4j2
public class EmqxConfig {

    //客户端对象
    private MqttClient mqttClient;

    @Autowired
    private EmqxProperties emqxProperties;

    /**
     * 客户端初始化
     */
    @PostConstruct
    public void init(){
        try {
            MqttClientPersistence persistence = new MemoryPersistence();
            mqttClient =
                    new MqttClient(emqxProperties.getServerURI(),
                            emqxProperties.getClientId(),
                            persistence);
        }catch (Exception e){
            e.printStackTrace();
            log.error("初始化MqttClient客户端失败,失败的原因为:" + e.getMessage());
        }
    }

    /**
     * 创建一个连接方法:连接能够自动帮我连接上,若断开就重连,定时任务,每5秒检查一次是否断开了连接
     */
    @Scheduled(fixedDelay = 5000)
    public void mqttClientConnect(){
        try {
            if(!mqttClient.isConnected()){
                //连接参数对象
                MqttConnectOptions connOpts = new MqttConnectOptions();
                connOpts.setUserName(emqxProperties.getUsername());
                connOpts.setPassword(emqxProperties.getPassword().toCharArray());
                connOpts.setKeepAliveInterval(Integer.parseInt(emqxProperties.getKeepAliveInterval()));
                connOpts.setConnectionTimeout(Integer.parseInt(emqxProperties.getConnectionTimeout()));
                connOpts.setCleanSession(true);
                connOpts.setAutomaticReconnect(true);
                //创建连接
                mqttClient.connect(connOpts);
                log.info("连接EMQX服务器成功!!!!");
            }
        }catch (Exception e){
            log.error("连接EMQX服务器失败,失败的原因为:" + e.getMessage() + ",5秒后重新连接!!!");
        }
    }

    /**
     * 给EMQX服务器回复消息
     * @param topic
     * @param message
     */
    @SneakyThrows
    public void sendMessage(String topic, String message){
        //构建消息
        MqttMessage mqttMessage = new MqttMessage();
        mqttMessage.setQos(2);
        mqttMessage.setId(RandomUtil.randomInt(10));
        mqttMessage.setPayload(message.getBytes());
        //发送消息
        mqttClient.publish(topic, mqttMessage);
    }
}
