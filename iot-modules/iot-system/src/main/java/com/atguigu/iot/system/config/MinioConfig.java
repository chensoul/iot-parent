package com.atguigu.iot.system.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "minio")
@Data
public class MinioConfig {
    //minio的ip和端口
    private String endpointUrl;
    //用户名
    private String accessKey;
    //密码
    private String secretKey;
    //桶名
    private String bucketName;
}
