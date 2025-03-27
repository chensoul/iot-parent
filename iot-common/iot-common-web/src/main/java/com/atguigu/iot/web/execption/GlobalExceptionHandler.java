package com.atguigu.iot.web.execption;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import com.atguigu.iot.common.result.Result;
import com.atguigu.iot.common.result.ResultCodeEnum;
import com.atguigu.iot.web.execption.GuiguException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 全局异常处理类
 *
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return Result.fail();

    }

    /**
     * 拦截sa框架的异常,包装为自己定义的异常
     * @param e
     * @return
     */
    @ExceptionHandler(NotLoginException.class)
    @ResponseBody
    public Result notLogin(Exception e){
        return Result.build(e.getMessage(), ResultCodeEnum.LOGIN_AUTH);
    }

    /**
     * 自定义异常处理方法
     * @param e
     * @return
     */
    @ExceptionHandler(GuiguException.class)
    @ResponseBody
    public Result error(GuiguException e){
        return Result.build(null,e.getCode(), e.getMessage());
    }

    /**
     * SA框架抛出来的没角色权限和和没有功能权限的异常
     * @return
     */
    @ExceptionHandler({NotRoleException.class, NotPermissionException.class})
    @ResponseBody
    public Result saException(Exception e){
        return Result.build(e.getMessage(), ResultCodeEnum.PERMISSION);
    }

}