package com.atguigu.iot.lock.service;

import com.atguigu.iot.lock.pojo.LockOptionLog;
import com.baomidou.mybatisplus.extension.service.IService;

public interface LockOptionLogService extends IService<LockOptionLog> {
    /**
     * 事件上报
     * @param clientid
     * @param name
     */
    void saveLockOptionLog(String clientid, String name);
}
