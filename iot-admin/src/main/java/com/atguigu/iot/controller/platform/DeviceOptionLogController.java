package com.atguigu.iot.controller.platform;

import com.atguigu.iot.common.result.Result;
import com.atguigu.iot.platform.query.DeviceOptionLogQuery;
import com.atguigu.iot.platform.service.DeviceOptionLogSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * 设备操作日志的控制层
 */
@RestController
@RequestMapping(value = "/platform/deviceOptionLog")
public class DeviceOptionLogController {

    @Autowired
    private DeviceOptionLogSerivce deviceOptionLogSerivce;


    /**
     * 分页条件查询日志数据
     * @param deviceOptionLogQuery
     * @return
     */
    @GetMapping(value = "/list")
    public Result list(DeviceOptionLogQuery deviceOptionLogQuery){
        return Result.ok(deviceOptionLogSerivce.list(deviceOptionLogQuery));
    }
}
