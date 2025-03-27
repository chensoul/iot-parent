package com.atguigu.iot.system.mapper;

import com.atguigu.iot.system.pojo.SysUser;
import com.atguigu.iot.system.query.SysUserQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * 系统用户表的mapper映射
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 分页条件查询用户列表
     * @param page
     * @param sysUserQuery
     * @return
     */
    public Page<SysUser> pageSysUserByQuery(Page<SysUser> page,
            @Param("query") SysUserQuery sysUserQuery);

    /**
     * 普通用户的权限查询
     * @param userId
     * @return
     */
    List<String> selectUserPerms(@Param("userId") long userId);
}
