package com.atguigu.iot.controller.platform;

import com.atguigu.iot.common.result.Result;
import com.atguigu.iot.platform.query.DataTimeQuery;
import com.atguigu.iot.platform.service.DataCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * 统计信息的控制层
 */
@RestController
@RequestMapping(value = "/platform/dataCount")
public class DataCountController {


    @Autowired
    private DataCountService dataCountService;


    /**
     * 查询设备的统计信息
     * @param dataTimeQuery
     * @return
     */
    @GetMapping(value = "/getDeviceData")
    public Result getDeviceData(DataTimeQuery dataTimeQuery){
        return Result.ok(dataCountService.getDeviceData(dataTimeQuery));
    }

    /**
     * 查询TPS统计信息
     * @param dataTimeQuery
     * @return
     */
    @GetMapping(value = "/getMessageData")
    public Result getMessageData(DataTimeQuery dataTimeQuery){
        return Result.ok(dataCountService.getMessageData(dataTimeQuery));
    }

}
