package com.atguigu.iot.aspect;

import com.alibaba.fastjson2.JSONObject;
import com.atguigu.iot.system.pojo.SysOperLog;
import com.atguigu.iot.system.service.SysOperLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/***
 * 操作日志监听的切面类
 */
@Aspect
@Component
public class GuiguOperAspect {

    @Autowired
    private SysOperLogService sysOperLogService;


    /**
     * 方法返回监听: 获取到1.请求参数 2.返回结果
     * @param point: 切点
     * @param result: 返回结果
     */
    @AfterReturning(value = "@annotation(com.atguigu.iot.web.log.OperLogCache)",
            returning = "result")
    public void doAfterReturning(JoinPoint point, Object result){
        //初始化
        SysOperLog sysOperLog = new SysOperLog();
        //保存操作日志: 正常返回
        sysOperLog.setStatus(0);
        //保存返回结果
        sysOperLog.setJsonResult(JSONObject.toJSONString(result));
        //保存操作日志
        sysOperLogService.saveSysOperLog(sysOperLog, point);
    }


    /**
     * 异常监听的情况: 1.请求参数 2.异常的内容
     */
    @AfterThrowing(value = "@annotation(com.atguigu.iot.web.log.OperLogCache)",
            throwing = "ex")
    public void doAfterThrowing(JoinPoint point, Throwable ex){
        //初始化
        SysOperLog sysOperLog = new SysOperLog();
        //保存操作日志: 发生了异常
        sysOperLog.setStatus(1);
        //保存异常内容
        sysOperLog.setErrorMsg(ex.getMessage());
        //保存操作日志
        sysOperLogService.saveSysOperLog(sysOperLog, point);
    }
}
