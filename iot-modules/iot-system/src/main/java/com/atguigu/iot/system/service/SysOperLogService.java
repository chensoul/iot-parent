package com.atguigu.iot.system.service;

import com.atguigu.iot.system.pojo.SysOperLog;
import com.atguigu.iot.system.vo.SysOperLogVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.aspectj.lang.JoinPoint;


/***
 * 操作日志相关的接口类
 */
public interface SysOperLogService extends IService<SysOperLog> {
    /**
     * 操作日志分页条件查询
     * @param sysOperLogVo
     * @return
     */
    Page<SysOperLog> list(SysOperLogVo sysOperLogVo);

    /**
     * 保存操作日志
     * @param sysOperLog
     * @param point
     */
    void saveSysOperLog(SysOperLog sysOperLog, JoinPoint point);
}
