package com.atguigu.iot.platform.mapper;

import com.atguigu.iot.platform.pojo.DeviceMessageCount;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/***
 * TPS统计的mapper映射
 */
@Mapper
public interface DeviceMessageCountMapper extends BaseMapper<DeviceMessageCount> {
}
