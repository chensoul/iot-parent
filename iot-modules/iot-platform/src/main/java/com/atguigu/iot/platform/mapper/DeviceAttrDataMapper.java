package com.atguigu.iot.platform.mapper;

import com.atguigu.iot.platform.pojo.DeviceAttrData;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/***
 * 设备运行状态表的mapper映射
 */
@Mapper
public interface DeviceAttrDataMapper extends BaseMapper<DeviceAttrData> {
}
