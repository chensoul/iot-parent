package com.atguigu.iot.platform.service.impl;

import com.atguigu.iot.platform.mapper.DeviceOptionLogMapper;
import com.atguigu.iot.platform.pojo.DeviceOptionLog;
import com.atguigu.iot.platform.query.DeviceOptionLogQuery;
import com.atguigu.iot.platform.service.DeviceOptionLogSerivce;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * 设备操作日志的接口类的实现类
 */
@Service
public class DeviceOptionLogSerivceImpl implements DeviceOptionLogSerivce {

    @Autowired
    private DeviceOptionLogMapper deviceOptionLogMapper;

    /**
     * 分页条件查询日志数据
     *
     * @param deviceOptionLogQuery
     * @return
     */
    @Override
    public Page<DeviceOptionLog> list(DeviceOptionLogQuery deviceOptionLogQuery) {
        return deviceOptionLogMapper.selectDeviceOptionLog(
                new Page<>(deviceOptionLogQuery.getPageNum(), deviceOptionLogQuery.getPageSize()),
                deviceOptionLogQuery);
    }
}
