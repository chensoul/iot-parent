package com.atguigu.iot.platform.mapper;

import com.atguigu.iot.platform.pojo.DeviceEventData;
import com.atguigu.iot.platform.vo.DeviceEventDataVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/***
 * 设备事件的mapper映射
 */
@Mapper
public interface DeviceEventDataMapper extends BaseMapper<DeviceEventData> {
    /**
     * 设备的事件明细查询
     * @param page
     * @param deviceId
     * @return
     */
    Page<DeviceEventDataVo> deviceEventDataList(Page<DeviceEventDataVo> page,
                                                @Param("deviceId") Long deviceId);
}
