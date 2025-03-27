package com.atguigu.iot.platform.emqx;

import java.lang.annotation.*;

@Target(ElementType.TYPE)//这个注解在类上使用
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GuiguEmqx {

    /**
     * 事件属性
     */
    String event() default "";
}
