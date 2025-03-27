package com.atguigu.iot.platform.service;

import com.atguigu.iot.platform.query.DataTimeQuery;

import java.util.Map;

/***
 * 数据统计相关的接口类
 */
public interface DataCountService {
    /**
     * 查询设备的统计信息
     *
     * @param dataTimeQuery
     * @return
     */
    Map<String, Object> getDeviceData(DataTimeQuery dataTimeQuery);

    /**
     * 查询TPS统计信息
     * @param dataTimeQuery
     * @return
     */
    Map<String, Object> getMessageData(DataTimeQuery dataTimeQuery);
}
