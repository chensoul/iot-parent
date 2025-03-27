package com.atguigu.iot.system.service;

import jakarta.servlet.http.HttpServletRequest;

/***
 * 验证码相关的接口类
 */
public interface ValidateCodeService {
    /**
     * 验证码生成方法
     * @param request
     * @return
     */
    Object generateValidateCode(HttpServletRequest request);
}
