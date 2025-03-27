package com.atguigu.iot.controller.platform;

import com.atguigu.iot.common.result.Result;
import com.atguigu.iot.platform.query.AuthQuery;
import com.atguigu.iot.platform.query.AuthorizeQuery;
import com.atguigu.iot.platform.service.DeviceInfoService;
import com.atguigu.iot.platform.vo.AuthVo;
import com.atguigu.iot.platform.vo.AuthorizeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * emqx服务器使用的控制层: 认证+授权
 */
@RestController
@RequestMapping(value = "/platform/emqx")
public class EmqxController {


    @Autowired
    private DeviceInfoService deviceInfoService;

    /***
     * emqx设备接入认证
     * @param authQuery
     * @return
     */
    @PostMapping(value = "/auth")
    public AuthVo auth(@RequestBody AuthQuery authQuery){
        return deviceInfoService.auth(authQuery);
    }

    /**
     * 授权
     * @return
     */
    @PostMapping(value = "/authorize")
    public AuthorizeVo authorize(@RequestBody AuthorizeQuery authorizeQuery){
        return deviceInfoService.authorize(authorizeQuery);
    }
}
