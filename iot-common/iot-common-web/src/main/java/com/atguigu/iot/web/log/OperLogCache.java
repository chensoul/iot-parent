package com.atguigu.iot.web.log;

import java.lang.annotation.*;

/***
 * 自定义的操作日志注解类
 * @author: shangguigu
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperLogCache {

    /**
     * 模块的名字
     * @author: shangguigu
     * @return
     */
    String title() default "标题";


    /**
     * 是否保存请求参数: 默认为保存
     * @author: shangguigu
     * @return
     */
    public boolean isSaveRequestData() default true;

    /**
     * 是否保存返回参数: 默认为保存
     * @author: shangguigu
     * @return
     */
    public boolean isSaveResponseDate() default true;

    /**
     *  操作人类型: 默认为后台用户
     *  @author: shangguigu
     * @return
     */
    public OperatorType operatorType() default OperatorType.MANAGE;
}
