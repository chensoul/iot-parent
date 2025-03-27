package com.atguigu.iot.web.config.interceptor;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.jwt.JWTUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/***
 * 定义个sa-token框架的拦截器
 */
@Configuration
public class GuiguSaTokenConfigure implements WebMvcConfigurer {

    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册 Sa-Token 拦截器，校验规则为 StpUtil.checkLogin() 登录校验。
        registry.addInterceptor(new SaInterceptor(handle ->{
                    //sa框架校验登录
                    StpUtil.checkLogin();
                    //自定义校验
                    checkToken();
                   }))
                .addPathPatterns("/**")//所有的路径都进行登录校验
                .excludePathPatterns("/system/auth/login",//放行登录接口
                        "/system/auth/generateValidateCode",//放行验证码接口
                        "/doc.html", "/v3/api-docs/**", "/webjars/**",//放行swagger相关接口
                        "/platform/websocket/**",//放行websocket
                        "/iot-api/user/userInfo/wxLogin/**",//放行app登录
                        "/platform/emqx/**", "/webhook/**");//设备认证的接口进行放行
    }

    /**
     * 校验token是否合法
     */
    private void checkToken() {
        //获取到token
        String tokenValue = StpUtil.getTokenInfo().getTokenValue();
        //使用jwt工具校验这个token是否合法
        if(!JWTUtil.verify(tokenValue, "shangguigu".getBytes())){
            throw new NotLoginException("非法请求", "-1", "logincheck");
        }
    }
}