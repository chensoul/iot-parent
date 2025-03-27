package com.atguigu.iot.platform.mapper;

import com.atguigu.iot.platform.pojo.DeviceServiceData;
import com.atguigu.iot.platform.vo.DeviceServiceDataVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/***
 * 设备服务的mapper映射
 */
@Mapper
public interface DeviceServiceDataMapper extends BaseMapper<DeviceServiceData> {
    /**
     * 设备服务明细查询
     * @param deviceServiceDataVoPage
     * @param deviceId
     * @return
     */
    Page<DeviceServiceDataVo> deviceServiceDataList(Page<DeviceServiceDataVo> deviceServiceDataVoPage,
                                                    @Param("deviceId") Long deviceId);
}
