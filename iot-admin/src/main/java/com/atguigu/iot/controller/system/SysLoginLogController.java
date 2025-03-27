package com.atguigu.iot.controller.system;

import com.atguigu.iot.common.result.Result;
import com.atguigu.iot.system.service.SysLoginLogService;
import com.atguigu.iot.system.vo.SysLoginLogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * 登录日志相关接口的控制层
 */
@RestController
@RequestMapping(value = "/system/sysLoginLog")
public class SysLoginLogController {

    @Autowired
    private SysLoginLogService sysLoginLogService;

    /**
     * 登录日志分页条件查询
     * @param sysLoginLogVo
     * @return
     */
    @GetMapping(value = "/list")
    public Result list(SysLoginLogVo sysLoginLogVo){
        return Result.ok(sysLoginLogService.list(sysLoginLogVo));
    }
}
