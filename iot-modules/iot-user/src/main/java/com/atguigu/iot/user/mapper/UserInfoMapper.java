package com.atguigu.iot.user.mapper;

import com.atguigu.iot.user.pojo.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/***
 * 用户表的mapper映射
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
}
