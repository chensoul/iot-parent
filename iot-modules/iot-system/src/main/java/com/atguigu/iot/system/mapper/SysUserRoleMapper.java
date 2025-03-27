package com.atguigu.iot.system.mapper;

import com.atguigu.iot.system.pojo.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/***
 * 用户角色关联表的mapper映射
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {
}
