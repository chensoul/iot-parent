package com.atguigu.iot.platform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/***
 * 对websocket进行初始化配置
 */
@Configuration
public class WebsocketConfig {

    /**
     * websocket的bean对象初始化
     * @return
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
