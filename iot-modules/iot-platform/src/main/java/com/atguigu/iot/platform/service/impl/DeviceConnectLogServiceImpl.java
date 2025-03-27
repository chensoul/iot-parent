package com.atguigu.iot.platform.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.atguigu.iot.common.constant.GuiguEmqxConstants;
import com.atguigu.iot.platform.mapper.DeviceConnectLogMapper;
import com.atguigu.iot.platform.mapper.DeviceInfoMapper;
import com.atguigu.iot.platform.pojo.DeviceConnectLog;
import com.atguigu.iot.platform.pojo.DeviceInfo;
import com.atguigu.iot.platform.service.DeviceConnectLogService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/***
 * 设备连接日志相关的接口类的实现类
 */
@Service
public class DeviceConnectLogServiceImpl implements DeviceConnectLogService {

    @Autowired
    private DeviceConnectLogMapper deviceConnectLogMapper;

    @Autowired
    private DeviceInfoMapper deviceInfoMapper;

    /**
     * 设备连接和断开连接的处理
     *
     * @param event
     * @param message
     */
    @Override
    public void saveDeviceConnectLog(String event, JSONObject message) {
        //判断当前是连接还是断开连接
        String status = event.equals(GuiguEmqxConstants.EVENT_CONNECTD)?"1":"0";
        //获取clientid获取username
        String clientid = message.get("clientid").toString();
        String username = message.get("username").toString();
        //查询设备的信息
        DeviceInfo deviceInfo =
                deviceInfoMapper.selectOne(
                        new LambdaQueryWrapper<DeviceInfo>()
                                .eq(DeviceInfo::getClientId, clientid)
                                .eq(DeviceInfo::getUsername, username)
                                .eq(DeviceInfo::getStatus, "1")
                                .last("limit 1"));
        if(deviceInfo != null){
            DeviceConnectLog deviceConnectLog = new DeviceConnectLog();
            deviceConnectLog.setDeviceId(deviceInfo.getId());
            deviceConnectLog.setProductId(deviceInfo.getProductId());
            deviceConnectLog.setStatus(status);
            deviceConnectLog.setDimensionTime(new Date());
            deviceConnectLog.setCreateTime(new Date());
            //保存设备的连接信息日志
            deviceConnectLogMapper.insert(deviceConnectLog);
            //修改设备的在线状态为在线
            deviceInfo.setRunStatus(status);
            deviceInfoMapper.updateById(deviceInfo);
        }
    }
}
