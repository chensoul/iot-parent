package com.atguigu.iot.controller.system;

import com.atguigu.iot.common.result.Result;
import com.atguigu.iot.system.service.LoginService;
import com.atguigu.iot.system.service.SysMenuService;
import com.atguigu.iot.system.service.SysUserService;
import com.atguigu.iot.system.service.ValidateCodeService;
import com.atguigu.iot.system.vo.LoginVo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/***
 * 模拟登录认证相关接口
 */
@RestController
@RequestMapping("/system/auth")
public class AuthController {

    @Autowired
    private ValidateCodeService validateCodeService;


    /**
     * 验证码接口
     * @return
     */
    @GetMapping(value = "/generateValidateCode")
    public Result generateValidateCode(HttpServletRequest request){
        return Result.ok(validateCodeService.generateValidateCode(request));
    }


    @Autowired
    private LoginService loginService;
    /**
     * 登录
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody LoginVo loginVo,
                        HttpServletRequest request) {
        return Result.ok(loginService.login(loginVo, request));
    }

    @Autowired
    private SysUserService sysUserService;
    /**
     * 获取用户权限和信息
     * @return
     */
    @GetMapping("/userinfo")
    public Result getUserInfo() {
        return Result.ok(sysUserService.getUserInfo());
    }

    @Autowired
    private SysMenuService sysMenuService;
    /**
     * 获取菜单列表
     * @return
     */
    @GetMapping("/menus")
    public Result getMenus() {
        return Result.ok(sysMenuService.getMenus());
    }
}