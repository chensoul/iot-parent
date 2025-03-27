package com.atguigu.iot.platform.emqx;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "emqx.client")
@Data
public class EmqxProperties {
    private String clientId;
    private String username;
    private String password;
    private String serverURI;
    private String keepAliveInterval;
    private String connectionTimeout;
}
