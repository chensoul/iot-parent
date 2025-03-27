package com.atguigu.iot.platform.service;

import com.atguigu.iot.platform.pojo.DeviceAttrData;
import com.atguigu.iot.platform.pojo.ProductModelAttr;
import com.atguigu.iot.platform.pojo.ProductModelService;
import com.atguigu.iot.platform.query.DeviceAtrrDataQuery;
import com.atguigu.iot.platform.vo.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
import java.util.Map;

/***
 * 产品物模型管理的接口类
 */
public interface IProductModelService {
    /**
     * 保存产品的功能定义: 物模型
     * @param productModelVo
     */
    void save(ProductModelVo productModelVo);

    /**
     * 查询产品物模型数据
     *
     * @param productId
     * @return
     */
    Map<String, Object> list(Long productId);

    /**
     * 删除属性
     * @param type
     * @param id
     */
    void delete(Integer type, Long id);

    /**
     * 查询设备运行状态接口
     * @param productId
     * @param deviceId
     * @return
     */
    List<ProductModelAttrValueVo> modelAttrValueList(Long productId, Long deviceId);

    /**
     * 返回设备某个属性的运行明细
     * @param deviceAtrrDataQuery
     * @return
     */
    Page<DeviceAttrData> deviceAtrrDataList(DeviceAtrrDataQuery deviceAtrrDataQuery);

    /**
     * 设备服务明细查询
     * @param pageNum
     * @param pageSize
     * @param deviceId
     * @return
     */
    Page<DeviceServiceDataVo> deviceServiceDataList(Integer pageNum, Integer pageSize, Long deviceId);

    /**
     * 设备的事件明细查询
     * @param pageNum
     * @param pageSize
     * @param deviceId
     * @return
     */
    Page<DeviceEventDataVo> deviceEventDataList(Integer pageNum, Integer pageSize, Long deviceId);

    /**
     * 查询产品的物模型数据
     * @param productId
     * @return
     */
    List<ProductModelAttr> modelAttrList(Long productId);

    /**
     * 查询产品的服务调用数据
     * @param productId
     * @return
     */
    List<ProductModelService> modelServiceList(Long productId);

    /**
     * 修改产品的服务调用数据
     * @param productModelVo
     */
    void update(ProductModelVo productModelVo);

    /**
     * 属性设置在线调试
     * @param propertyVo
     */
    void propertySet(PropertyVo propertyVo);

    /**
     * 服务调用的在线调试
     * @param serviceVo
     */
    void service(ServiceVo serviceVo);
}
