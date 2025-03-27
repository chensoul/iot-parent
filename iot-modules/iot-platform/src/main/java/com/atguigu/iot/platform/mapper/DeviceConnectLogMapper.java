package com.atguigu.iot.platform.mapper;

import com.atguigu.iot.platform.pojo.DeviceConnectLog;
import com.atguigu.iot.platform.vo.DataCountVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/***
 * 设备连接日志的mapper映射
 */
@Mapper
public interface DeviceConnectLogMapper  extends BaseMapper<DeviceConnectLog> {

    /**
     * 查询指定范围的统计数据
     * @param startDate
     * @param endDate
     * @return
     */
    List<DataCountVo> selectDeviceConnectLogCount(@Param("startDate") Date startDate,
                                                  @Param("endDate") Date endDate);
}
