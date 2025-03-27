package com.atguigu.iot.platform.mapper;

import com.atguigu.iot.platform.pojo.DeviceInfo;
import com.atguigu.iot.platform.query.DeviceInfoQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/***
 * 设备表的mapper映射
 */
@Mapper
public interface DeviceInfoMapper extends BaseMapper<DeviceInfo> {
    /**
     * 分页条件查询设备列表
     * @param deviceInfoPage
     * @param deviceInfoQuery
     * @return
     */
    Page<DeviceInfo> pageDeviceInfoByQuery(Page<DeviceInfo> deviceInfoPage,
                                           @Param("vo") DeviceInfoQuery deviceInfoQuery);
}
