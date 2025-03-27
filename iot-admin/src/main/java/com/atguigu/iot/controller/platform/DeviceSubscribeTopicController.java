package com.atguigu.iot.controller.platform;

import com.atguigu.iot.common.result.Result;
import com.atguigu.iot.platform.pojo.DeviceSubscribeTopic;
import com.atguigu.iot.platform.service.DeviceSubscribeTopicService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * 设备订阅topic操作的控制层
 */
@RestController
@RequestMapping(value = "/platform/deviceSubscribeTopic")
public class DeviceSubscribeTopicController {

    @Autowired
    private DeviceSubscribeTopicService deviceSubscribeTopicService;


    /**
     * 查询设备订阅的topic列表
     * @param id
     * @return
     */
    @GetMapping(value = "/list/{id}")
    public Result list(@PathVariable(value = "id") Long id){
        return Result.ok(deviceSubscribeTopicService.list(
                new LambdaQueryWrapper<DeviceSubscribeTopic>()
                        .eq(DeviceSubscribeTopic::getStatus, "1")
                        .eq(DeviceSubscribeTopic::getDeviceId, id)));
    }
}
