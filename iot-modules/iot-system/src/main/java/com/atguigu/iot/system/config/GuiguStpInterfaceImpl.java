package com.atguigu.iot.system.config;

import cn.dev33.satoken.stp.StpInterface;
import com.atguigu.iot.system.mapper.SysMenuMapper;
import com.atguigu.iot.system.mapper.SysUserMapper;
import com.atguigu.iot.system.mapper.SysUserRoleMapper;
import com.atguigu.iot.system.pojo.SysUserRole;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/***
 * 实现SA框架提供的权限校验接口
 */
@Component
public class GuiguStpInterfaceImpl implements StpInterface {

    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 功能权限
     * @param o
     * @param s
     * @return
     */
    @Override
    public List<String> getPermissionList(Object o, String s) {
        return sysUserMapper.selectUserPerms(Long.valueOf(o.toString()));
    }

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    /**
     * 角色权限
     * @param o
     * @param s
     * @return
     */
    @Override
    public List<String> getRoleList(Object o, String s) {
        return sysUserRoleMapper.selectList(
                new LambdaQueryWrapper<SysUserRole>()
                        .eq(SysUserRole::getUserId, Long.valueOf(o.toString())))
                .stream().map(role->role.getRoleId().toString())
                .collect(Collectors.toList());
    }
}
