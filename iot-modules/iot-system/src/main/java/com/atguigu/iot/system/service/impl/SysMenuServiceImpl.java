package com.atguigu.iot.system.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.atguigu.iot.system.mapper.SysMenuMapper;
import com.atguigu.iot.system.mapper.SysRoleMenuMapper;
import com.atguigu.iot.system.pojo.SysMenu;
import com.atguigu.iot.system.pojo.SysRoleMenu;
import com.atguigu.iot.system.service.SysMenuService;
import com.atguigu.iot.system.vo.AssginMenuVo;
import com.atguigu.iot.system.vo.SysMenuVo;
import com.atguigu.iot.web.execption.GuiguException;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/***
 * 菜单相关的接口类的实现类
 */
@Service
public class SysMenuServiceImpl
        extends ServiceImpl<SysMenuMapper, SysMenu>
        implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;
    /**
     * 获取所有的菜单信息
     *
     * @return
     */
    @Override
    public List<SysMenu> getSysMenu() {
        //查询出所有的菜单的数据
        List<SysMenu> sysMenuList =
                sysMenuMapper.selectList(null);
        //找到全部的顶级菜单: parentId=0所有菜单
        return sysMenuList.stream()//将集合转换为流数据
                .filter(sysMenu -> sysMenu.getParentId().intValue() == 0)//过滤数据,只获取顶级菜单
                .map(sysMenu -> {
                    //遍历顶级菜单,找到每个顶级菜单下的全部子菜单的数据
                    return treeMenu(sysMenuList, sysMenu);
                }).collect(Collectors.toList());//将结果转换为页面最终要的结果集
    }

    /**
     * 新增菜单
     *
     * @param sysMenu
     */
    @Override
    public void saveSysMenu(SysMenu sysMenu) {
        int insert = sysMenuMapper.insert(sysMenu);
        if(insert <= 0){
            throw new GuiguException(201, "新增菜单失败!");
        }
    }

    /**
     * 查询菜单的详细信息
     *
     * @param id
     * @return
     */
    @Override
    public SysMenu getOne(Long id) {
        return sysMenuMapper.selectById(id);
    }

    /**
     * 修改菜单
     *
     * @param sysMenu
     */
    @Override
    public void update(SysMenu sysMenu) {
        int i = sysMenuMapper.updateById(sysMenu);
        if(i < 0){
            throw new GuiguException(201, "修改菜单失败!");
        }
    }

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;
    /**
     * 查询角色可以分配的菜单列表并且选中角色已经拥有的菜单
     *
     * @param roleId
     * @return
     */
    @Override
    public Object toAssign(Long roleId) {
        //查询角色已经拥有的菜单列表
        List<SysRoleMenu> sysRoleMenus =
                sysRoleMenuMapper.selectList(
                        new LambdaQueryWrapper<SysRoleMenu>()
                                .eq(SysRoleMenu::getRoleId, roleId));
        //将list转换为map:key=角色拥有的菜单id value=角色id
        Map<Long, Long> sysRoleMenuMap = sysRoleMenus.stream().collect(Collectors.toMap(
                key -> key.getMenuId(),
                value -> value.getRoleId()
        ));
        //查询所有的菜单数据
        List<SysMenu> sysMenus =
                sysMenuMapper.selectList(null);
        //遍历全部的菜单数据,将角色已经拥有的菜单进行勾选操作
        return sysMenus.stream().map(sysMenu -> {
            //判断这个菜单是否已经被分配给了当前角色
            if(sysRoleMenuMap.get(sysMenu.getId()) != null){
                sysMenu.setSelect(true);
            }
            //返回
            return sysMenu;
        }).filter(sysMenu -> sysMenu.getParentId().intValue() == 0)
                .map(sysMenu -> {
                    return treeMenu(sysMenus, sysMenu);
                }).collect(Collectors.toList());
    }

    /**
     * 保存角色与菜单的关系
     *
     * @param assginMenuVo
     */
    @Override
    public void doAssign(AssginMenuVo assginMenuVo) {
        //获取全部的菜单列表
        List<Long> menuIdList = assginMenuVo.getMenuIdList();
        //获取角色id
        Long roleId = assginMenuVo.getRoleId();
        //删除这个角色旧的菜单数据
        int delete = sysRoleMenuMapper.delete(
                new LambdaQueryWrapper<SysRoleMenu>()
                        .eq(SysRoleMenu::getRoleId, roleId));
        if(delete < 0){
            throw new GuiguException(201, "保存角色的菜单数据失败!");
        }
        //保存本次角色最新的菜单数据
        menuIdList.stream().forEach(mid->{
            SysRoleMenu sysRoleMenu = new SysRoleMenu();
            sysRoleMenu.setRoleId(roleId);
            sysRoleMenu.setMenuId(mid);
            int insert = sysRoleMenuMapper.insert(sysRoleMenu);
            if(insert <= 0){
                throw new GuiguException(201, "保存角色的菜单数据失败!");
            }
        });
    }

    /**
     * 获取菜单列表
     *
     * @return
     */
    @Override
    public List<SysMenuVo> getMenus() {
        //获取用户id
        long userId = StpUtil.getLoginIdAsLong();
        //初始化
        List<SysMenu> sysMenuList = new ArrayList<>();
        //管理员
        if(userId == 1){
            //所有的菜单查询返回
            sysMenuList =
                    sysMenuMapper.selectList(
                            new LambdaQueryWrapper<SysMenu>()
                                    .eq(SysMenu::getStatus, 1)
                                    .isNotNull(SysMenu::getComponent));
        }else{
            //用户有哪些菜单查询那些
            sysMenuList = sysMenuMapper.selectUserMenuList(userId);
        }
        //菜单树化以及转换返回
        return buildSysMenuVo(tree(sysMenuList));
    }

    public static List<SysMenuVo> buildSysMenuVo(List<SysMenu> sysMenuList){
        //遍历转换为VO
        return sysMenuList.stream().map(sysMenu -> {
            //初始化
            SysMenuVo sysMenuVo = new SysMenuVo();
            sysMenuVo.setName(sysMenu.getComponent());
            sysMenuVo.setTitle(sysMenu.getTitle());
            //获取菜单的下级列表
            List<SysMenu> children = sysMenu.getChildren();
            if(children != null && !children.isEmpty()){
                //这个菜单的子菜单也转换存储
                sysMenuVo.setChildren(buildSysMenuVo(children));
            }
            //返回
            return sysMenuVo;
        }).collect(Collectors.toList());
    }


    /**
     * 树化菜单
     * @param sysMenuList
     * @return
     */
    public  static List<SysMenu> tree(List<SysMenu> sysMenuList){
        return sysMenuList.stream()//将集合转换为流数据
                .filter(sysMenu -> sysMenu.getParentId().intValue() == 0)//过滤数据,只获取顶级菜单
                .map(sysMenu -> {
                    //遍历顶级菜单,找到每个顶级菜单下的全部子菜单的数据
                    return treeMenu(sysMenuList, sysMenu);
                }).collect(Collectors.toList());//将结果转换为页面最终要的结果集
    }

    /**
     *
     * @param sysMenuList: 全部菜单的数据
     * @param sysMenu: 获取子菜单的菜单对象
     * @return
     */
    public static SysMenu treeMenu(List<SysMenu> sysMenuList, SysMenu sysMenu){
        //定义子菜单的列表: CopyOnWriteArrayList-->线程安全
        List<SysMenu> childSysMenu = new CopyOnWriteArrayList<>();
        //流式编程的处理,遍历全部的菜单数据,找到子菜单中子菜单的parentId属性等于当前菜单的id的菜单
        sysMenuList.stream().forEach(m->{
            //判断是否为当前菜单的子菜单
            if(m.getParentId().equals(sysMenu.getId())){
                /**
                 * 1.若某个菜单是当前菜单的子菜单,则保存这个菜单的数据到childSysMenu
                 * 2.确认m这个当前是子菜单的菜单是否还拥有子菜单,若有的话,则需要找完---递归
                 */
                childSysMenu.add(treeMenu(sysMenuList, m));
            }
        });
        //找到了当前菜单的所有的子菜单
        sysMenu.setChildren(childSysMenu);
        //返回
        return sysMenu;
    }
}
