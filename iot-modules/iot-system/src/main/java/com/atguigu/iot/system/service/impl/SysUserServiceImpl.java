package com.atguigu.iot.system.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.crypto.digest.BCrypt;
import cn.hutool.crypto.digest.MD5;
import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson2.JSONObject;
import com.atguigu.iot.common.result.ResultCodeEnum;
import com.atguigu.iot.system.mapper.SysMenuMapper;
import com.atguigu.iot.system.mapper.SysRoleMapper;
import com.atguigu.iot.system.mapper.SysUserMapper;
import com.atguigu.iot.system.mapper.SysUserRoleMapper;
import com.atguigu.iot.system.pojo.SysMenu;
import com.atguigu.iot.system.pojo.SysRole;
import com.atguigu.iot.system.pojo.SysUser;
import com.atguigu.iot.system.pojo.SysUserRole;
import com.atguigu.iot.system.query.SysUserQuery;
import com.atguigu.iot.system.service.SysUserService;
import com.atguigu.iot.system.vo.SysUserExcelVo;
import com.atguigu.iot.web.execption.GuiguException;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/***
 * 系统用户相关的service接口类的实现类
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;
    /**
     * 分页条件查询系统用户
     *
     * @param page
     * @param size
     * @param sysUserQuery
     * @return
     */
    @Override
    public Page<SysUser> findSysUserByQuery(Integer page,
                                            Integer size,
                                            SysUserQuery sysUserQuery) {
        return sysUserMapper.pageSysUserByQuery(new Page<>(page, size),
                sysUserQuery);
    }

    /**
     * 查询用户的详细信息
     *
     * @param id
     * @return
     */
    @Override
    public SysUser findOne(Long id) {
        return sysUserMapper.selectById(id);
    }

    /**
     * 新增用户
     *
     * @param sysUser
     */
    @Override
    public void save(SysUser sysUser) {
        //获取新增用户的明文密码
        String password = sysUser.getPassword();
        //将明文转换为密文存储到数据库中去
        String hashpw = BCrypt.hashpw(password);
        //替换
        sysUser.setPassword(hashpw);
        //保存用户的数据
        int insert = sysUserMapper.insert(sysUser);
        if(insert <= 0){
            throw new GuiguException(201, "新增用户失败!");
        }
    }

    /**
     * 修改用户: 不允许修改密码,修改密码单独的功能!!!
     *
     * @param sysUser
     */
    @Override
    public void update(SysUser sysUser) {
        //修改用户信息
        int i = sysUserMapper.updateById(sysUser);
        if(i <= 0){
            throw new GuiguException(201, "修改用户的信息失败!");
        }
    }

    /**
     * 删除用户
     *
     * @param id
     */
    @Override
    public void delete(Long id) {
        //删除用户
        int i = sysUserMapper.deleteById(id);
        if(i < 0){
            throw new GuiguException(201, "删除用户失败!");
        }
    }

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    /**
     * 获取用户权限和信息
     *
     * @return
     */
    @Override
    public JSONObject getUserInfo() {
        //获取用户的id
        long userId = StpUtil.getLoginIdAsLong();
        //查询用户的信息
        SysUser sysUser = sysUserMapper.selectById(userId);
        //初始化
        List<String> permsList = new ArrayList<>();
        //管理员+普通用户
        if(userId == 1){
            permsList = sysMenuMapper.selectList(
                            new LambdaQueryWrapper<SysMenu>()
                                    .eq(SysMenu::getStatus, 1)
                                    .isNotNull(SysMenu::getPerms)
                                    .select(SysMenu::getPerms)).stream()
                    .map(p -> p.getPerms()).collect(Collectors.toList());
        }else{
            //普通用户的权限查询
            permsList = sysUserMapper.selectUserPerms(userId);
        }
        //返回结果初始化
        JSONObject result = new JSONObject();
        result.put("id", userId);
        result.put("name", sysUser.getName());
        result.put("avatar", sysUser.getAvatar());
        //查询用户的角色列表
        List<Long> roleIdList = sysUserRoleMapper.selectList(
                        new LambdaQueryWrapper<SysUserRole>()
                                .eq(SysUserRole::getUserId, userId)
                                .select(SysUserRole::getRoleId)).stream()
                .map(r -> r.getRoleId()).collect(Collectors.toList());
        result.put("role", roleIdList);
        result.put("perms", permsList);
        //包装+返回
        return result;
    }

    /**
     * 用户数据导出
     *
     * @param response
     */
    @SneakyThrows
    @Override
    public void exportData(HttpServletResponse response) {
        //查询用户数据
        List<SysUserExcelVo> sysUserExcelVoList =
                sysUserMapper.selectList(null).stream().map(sysUser -> {
            SysUserExcelVo sysUserExcelVo = new SysUserExcelVo();
            sysUserExcelVo.setName(sysUser.getName());
            sysUserExcelVo.setUsername(sysUser.getUsername());
            sysUserExcelVo.setPhone(sysUser.getPhone());
            return sysUserExcelVo;
        }).collect(Collectors.toList());
        // 响应文件的类型指定
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        //数据编码集指定
        response.setCharacterEncoding("utf-8");
        // 文件名编码防止乱码
        String fileName = URLEncoder.encode("data", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), SysUserExcelVo.class).sheet("用户数据").doWrite(sysUserExcelVoList);
    }
}