package com.atguigu.iot.platform.service;

import com.atguigu.iot.platform.pojo.DeviceOptionLog;
import com.atguigu.iot.platform.query.DeviceOptionLogQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/***
 * 设备操作日志的接口类
 */
public interface DeviceOptionLogSerivce {
    /**
     * 分页条件查询日志数据
     * @param deviceOptionLogQuery
     * @return
     */
    Page<DeviceOptionLog> list(DeviceOptionLogQuery deviceOptionLogQuery);
}
