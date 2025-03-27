package com.atguigu.iot.controller.platform;

import com.atguigu.iot.common.result.Result;
import com.atguigu.iot.platform.pojo.DeviceInfo;
import com.atguigu.iot.platform.query.DeviceInfoQuery;
import com.atguigu.iot.platform.service.DeviceInfoService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * 设备管理的控制层
 */
@RestController
@RequestMapping(value = "/platform/deviceInfo")
public class DeviceInfoController {

    @Autowired
    private DeviceInfoService deviceInfoService;

    /**
     * 分页条件查询设备列表
     * @param deviceInfoQuery
     * @return
     */
    @GetMapping(value = "/list")
    public Result list(DeviceInfoQuery deviceInfoQuery){
        return Result.ok(deviceInfoService.list(deviceInfoQuery));
    }

    /**
     * 新增设备
     * @param deviceInfo
     * @return
     */
    @PostMapping
    public Result save(@RequestBody DeviceInfo deviceInfo){
        deviceInfoService.saveDeviceInfo(deviceInfo);
        return Result.ok();
    }

    /**
     * 删除设备
     * @param ids
     * @return
     */
    @DeleteMapping(value = "/{ids}")
    public Result delete(@PathVariable(value = "ids") List<Long> ids){
        return Result.ok(deviceInfoService.removeBatchByIds(ids));
    }

    /**
     * 查询设备的信息+设备所属的产品的信息
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public Result getOne(@PathVariable(value = "id") Long id){
        return Result.ok(deviceInfoService.getOne(id));
    }

    /**
     * 查询产品的设备列表
     * @return
     */
    @GetMapping(value = "/listAll/{productId}")
    public Result listAll(@PathVariable(value = "productId") Long productId){
        return Result.ok(deviceInfoService.list(
                new LambdaQueryWrapper<DeviceInfo>()
                        .eq(DeviceInfo::getProductId, productId)));
    }
}
