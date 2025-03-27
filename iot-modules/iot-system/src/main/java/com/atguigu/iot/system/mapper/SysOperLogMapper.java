package com.atguigu.iot.system.mapper;

import com.atguigu.iot.system.pojo.SysOperLog;
import com.atguigu.iot.system.vo.SysOperLogVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/***
 * 操作日志的mapper映射
 */
@Mapper
public interface SysOperLogMapper extends BaseMapper<SysOperLog> {

    /**
     * 操作日志分页条件查询
     * @param page
     * @param sysOperLogVo
     * @return
     */
    Page<SysOperLog> selectSysOperLogByVo(Page<SysOperLog> page,
                                          @Param("vo") SysOperLogVo sysOperLogVo);
}
