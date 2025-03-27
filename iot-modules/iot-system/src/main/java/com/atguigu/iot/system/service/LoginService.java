package com.atguigu.iot.system.service;

import com.alibaba.fastjson2.JSONObject;
import com.atguigu.iot.system.vo.LoginVo;
import jakarta.servlet.http.HttpServletRequest;

/***
 * 登录相关的接口类
 */
public interface LoginService {

    /**
     * 登录
     * @param loginVo
     * @return
     */
    JSONObject login(LoginVo loginVo,
                     HttpServletRequest request);
}
