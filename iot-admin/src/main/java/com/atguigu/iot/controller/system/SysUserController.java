package com.atguigu.iot.controller.system;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.hutool.core.convert.Convert;
import com.atguigu.iot.common.result.Result;
import com.atguigu.iot.system.pojo.SysUser;
import com.atguigu.iot.system.query.SysUserQuery;
import com.atguigu.iot.system.service.SysUserService;
import com.atguigu.iot.web.log.OperLogCache;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/***
 * 系统用户管理相关的控制层接口
 */
@RestController
@RequestMapping(value = "/system/sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 用户分页条件查询
     * @param pageNum
     * @param pageSize
     * @param sysUserQuery
     * @return
     */
    @GetMapping(value = "/list")
    @SaCheckRole("9")
    @OperLogCache(title = "用户操作: 分页列表查询")
    public Result list(Integer pageNum,
                       Integer pageSize,
                       SysUserQuery sysUserQuery){
        return Result.ok(sysUserService.
                findSysUserByQuery(Convert.toInt(pageNum, 1),
                        Convert.toInt(pageSize, 10),
                        sysUserQuery));
    }

    /**
     * 查询用户的详细信息
     * @return
     */
    @OperLogCache(title = "用户操作: 查询用户的详细信息")
    @GetMapping(value = "/{id}")
    public Result findOne(@PathVariable(value = "id") Long id){
        return Result.ok(sysUserService.findOne(id));
    }

    /**
     * 新增用户
     * @param sysUser
     * @return
     */
    @PostMapping
    @SaCheckPermission("sysUser.add")
    @OperLogCache(title = "用户操作: 新增用户")
    public Result save(@RequestBody SysUser sysUser){
        sysUserService.save(sysUser);
        return Result.ok();
    }

    /**
     * 修改用户
     * @param sysUser
     * @return
     */
    @PutMapping
    @OperLogCache(title = "用户操作: 修改用户")
    public Result update(@RequestBody SysUser sysUser){
        sysUserService.update(sysUser);
        return Result.ok();
    }

    /**
     * 删除用户: 逻辑删除-update 不是物理删除-delete
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    @OperLogCache(title = "用户操作: 删除用户")
    public Result delete(@PathVariable(value = "id") Long id){
        sysUserService.delete(id);
        return Result.ok();
    }

    /**
     * 用户数据导出
     * @param response
     */
    @GetMapping(value = "/exportData")
    @OperLogCache(title = "用户操作: 用户数据导出")
    public void exportData(HttpServletResponse response){
        sysUserService.exportData(response);
    }
}
