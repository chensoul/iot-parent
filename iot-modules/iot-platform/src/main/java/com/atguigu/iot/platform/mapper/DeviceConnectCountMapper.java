package com.atguigu.iot.platform.mapper;

import com.atguigu.iot.platform.pojo.DeviceConnectCount;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/***
 * 连接统计表的mapper映射
 */
@Mapper
public interface DeviceConnectCountMapper extends BaseMapper<DeviceConnectCount> {
}
