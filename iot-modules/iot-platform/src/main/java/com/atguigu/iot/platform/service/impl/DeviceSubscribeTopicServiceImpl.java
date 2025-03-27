package com.atguigu.iot.platform.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.atguigu.iot.common.constant.GuiguEmqxConstants;
import com.atguigu.iot.platform.mapper.DeviceInfoMapper;
import com.atguigu.iot.platform.mapper.DeviceSubscribeTopicMapper;
import com.atguigu.iot.platform.pojo.DeviceInfo;
import com.atguigu.iot.platform.pojo.DeviceSubscribeTopic;
import com.atguigu.iot.platform.service.DeviceSubscribeTopicService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

/***
 * 设备订阅topic的接口类的实现类
 */
@Service
public class DeviceSubscribeTopicServiceImpl
    extends ServiceImpl<DeviceSubscribeTopicMapper, DeviceSubscribeTopic>
        implements DeviceSubscribeTopicService {

    @Autowired
    private DeviceInfoMapper deviceInfoMapper;

    /**
     * 保存设备订阅和取消订阅的topic事件
     *
     * @param event
     * @param message
     */
    @Override
    public void saveDeviceSubscribeTopic(String event, JSONObject message) {
        //获取topic
        String topic = message.get("topic").toString();
        //获取clientid
        String clientid = message.get("clientid").toString();
        //获取username
        String username = message.get("username").toString();
        //获取设备的信息
        DeviceInfo deviceInfo =
                deviceInfoMapper.selectOne(
                        new LambdaQueryWrapper<DeviceInfo>()
                                .eq(DeviceInfo::getClientId, clientid)
                                .eq(DeviceInfo::getUsername, username)
                                .eq(DeviceInfo::getStatus, "1")
                                .last("limit 1"));
        if(deviceInfo != null){
            //判断本次是订阅(新增)还是取消订阅(删除)
            if(event.equals(GuiguEmqxConstants.TEVENT_SUBSCRIBED)){
                //订阅
                DeviceSubscribeTopic deviceSubscribeTopic = new DeviceSubscribeTopic();
                deviceSubscribeTopic.setDeviceId(deviceInfo.getId());
                deviceSubscribeTopic.setProductId(deviceInfo.getProductId());
                deviceSubscribeTopic.setStatus("1");
                deviceSubscribeTopic.setTopic(topic);
                save(deviceSubscribeTopic);
            }else{
                //取消订阅
                remove(new LambdaQueryWrapper<DeviceSubscribeTopic>()
                        .eq(DeviceSubscribeTopic::getDeviceId, deviceInfo.getId())
                        .eq(DeviceSubscribeTopic::getStatus, "1")
                        .eq(DeviceSubscribeTopic::getTopic, topic));
            }
        }
    }
}
