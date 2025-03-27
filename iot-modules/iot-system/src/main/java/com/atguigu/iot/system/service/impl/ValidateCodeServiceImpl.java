package com.atguigu.iot.system.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.core.lang.Snowflake;
import com.atguigu.iot.system.service.ValidateCodeService;
import com.atguigu.iot.system.util.IpUtil;
import com.atguigu.iot.system.vo.ValidateCodeVo;
import com.atguigu.iot.web.execption.GuiguException;
import io.minio.credentials.Jwt;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/***
 * 验证码相关的接口类的实现类
 */
@Service
public class ValidateCodeServiceImpl implements ValidateCodeService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private Snowflake snowFlag;

    /**
     * 验证码生成方法
     * @param request
     * @return
     */
    @Override
    public Object generateValidateCode(HttpServletRequest request) {
        //获取客户端的ip地址
        String clientIP = IpUtil.getIpAddress(request);
        //判断这个用户有没有生成过验证码: 10s只能生成一个: setnx -->key存在-->false key不存在--->true
        Boolean flag =
                redisTemplate.opsForValue().setIfAbsent(clientIP, 1, 10, TimeUnit.SECONDS);
        if(!flag){
            //10s内反复申请
            throw new GuiguException(201, "验证码的刷新频率太高!");
        }
        //直接生成一个验证码
        CircleCaptcha circleCaptcha =
                CaptchaUtil.createCircleCaptcha(150, 48, 4, 20);
        //获取到验证码的值
        String code = circleCaptcha.getCode();
        //获取验证码图片
        String imageBase64Data = circleCaptcha.getImageBase64Data();
        //生成随机数
        String replace = snowFlag.nextIdStr();
        //存储这个验证码的值,用于后续用户登录的时候校验: 验证码的有效期是5分钟
        redisTemplate.opsForValue().set(replace, code, 5, TimeUnit.MINUTES);
        //初始化
        ValidateCodeVo validateCodeVo = new ValidateCodeVo();
        validateCodeVo.setCodeKey(replace);
        validateCodeVo.setCodeValue(imageBase64Data);
        //返回
        return validateCodeVo;
    }
}
