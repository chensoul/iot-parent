package com.atguigu.iot.system.service.impl;

import com.atguigu.iot.system.mapper.SysLoginLogMapper;
import com.atguigu.iot.system.pojo.SysLoginLog;
import com.atguigu.iot.system.service.SysLoginLogService;
import com.atguigu.iot.system.vo.SysLoginLogVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * 登录日志操作相关的接口类的实现类
 */
@Service
public class SysLoginLogServiceImpl implements SysLoginLogService {

    @Autowired
    private SysLoginLogMapper sysLoginLogMapper;

    /**
     * 登录日志分页条件查询
     *
     * @param sysLoginLogVo
     * @return
     */
    @Override
    public Page<SysLoginLogVo> list(SysLoginLogVo sysLoginLogVo) {
        return sysLoginLogMapper.selectSysLoginLogByVo(
                new Page<SysLoginLog>(sysLoginLogVo.getPageNum(), sysLoginLogVo.getPageSize()),
                sysLoginLogVo);
    }
}
