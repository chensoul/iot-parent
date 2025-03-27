package com.atguigu.iot.lock.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.atguigu.iot.lock.mapper.LockOptionLogMapper;
import com.atguigu.iot.lock.pojo.LockOptionLog;
import com.atguigu.iot.lock.service.LockOptionLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class LockOptionLogServiceImpl
        extends ServiceImpl<LockOptionLogMapper, LockOptionLog>
        implements LockOptionLogService {


    /**
     * 事件上报
     *
     * @param clientid
     * @param name
     */
    @Override
    public void saveLockOptionLog(String clientid, String name) {
        //查询设备的信息,查询产品的本次事件的信息
        LockOptionLog lockOptionLog = new LockOptionLog();
        lockOptionLog.setClientId(clientid);
        lockOptionLog.setStatus("1");
        lockOptionLog.setContent(name);
        save(lockOptionLog);
    }
}
