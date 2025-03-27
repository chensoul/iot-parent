package com.atguigu.iot.user.mapper;

import com.atguigu.iot.user.pojo.UserDevice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/***
 * 用户设备表的mapper映射
 */
@Mapper
public interface UserDeviceMapper extends BaseMapper<UserDevice> {
}
