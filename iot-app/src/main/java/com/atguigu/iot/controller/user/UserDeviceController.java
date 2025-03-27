package com.atguigu.iot.controller.user;

import cn.dev33.satoken.stp.StpUtil;
import com.atguigu.iot.common.result.Result;
import com.atguigu.iot.user.pojo.UserDevice;
import com.atguigu.iot.user.service.UserDeviceService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * 用户设备查询的接口控制层
 */
@RestController
@RequestMapping(value = "/iot-api/user/userDevice")
public class UserDeviceController {

    @Autowired
    private UserDeviceService userDeviceService;

    /**
     * 查询用户的设备列表
     * @return
     */
    @GetMapping(value = "/list")
    public Result list(){
        return Result.ok(userDeviceService.list(
                new LambdaQueryWrapper<UserDevice>()
                        .eq(UserDevice::getUserId, StpUtil.getLoginIdAsLong())
                        .eq(UserDevice::getStatus, "1")));
    }
}
