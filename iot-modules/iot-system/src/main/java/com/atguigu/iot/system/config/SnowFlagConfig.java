package com.atguigu.iot.system.config;

import cn.hutool.core.lang.Snowflake;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 * 雪花算法的配置类的初始化
 */
@Configuration
public class SnowFlagConfig {

    /**
     * 雪花算法的bean
     * @return
     */
    @Bean
    public Snowflake snowFlag(){
        return new Snowflake(01, 01);
    }
}
