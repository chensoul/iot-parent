package com.atguigu.iot.controller.system;

import com.atguigu.iot.common.result.Result;
import com.atguigu.iot.system.pojo.SysRole;
import com.atguigu.iot.system.query.SysRoleQuery;
import com.atguigu.iot.system.service.SysRoleService;
import com.atguigu.iot.system.vo.AssginRoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/system/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;
    /**
     * 分页条件查询用户角色
     * @param pageNum
     * @param pageSize
     * @param sysRoleQuery
     * @return
     */
    @GetMapping(value = "/list")
    public Result list(Integer pageNum,
                       Integer pageSize,
                       SysRoleQuery sysRoleQuery){
        return Result.ok(sysRoleService.findSysRoleByQuery(pageNum, pageSize, sysRoleQuery));
    }

    /**
     * 新增角色
     * @param sysRole
     * @return
     */
    @PostMapping
    public Result save(@RequestBody SysRole sysRole){
        sysRoleService.save(sysRole);
        return Result.ok();
    }

    /**
     * 查询角色的详细信息
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public Result getOne(@PathVariable(value = "id") Long id){
        return Result.ok(sysRoleService.getOne(id));
    }

    /**
     * 修改角色
     * @param sysRole
     * @return
     */
    @PutMapping
    public Result update(@RequestBody SysRole sysRole){
        sysRoleService.update(sysRole);
        return Result.ok();
    }

    /**
     * 删除角色
     * @param ids
     * @return
     */
    @DeleteMapping(value = "/{ids}")
    public Result delete(@PathVariable(value = "ids") String ids){
        sysRoleService.delete(ids);
        return Result.ok();
    }

    /**
     * 查询用户可以分配的角色和用户已经拥有的角色
     * @param userId
     * @return
     */
    @GetMapping(value = "/toAssign/{userId}")
    public Result toAssign(@PathVariable(value = "userId") Long userId){
        return Result.ok(sysRoleService.toAssign(userId));
    }

    /**
     * 分配角色
     * @param assginRoleVo
     * @return
     */
    @PostMapping(value = "/doAssign")
    public Result doAssign(@RequestBody AssginRoleVo assginRoleVo){
        sysRoleService.doAssign(assginRoleVo);
        return Result.ok();
    }

}
