package com.atguigu.iot.system.service;

import com.atguigu.iot.system.vo.SysLoginLogVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/***
 * 登录日志操作相关的接口类
 */
public interface SysLoginLogService {

    /**
     * 登录日志分页条件查询
     * @param sysLoginLogVo
     * @return
     */
    Page<SysLoginLogVo> list(SysLoginLogVo sysLoginLogVo);
}
