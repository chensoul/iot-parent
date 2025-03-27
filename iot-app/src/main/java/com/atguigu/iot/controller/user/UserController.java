package com.atguigu.iot.controller.user;

import com.atguigu.iot.common.result.Result;
import com.atguigu.iot.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * 微信小程序登录的控制层
 */
@RestController
@RequestMapping(value = "/iot-api/user/userInfo")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 小程序登录
     * @param code
     * @return
     */
    @GetMapping(value = "/wxLogin/{code}")
    public Result wxLogin(@PathVariable(value = "code") String code){
        return Result.ok(userInfoService.wxLogin(code));
    }

    /**
     * 查询用户信息接口
     * @return
     */
    @GetMapping(value = "/getLoginUserInfo")
    public Result getLoginUserInfo(){
        return Result.ok(userInfoService.getLoginUserInfo());
    }
}
