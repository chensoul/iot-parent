package com.atguigu.iot.lock.service;

import com.alibaba.fastjson2.JSONObject;
import com.atguigu.iot.lock.pojo.LockAttrData;
import com.atguigu.iot.lock.pojo.LockOptionLog;
import com.atguigu.iot.lock.vo.IndexDataVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

public interface LockAttrDataService extends IService<LockAttrData> {
    /**
     * 记录属性信息
     * @param clientid
     * @param payload
     */
    void saveLockAttrData(String clientid, JSONObject payload);

    /**
     * 查询设备的属性信息
     * @param clientId
     * @return
     */
    IndexDataVo getIndexData(String clientId);

    /**
     * 分页条件查询操作列表数据
     * @param lockOptionLogPage
     * @param clientId
     * @return
     */
    JSONObject getLockOptionLogList(Page<LockOptionLog> lockOptionLogPage,
                                    String clientId);
}
