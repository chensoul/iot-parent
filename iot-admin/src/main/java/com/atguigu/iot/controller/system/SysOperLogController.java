package com.atguigu.iot.controller.system;

import com.atguigu.iot.common.result.Result;
import com.atguigu.iot.system.service.SysOperLogService;
import com.atguigu.iot.system.service.impl.SysOperLogServiceImpl;
import com.atguigu.iot.system.vo.SysOperLogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * 操作日志相关接口的控制层
 */
@RestController
@RequestMapping(value = "/system/sysOperLog")
public class SysOperLogController {

    @Autowired
    private SysOperLogService sysOperLogService;
    /***
     * 操作日志分页条件查询
     * @param sysOperLogVo
     * @return
     */
    @GetMapping(value = "/list")
    public Result list(SysOperLogVo sysOperLogVo){
        return Result.ok(sysOperLogService.list(sysOperLogVo));
    }


    /**
     * 查询操作日志的详情
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public Result getOne(@PathVariable(value = "id") Long id){
        return Result.ok(sysOperLogService.getById(id));
    }
}
