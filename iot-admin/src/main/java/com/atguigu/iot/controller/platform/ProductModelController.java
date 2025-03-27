package com.atguigu.iot.controller.platform;

import com.atguigu.iot.common.result.Result;
import com.atguigu.iot.platform.mapper.DeviceAttrDataMapper;
import com.atguigu.iot.platform.query.DeviceAtrrDataQuery;
import com.atguigu.iot.platform.service.IProductModelService;
import com.atguigu.iot.platform.vo.ProductModelVo;
import com.atguigu.iot.platform.vo.PropertyVo;
import com.atguigu.iot.platform.vo.ServiceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/***
 * 产品的功能定义的控制层
 */
@RestController
@RequestMapping(value = "/platform/productModel")
public class ProductModelController {

    @Autowired
    private IProductModelService iProductModelService;

    /**
     * 保存产品的功能定义: 物模型
     * @param productModelVo
     * @return
     */
    @PostMapping
    public Result save(@RequestBody ProductModelVo productModelVo){
        iProductModelService.save(productModelVo);
        return Result.ok();
    }

    /**
     * 查询产品物模型数据
     * @param productId
     * @return
     */
    @GetMapping(value = "/list/{productId}")
    public Result list(@PathVariable(value = "productId") Long productId){
        return Result.ok(iProductModelService.list(productId));
    }

    /**
     * 修改
     * @param productModelVo
     * @return
     */
    @PutMapping
    public Result update(@RequestBody ProductModelVo productModelVo){
        iProductModelService.update(productModelVo);
        return Result.ok();
    }

    /**
     * 删除属性
     * @param type
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{type}/{id}")
    public Result delete(@PathVariable(value = "type") Integer type,
                         @PathVariable(value = "id") Long id){
        iProductModelService.delete(type, id);
        return Result.ok();
    }

    /**
     * 查询设备运行状态接口
     * @return
     */
    @GetMapping(value = "/modelAttrValueList/{productId}/{deviceId}")
    public Result modelAttrValueList(@PathVariable(value = "productId") Long productId,
                                     @PathVariable(value = "deviceId") Long deviceId){
        return Result.ok(iProductModelService.modelAttrValueList(productId, deviceId));
    }

    /**
     * 返回设备某个属性的运行明细
     * @param deviceAtrrDataQuery
     * @return
     */
    @GetMapping(value = "/deviceAtrrDataList")
    public Result deviceAtrrDataList(DeviceAtrrDataQuery deviceAtrrDataQuery){
        return Result.ok(iProductModelService.deviceAtrrDataList(deviceAtrrDataQuery));
    }

    /**
     * 设备的事件明细查询
     * @param pageNum
     * @param pageSize
     * @param deviceId
     * @return
     */
    @GetMapping(value = "/deviceEventDataList")
    public Result deviceEventDataList(Integer pageNum,
                                      Integer pageSize,
                                      Long deviceId){
        return Result.ok(iProductModelService.deviceEventDataList(pageNum, pageSize, deviceId));
    }

    /**
     * 设备的服务明细查询
     * @param pageNum
     * @param pageSize
     * @param deviceId
     * @return
     */
    @GetMapping(value = "/deviceServiceDataList")
    public Result deviceServiceDataList(Integer pageNum,
                                      Integer pageSize,
                                      Long deviceId){
        return Result.ok(iProductModelService.deviceServiceDataList(pageNum, pageSize, deviceId));
    }

    /**
     * 查询产品的物模型数据
     * @param productId
     * @return
     */
    @GetMapping(value = "/modelAttrList/{productId}")
    public Result modelAttrList(@PathVariable(value = "productId") Long productId){
        return Result.ok(iProductModelService.modelAttrList(productId));
    }

    /**
     * 查询产品的服务调用数据
     * @param productId
     * @return
     */
    @GetMapping(value = "/modelServiceList/{productId}")
    public Result modelServiceList(@PathVariable(value = "productId") Long productId){
        return Result.ok(iProductModelService.modelServiceList(productId));
    }

    /**
     * 属性设置在线调试
     * @param propertyVo
     * @return
     */
    @PostMapping(value = "/propertySet")
    public Result propertySet(@RequestBody PropertyVo propertyVo){
        iProductModelService.propertySet(propertyVo);
        return Result.ok();
    }

    /**
     * 服务调用的在线调试
     * @param serviceVo
     * @return
     */
    @PostMapping(value = "/service")
    public Result service(@RequestBody ServiceVo serviceVo){
        iProductModelService.service(serviceVo);
        return Result.ok();
    }

}
