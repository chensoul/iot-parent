package com.atguigu.iot.user.service.impl;

import com.atguigu.iot.user.mapper.UserDeviceMapper;
import com.atguigu.iot.user.pojo.UserDevice;
import com.atguigu.iot.user.service.UserDeviceService;
import com.atguigu.iot.web.user.UserDeviceInterface;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/***
 * 用户设备相关的接口类的实现类
 */
@Service
public class UserDeviceServiceImpl
        extends ServiceImpl<UserDeviceMapper, UserDevice>
        implements UserDeviceService , UserDeviceInterface {
    /**
     * 修改设备的在线状态
     *
     * @param clientId
     * @param status
     */
    @Override
    public void updateUserDeviceRunStatus(String clientId, String status) {
        //查询用户设备
        UserDevice userDevice =
                getOne(new LambdaQueryWrapper<UserDevice>()
                        .eq(UserDevice::getClientId, clientId)
                        .eq(UserDevice::getStatus, "1"));
        if(userDevice == null){
            return;
        }
        //修改
        userDevice.setRunStatus(status);
        updateById(userDevice);
    }

    /**
     * 查询设备的运行状态
     *
     * @param clientId
     * @return
     */
    @Override
    public String getRunStatus(String clientId) {
        return getOne(new LambdaQueryWrapper<UserDevice>()
                .eq(UserDevice::getClientId, clientId)
                .last("limit 1"))
                .getRunStatus();
    }
}
