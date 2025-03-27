package com.atguigu.iot.system.mapper;

import com.atguigu.iot.system.pojo.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * 菜单表的mapper映射
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    /**
     * 查询用户的菜单列表
     * @param userId
     * @return
     */
    List<SysMenu> selectUserMenuList(@Param("userId") long userId);
}
