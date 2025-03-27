package com.atguigu.iot.system.mapper;

import com.atguigu.iot.system.pojo.SysRoleMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/***
 * 角色与菜单的关联表mapper映射
 */
@Mapper
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {
}
