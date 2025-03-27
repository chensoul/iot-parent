package com.atguigu.iot.platform.mapper;

import com.atguigu.iot.platform.pojo.DeviceOptionLog;
import com.atguigu.iot.platform.query.DeviceOptionLogQuery;
import com.atguigu.iot.platform.vo.DataCountVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/***
 * 设备的操作mapper映射
 */
@Mapper
public interface DeviceOptionLogMapper extends BaseMapper<DeviceOptionLog> {

    /**
     * 设备操作日志的分页条件查询
     * @param page
     * @param deviceOptionLogQuery
     * @return
     */
    Page<DeviceOptionLog> selectDeviceOptionLog(Page<DeviceOptionLog> page,
                                                @Param("vo") DeviceOptionLogQuery deviceOptionLogQuery);

    /**
     * 查询设备的TPS
     * @param startDate
     * @param endDate
     * @return
     */
    List<DataCountVo> selectTpsCount(@Param("startDate") Date startDate,
                                     @Param("endDate") Date endDate);
}
