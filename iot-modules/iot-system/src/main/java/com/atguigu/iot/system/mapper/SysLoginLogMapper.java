package com.atguigu.iot.system.mapper;

import com.atguigu.iot.system.pojo.SysLoginLog;
import com.atguigu.iot.system.vo.SysLoginLogVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/***
 * 登录日志表的mapper映射
 */
@Mapper
public interface SysLoginLogMapper extends BaseMapper<SysLoginLog> {
    Page<SysLoginLogVo> selectSysLoginLogByVo(Page<SysLoginLog> sysLoginLogPage,
                                              @Param("vo") SysLoginLogVo sysLoginLogVo);
}
