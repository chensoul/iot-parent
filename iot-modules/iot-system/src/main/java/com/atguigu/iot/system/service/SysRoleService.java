package com.atguigu.iot.system.service;

import com.alibaba.fastjson2.JSONObject;
import com.atguigu.iot.system.pojo.SysRole;
import com.atguigu.iot.system.query.SysRoleQuery;
import com.atguigu.iot.system.vo.AssginRoleVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/***
 * 用户角色相关的接口类
 */
public interface SysRoleService {

    /**
     * 分页条件查询角色信息
     * @param page
     * @param size
     * @param sysRoleQuery
     * @return
     */
    Page<SysRole> findSysRoleByQuery(Integer page,
                                     Integer size,
                                     SysRoleQuery sysRoleQuery);

    /**
     * 新增角色
     * @param sysRole
     */
    void save(SysRole sysRole);

    /**
     *
     * @param id
     * @return
     */
    SysRole getOne(Long id);

    /**
     * 修改角色
     * @param sysRole
     */
    void update(SysRole sysRole);

    /**
     * 删除角色
     * @param ids
     */
    void delete(String ids);

    /**
     * 查询用户可以分配的角色和用户已经拥有的角色
     * @param userId
     * @return
     */
    JSONObject toAssign(Long userId);

    /**
     * 分配角色
     * @param assginRoleVo
     */
    void doAssign(AssginRoleVo assginRoleVo);
}
