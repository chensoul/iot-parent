package com.atguigu.iot.system.service;

import com.alibaba.fastjson2.JSONObject;
import com.atguigu.iot.system.pojo.SysUser;
import com.atguigu.iot.system.query.SysUserQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.servlet.http.HttpServletResponse;

/***
 * 系统用户相关的service接口类
 */
public interface SysUserService {

    /**
     * 分页条件查询系统用户
     * @param page
     * @param size
     * @param sysUserQuery
     * @return
     */
    public Page<SysUser> findSysUserByQuery(Integer page,
                                            Integer size,
                                            SysUserQuery sysUserQuery);

    /**
     * 查询用户的详细信息
     * @param id
     * @return
     */
    SysUser findOne(Long id);

    /**
     * 新增用户
     * @param sysUser
     */
    void save(SysUser sysUser);

    /**
     * 修改用户
     * @param sysUser
     */
    void update(SysUser sysUser);

    /**
     * 删除用户
     * @param id
     */
    void delete(Long id);

    /**
     * 获取用户权限和信息
     * @return
     */
    JSONObject getUserInfo();

    /**
     * 用户数据导出
     * @param response
     */
    void exportData(HttpServletResponse response);
}
