package com.atguigu.iot.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "wechat.login")
@Data
public class WxPropertiesConfig {
    //小程序id
    private String appId;
    //小程序的秘钥
    private String appSecret;
}
