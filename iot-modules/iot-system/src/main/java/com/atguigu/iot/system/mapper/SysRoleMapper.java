package com.atguigu.iot.system.mapper;

import com.atguigu.iot.system.pojo.SysRole;
import com.atguigu.iot.system.query.SysRoleQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * 用户角色表的mapper映射
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 分页条件查询角色信息
     * @param page
     * @param sysRoleQuery
     * @return
     */
    Page<SysRole> pageSysRoleByQuery(Page<SysRole> page,
                                     @Param("query") SysRoleQuery sysRoleQuery);

    /**
     * 查询用户拥有的角色列表
     * @param userId
     * @return
     */
    List<SysRole> selectUserRoleByUserId(@Param("userId") Long userId);
}
