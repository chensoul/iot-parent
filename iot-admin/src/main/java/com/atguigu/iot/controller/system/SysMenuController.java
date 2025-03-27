package com.atguigu.iot.controller.system;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import com.atguigu.iot.common.result.Result;
import com.atguigu.iot.system.pojo.SysMenu;
import com.atguigu.iot.system.service.SysMenuService;
import com.atguigu.iot.system.vo.AssginMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/system/sysMenu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 获取菜单的列表
     * @return
     */
    @GetMapping(value = "/findNodes")
    public Result findNodes(){
        return Result.ok(sysMenuService.getSysMenu());
    }

    /**
     * 新增菜单
     * @param sysMenu
     * @return
     */
    @PostMapping
    public Result save(@RequestBody SysMenu sysMenu){
        sysMenuService.save(sysMenu);
        return Result.ok();
    }

    /**
     * 查询菜单的详细信息
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public Result getOne(@PathVariable(value = "id") Long id){
        return Result.ok(sysMenuService.getOne(id));
    }

    /**
     * 修改菜单
     * @param sysMenu
     * @return
     */
    @PutMapping
    public Result update(@RequestBody SysMenu sysMenu){
        sysMenuService.update(sysMenu);
        return Result.ok();
    }

    /**
     * 删除菜单
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable(value = "id") Long id){
        sysMenuService.removeById(id);
        return Result.ok();
    }

    /**
     * 查询角色可以分配的菜单列表并且选中角色已经拥有的菜单
     * @param roleId
     * @return
     */
    @GetMapping(value = "/toAssign/{roleId}")
    public Result toAssign(@PathVariable(value = "roleId") Long roleId){
        return Result.ok(sysMenuService.toAssign(roleId));
    }

    /**
     * 保存角色与菜单的关系
     * @param assginMenuVo
     * @return
     */
    @PostMapping(value = "/doAssign")
    public Result doAssign(@RequestBody AssginMenuVo assginMenuVo){
        sysMenuService.doAssign(assginMenuVo);
        return Result.ok();
    }
}
