package com.atguigu.iot.system.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.atguigu.iot.system.mapper.SysRoleMapper;
import com.atguigu.iot.system.mapper.SysUserRoleMapper;
import com.atguigu.iot.system.pojo.SysRole;
import com.atguigu.iot.system.pojo.SysUserRole;
import com.atguigu.iot.system.query.SysRoleQuery;
import com.atguigu.iot.system.service.SysRoleService;
import com.atguigu.iot.system.vo.AssginRoleVo;
import com.atguigu.iot.web.execption.GuiguException;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/***
 * 用户角色相关的接口类的实现类
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;
    /**
     * 分页条件查询角色信息
     *
     * @param page
     * @param size
     * @param sysRoleQuery
     * @return
     */
    @Override
    public Page<SysRole> findSysRoleByQuery(Integer page,
                                            Integer size,
                                            SysRoleQuery sysRoleQuery) {
        return sysRoleMapper.pageSysRoleByQuery(new Page<>(page, size),
                sysRoleQuery);
    }

    /**
     * 新增角色
     *
     * @param sysRole
     */
    @Override
    public void save(SysRole sysRole) {
        //新增角色
        int insert = sysRoleMapper.insert(sysRole);
        if(insert <= 0){
            throw new GuiguException(201, "新增角色失败!");
        }
    }

    /**
     * @param id
     * @return
     */
    @Override
    public SysRole getOne(Long id) {
        return sysRoleMapper.selectById(id);
    }

    /**
     * 修改角色
     *
     * @param sysRole
     */
    @Override
    public void update(SysRole sysRole) {
        //修改角色
        int i = sysRoleMapper.updateById(sysRole);
        if(i < 0){
            throw new GuiguException(201, "修改角色失败!");
        }
    }

    /**
     * 删除角色
     *
     * @param ids
     */
    @Override
    public void delete(String ids) {
        //将ids对象转换为一个集合
        List<String> list = Arrays.asList(ids.split(","));
        //删除这个集合中的所有的角色
        sysRoleMapper.deleteBatchIds(list);
    }

    /**
     * 查询用户可以分配的角色和用户已经拥有的角色
     *
     * @param userId
     * @return
     */
    @Override
    public JSONObject toAssign(Long userId) {
        //查询用户可以分配的全部的角色: a b c
        List<SysRole> sysRoleList =
                sysRoleMapper.selectList(null);
        //查询用户已经拥有的角色: a b
        List<SysRole> userRoleList =
                sysRoleMapper.selectUserRoleByUserId(userId);
        //用户已经拥有的角色id全部获取到: key=id value=0
        Map<Long, Integer> userRoleMap =
                userRoleList.stream().collect(Collectors.toMap(
                key -> key.getId(),
                value -> 0
        ));
        //去掉用户已经拥有的角色,剩余的就是可以分配的角色
        sysRoleList =
                sysRoleList.stream()
                        .filter(role -> userRoleMap.get(role.getId()) == null)
                        .collect(Collectors.toList());
        //包装结果集
        JSONObject result = new JSONObject();
        result.put("allRolesList", sysRoleList);
        result.put("assginRoleList", userRoleList);
        //返回
        return result;
    }

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    /**
     * 分配角色
     *
     * @param assginRoleVo
     */
    @Override
    public void doAssign(AssginRoleVo assginRoleVo) {
        //用户id
        Long userId = assginRoleVo.getUserId();
        //获取当前选择的角色列表
        List<Long> roleIdList = assginRoleVo.getRoleIdList();
        //保存角色和用户的关系
        roleIdList.stream().forEach(roleId->{
            //初始化用户角色关系的实体
            SysUserRole sysUserRole = new SysUserRole();
            //保存用户id
            sysUserRole.setUserId(userId);
            //保存角色id
            sysUserRole.setRoleId(roleId);
            //保存用户和角色的关联关系
            int insert = sysUserRoleMapper.insert(sysUserRole);
            if(insert <= 0){
                throw new GuiguException(201, "保存用户角色失败!");
            }
        });
    }
}
