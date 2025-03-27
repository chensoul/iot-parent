package com.atguigu.iot.user.service;

import com.atguigu.iot.user.pojo.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/***
 * 用户相关的操作接口类
 */
public interface UserInfoService extends IService<UserInfo> {

    /**
     * 小程序登录
     * @param code
     * @return
     */
    String wxLogin(String code);

    /**
     * 查询用户信息接口
     * @return
     */
    Object getLoginUserInfo();

}
