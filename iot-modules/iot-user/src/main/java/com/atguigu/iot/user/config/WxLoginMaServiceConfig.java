package com.atguigu.iot.user.config;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.impl.WxMaDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 * 微信小程序登录的工具bean对象的初始化
 */
@Configuration
public class WxLoginMaServiceConfig {

    @Autowired
    private WxPropertiesConfig wxPropertiesConfig;

    /**
     * 小程序登录的工具bean
     * @return
     */
    @Bean
    public WxMaService wxMaService(){
        //配置初始化
        WxMaDefaultConfigImpl wxMaDefaultConfig = new WxMaDefaultConfigImpl();
        wxMaDefaultConfig.setAppid(wxPropertiesConfig.getAppId());
        wxMaDefaultConfig.setSecret(wxPropertiesConfig.getAppSecret());
        wxMaDefaultConfig.setMsgDataFormat("JSON");
        //初始化
        WxMaService wxMaService = new WxMaServiceImpl();
        wxMaService.setWxMaConfig(wxMaDefaultConfig);
        //返回
        return wxMaService;
    }
}
