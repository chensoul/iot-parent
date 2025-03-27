package com.atguigu.iot.user.config;

import cn.dev33.satoken.strategy.SaStrategy;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.signers.AlgorithmUtil;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

/***
 * sa-token风格自定义
 */
@Configuration
public class SaTokenConfigure {

    /**
     * 自定义token风格
     */
    @PostConstruct
    public void rewriteSaStrategy() {
        // 重写 Token 生成策略
        SaStrategy.instance.createToken = (loginId, loginType) -> {
            return JWT.create()
                    .setPayload("userId", loginId)//载荷: 不要存储敏感数据: 密码 手机号 邮箱
                    .setSigner(AlgorithmUtil.getAlgorithm("HS256"), "shangguigu".getBytes())//签名: 算法+盐
                    .sign();
        };
    }

}
