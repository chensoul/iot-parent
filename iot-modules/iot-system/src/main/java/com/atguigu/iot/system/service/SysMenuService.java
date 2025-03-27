package com.atguigu.iot.system.service;

import com.atguigu.iot.system.pojo.SysMenu;
import com.atguigu.iot.system.vo.AssginMenuVo;
import com.atguigu.iot.system.vo.SysMenuVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/***
 * 菜单相关的接口类
 */
public interface SysMenuService extends IService<SysMenu> {

    /**
     * 获取所有的菜单信息
     *
     * @return
     */
    List<SysMenu> getSysMenu();

    /**
     * 新增菜单
     * @param sysMenu
     */
    void saveSysMenu(SysMenu sysMenu);

    /**
     * 查询菜单的详细信息
     * @param id
     * @return
     */
    SysMenu getOne(Long id);

    /**
     * 修改菜单
     * @param sysMenu
     */
    void update(SysMenu sysMenu);

    /**
     * 查询角色可以分配的菜单列表并且选中角色已经拥有的菜单
     * @param roleId
     * @return
     */
    Object toAssign(Long roleId);

    /**
     * 保存角色与菜单的关系
     * @param assginMenuVo
     */
    void doAssign(AssginMenuVo assginMenuVo);

    /**
     * 获取菜单列表
     *
     * @return
     */
    List<SysMenuVo> getMenus();

}
