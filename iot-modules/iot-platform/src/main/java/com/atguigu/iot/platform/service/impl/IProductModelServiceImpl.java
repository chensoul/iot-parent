package com.atguigu.iot.platform.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson2.JSONObject;
import com.atguigu.iot.common.constant.GuiguEmqxConstants;
import com.atguigu.iot.platform.emqx.EmqxConfig;
import com.atguigu.iot.platform.mapper.*;
import com.atguigu.iot.platform.pojo.*;
import com.atguigu.iot.platform.query.DeviceAtrrDataQuery;
import com.atguigu.iot.platform.service.IProductModelService;
import com.atguigu.iot.platform.vo.*;
import com.atguigu.iot.web.execption.GuiguException;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/***
 * 产品物模型的接口类的实现类
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class IProductModelServiceImpl implements IProductModelService {

    @Autowired
    private ProductModelAttrMapper productModelAttrMapper;

    @Autowired
    private ProductModelEventMapper productModelEventMapper;

    @Autowired
    private ProductModelServiceMapper productModelServiceMapper;

    /**
     * 保存产品的功能定义: 物模型
     *
     * @param productModelVo
     */
    @Override
    public void save(ProductModelVo productModelVo) {
        //获取本次保存的数据的类型: 1-属性 2-服务 3-事件
        Integer modelType = productModelVo.getModelType();
        //根据不同的值做不同的表操作
        switch (modelType){
            case 1 -> {
                //删除旧的相同标识符的内容
                productModelAttrMapper.delete(
                        new LambdaQueryWrapper<ProductModelAttr>()
                                .eq(ProductModelAttr::getProductId, productModelVo.getProductId())
                                .eq(ProductModelAttr::getIdentifier, productModelVo.getIdentifier()));
                //属性保存
                ProductModelAttr productModelAttr = new ProductModelAttr();
                //属性转移
                BeanUtils.copyProperties(productModelVo, productModelAttr);
                //补全操作人和时间和状态
                productModelAttr.setCreateBy(StpUtil.getLoginIdAsString());
                productModelAttr.setCreateTime(new Date());
                productModelAttr.setStatus("1");
                //保存数据
                productModelAttrMapper.insert(productModelAttr);
            }
            case 2 -> {
                //删除旧的相同标识符的内容
                productModelServiceMapper.delete(
                        new LambdaQueryWrapper<ProductModelService>()
                                .eq(ProductModelService::getProductId, productModelVo.getProductId())
                                .eq(ProductModelService::getIdentifier, productModelVo.getIdentifier()));
                //服务保存
                ProductModelService productModelService = new ProductModelService();
                BeanUtils.copyProperties(productModelVo, productModelService);
                //补全操作人和时间和状态
                productModelService.setCreateBy(StpUtil.getLoginIdAsString());
                productModelService.setCreateTime(new Date());
                productModelService.setStatus("1");
                //保存数据
                productModelServiceMapper.insert(productModelService);
            }
            case 3 -> {
                //删除旧的相同标识符的内容
                productModelEventMapper.delete(
                        new LambdaQueryWrapper<ProductModelEvent>()
                                .eq(ProductModelEvent::getProductId, productModelVo.getProductId())
                                .eq(ProductModelEvent::getIdentifier, productModelVo.getIdentifier()));
                //事件保存
                ProductModelEvent productModelEvent = new ProductModelEvent();
                BeanUtils.copyProperties(productModelVo, productModelEvent);
                //补全操作人和时间和状态
                productModelEvent.setCreateBy(StpUtil.getLoginIdAsString());
                productModelEvent.setCreateTime(new Date());
                productModelEvent.setStatus("1");
                //保存数据
                productModelEventMapper.insert(productModelEvent);
            }
        }
    }

    /**
     * 查询产品物模型数据
     *
     * @param productId
     * @return
     */
    @Override
    public Map<String, Object> list(Long productId) {
        //返回结果初始化
        Map<String, Object> result = new ConcurrentHashMap<>();
        //查询属性数据: 1s
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            List<ProductModelAttr> productModelAttrs =
                    productModelAttrMapper.selectList(
                            new LambdaQueryWrapper<ProductModelAttr>()
                                    .eq(ProductModelAttr::getProductId, productId)
                                    .eq(ProductModelAttr::getStatus, "1"));
            result.put("productModelAttrList", productModelAttrs);
        });
        //查询服务数据: 2s
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            List<ProductModelService> productModelServices =
                    productModelServiceMapper.selectList(
                            new LambdaQueryWrapper<ProductModelService>()
                                    .eq(ProductModelService::getProductId, productId)
                                    .eq(ProductModelService::getStatus, "1"));
            result.put("productModelServiceList", productModelServices);
        });
        //查询事件数据: 3s
        CompletableFuture<Void> future3 = CompletableFuture.runAsync(() -> {
            List<ProductModelEvent> productModelEvents =
                    productModelEventMapper.selectList(
                            new LambdaQueryWrapper<ProductModelEvent>()
                                    .eq(ProductModelEvent::getProductId, productId)
                                    .eq(ProductModelEvent::getStatus, "1"));
            result.put("productModelEventList", productModelEvents);
        });
        //并行-->所有任务执行完成返回: 这三个任务同时运行,最耗时的就是这个接口的耗时时间
        CompletableFuture.allOf(future1, future2, future3).join();
        //包装返回
        return result;
    }

    /**
     * 删除属性
     *
     * @param type
     * @param id
     */
    @Override
    public void delete(Integer type, Long id) {
        //根据不同的值做不同的表操作
        switch (type){
            //删除属性
            case 1 -> productModelAttrMapper.deleteById(id);
            //删除服务
            case 2 -> productModelServiceMapper.deleteById(id);
            //删除事件
            case 3 -> productModelEventMapper.deleteById(id);
        }
    }

    @Autowired
    private DeviceAttrDataMapper deviceAttrDataMapper;
    /**
     * 查询设备运行状态接口
     *
     * @param productId
     * @param deviceId
     * @return
     */
    @Override
    public List<ProductModelAttrValueVo> modelAttrValueList(Long productId, Long deviceId) {
        //根据产品的id找出这个产品全部的属性信息
        List<ProductModelAttr> productModelAttrs = productModelAttrMapper.selectList(
                new LambdaQueryWrapper<ProductModelAttr>()
                        .eq(ProductModelAttr::getProductId, productId));
        //遍历,获取每个属性在当前设备中的最新值是什么
        return productModelAttrs.stream().map(attr->{
            //返回结果初始化
            ProductModelAttrValueVo productModelAttrValueVo = new ProductModelAttrValueVo();
            productModelAttrValueVo.setDeviceId(deviceId);
            //属性转移
            BeanUtils.copyProperties(attr, productModelAttrValueVo);
            //查询当前属性在当前设备中的最后一条数据是什么
            DeviceAttrData deviceAttrData =
                    deviceAttrDataMapper.selectOne(
                            new LambdaQueryWrapper<DeviceAttrData>()
                                    .eq(DeviceAttrData::getStatus, "1")
                                    .eq(DeviceAttrData::getDeviceId, deviceId)
                                    .eq(DeviceAttrData::getModelAttrId, attr.getId())
                                    .orderByDesc(DeviceAttrData::getId)
                                    .last("limit 1"));
            if(deviceAttrData != null){
                productModelAttrValueVo.setLastCreateTime(new Date());
                //获取这个设备的这个属性最后一条状态的值是多少
                String dataValue = deviceAttrData.getDataValue();
                productModelAttrValueVo.setDataValue(dataValue);
                if(deviceAttrData != null){
                    //获取属性的值的类型: 整型 浮点型 字符串类型  枚举(4)
                    Long dataTypeId = attr.getDataTypeId();
                    //若为枚举类型
                    if(dataTypeId.intValue() == 4){
                        //获取属性值对象
                        String typeParams = attr.getTypeParams();
                        //反序列化为list
                        JSONObject typeParamsJson = JSONObject.parseObject(typeParams);
                        List enumList = JSONObject.parseObject(JSONObject.toJSONString(typeParamsJson.get("enumList")), List.class);
                        //遍历找到当前这个属性的名字
                        enumList.stream().forEach(o->{
                            //反序列化为对象
                            JSONObject jsonObject =
                                    JSONObject.parseObject(JSONObject.toJSONString(o));
                            if(jsonObject.get("value").toString().equals(dataValue)){
                                productModelAttrValueVo.setDataValue(jsonObject.get("name").toString());
                            }
                        });
                    }
                }
            }
            return productModelAttrValueVo;
        }).collect(Collectors.toList());
    }

    /**
     * 返回设备某个属性的运行明细
     *
     * @param deviceAtrrDataQuery
     * @return
     */
    @Override
    public Page<DeviceAttrData> deviceAtrrDataList(DeviceAtrrDataQuery deviceAtrrDataQuery) {
        return deviceAttrDataMapper.selectPage(
                new Page<>(deviceAtrrDataQuery.getPageNum(), deviceAtrrDataQuery.getPageSize()),
                new LambdaQueryWrapper<DeviceAttrData>()
                        .eq(DeviceAttrData::getDeviceId, deviceAtrrDataQuery.getDeviceId())
                        .eq(DeviceAttrData::getModelAttrId, deviceAtrrDataQuery.getModelAttrId())
                        .eq(DeviceAttrData::getStatus, "1"));
    }

    @Autowired
    private DeviceServiceDataMapper deviceServiceDataMapper;
    /**
     * 设备服务明细查询
     *
     * @param pageNum
     * @param pageSize
     * @param deviceId
     * @return
     */
    @Override
    public Page<DeviceServiceDataVo> deviceServiceDataList(Integer pageNum, Integer pageSize, Long deviceId) {
        return deviceServiceDataMapper.deviceServiceDataList(
                new Page<DeviceServiceDataVo>(pageNum, pageSize),
                deviceId);
    }

    @Autowired
    private DeviceEventDataMapper deviceEventDataMapper;
    /**
     * 设备的事件明细查询
     *
     * @param pageNum
     * @param pageSize
     * @param deviceId
     * @return
     */
    @Override
    public Page<DeviceEventDataVo> deviceEventDataList(Integer pageNum,
                                                       Integer pageSize,
                                                       Long deviceId) {
        return deviceEventDataMapper.deviceEventDataList(
                new Page<DeviceEventDataVo>(pageNum, pageSize),
                deviceId);
    }

    /**
     * 查询产品的物模型数据
     *
     * @param productId
     * @return
     */
    @Override
    public List<ProductModelAttr> modelAttrList(Long productId) {
        return productModelAttrMapper.selectList(
                new LambdaQueryWrapper<ProductModelAttr>()
                        .eq(ProductModelAttr::getProductId, productId)
                        .eq(ProductModelAttr::getStatus, "1"));
    }

    /**
     * 查询产品的服务调用数据
     *
     * @param productId
     * @return
     */
    @Override
    public List<ProductModelService> modelServiceList(Long productId) {
        return productModelServiceMapper.selectList(
                new LambdaQueryWrapper<ProductModelService>()
                        .eq(ProductModelService::getProductId, productId)
                        .eq(ProductModelService::getStatus, "1"));
    }

    /**
     * 修改产品的服务调用数据
     *
     * @param productModelVo
     */
    @Override
    public void update(ProductModelVo productModelVo) {
        //类型:1-属性 2-服务 3-事件
        Integer modelType = productModelVo.getModelType();
        switch (modelType){
            case 1-> {
                //属性
                ProductModelAttr productModelAttr =
                        productModelAttrMapper.selectById(productModelVo.getId());
                BeanUtils.copyProperties(productModelVo, productModelAttr);
                productModelAttrMapper.updateById(productModelAttr);
            }
            case 2->{
                //服务
                ProductModelService productModelService =
                        productModelServiceMapper.selectById(productModelVo.getId());
                BeanUtils.copyProperties(productModelVo, productModelService);
                productModelServiceMapper.updateById(productModelService);
            }
            case 3->{
                //事件
                ProductModelEvent productModelEvent =
                        productModelEventMapper.selectById(productModelVo.getId());
                BeanUtils.copyProperties(productModelVo, productModelEvent);
                productModelEventMapper.updateById(productModelEvent);
            }
        }
    }

    @Autowired
    private DeviceInfoMapper deviceInfoMapper;

    @Autowired
    private EmqxConfig emqxConfig;

    @Autowired
    private ProductInfoMapper productInfoMapper;
    /**
     * 属性设置在线调试
     *
     * @param propertyVo
     */
    @Override
    public void propertySet(PropertyVo propertyVo) {
        //获取设备id
        Long deviceId = propertyVo.getDeviceId();
        //查询设备的信息
        DeviceInfo deviceInfo = deviceInfoMapper.selectById(deviceId);
        if(deviceInfo == null ||
            deviceInfo.getRunStatus().equals("0")){
            throw new GuiguException(201, "设备不存在或者设备下线了!");
        }
        //获取属性参数
        Map<String, Object> params = propertyVo.getParams();
        //获取标识
        Set<String> keySet = params.keySet();
        //根据设备所属的产品,获取产品的属性列表
        List<ProductModelAttr> productModelAttrs =
                productModelAttrMapper.selectList(
                        new LambdaQueryWrapper<ProductModelAttr>()
                                .eq(ProductModelAttr::getProductId, deviceInfo.getProductId())
                                .in(ProductModelAttr::getIdentifier, keySet));
        if(productModelAttrs == null ||
                productModelAttrs.size() != keySet.size()){
            throw new GuiguException(201, "设置了设备没有的属性,请检查!!");
        }
        //本次设置的属性和设备所属的产品的属性一致,给emqx服务器发送属性设置的消息
        params.put("pageId", propertyVo.getPageId());
        //查询产品的信息
        ProductInfo productInfo =
                productInfoMapper.selectById(deviceInfo.getProductId());
        //获取Topic
        String topic = MessageFormat.format(GuiguEmqxConstants.TOPIC_PROPERTY_SET,
                productInfo.getProductKey(),
                deviceInfo.getClientId());
        //发送属性设置消息
        emqxConfig.sendMessage(topic, JSONObject.toJSONString(params));
    }

    /**
     * 服务调用的在线调试
     *
     * @param serviceVo
     */
    @Override
    public void service(ServiceVo serviceVo) {
        //获取设备的id
        Long deviceId = serviceVo.getDeviceId();
        //查询设备的信息
        DeviceInfo deviceInfo = deviceInfoMapper.selectById(deviceId);
        if(deviceInfo == null ||
            deviceInfo.getRunStatus().equals("0")){
            throw new GuiguException(201, "设备不存在或者设备下线了!");
        }
        //获取标识符
        String identifier = serviceVo.getIdentifier();
        //获取设备所属的产品的服务的信息
        ProductModelService productModelService =
                productModelServiceMapper.selectOne(
                        new LambdaQueryWrapper<ProductModelService>()
                                .eq(ProductModelService::getProductId, deviceInfo.getProductId())
                                .eq(ProductModelService::getIdentifier, identifier)
                                .eq(ProductModelService::getStatus, "1"));
        if(productModelService == null){
            throw new GuiguException(201, "调试的服务不存在!");
        }
        //查询产品
        ProductInfo productInfo =
                productInfoMapper.selectById(deviceInfo.getProductId());
        //获取topic
        String topic = MessageFormat.format(GuiguEmqxConstants.TOPIC_SERVICE,
                productInfo.getProductKey(),
                deviceInfo.getClientId(),
                identifier);
        //获取参数
        Map<String, Object> params = serviceVo.getParams();
        params.put("pageId", serviceVo.getPageId());
        //发送消息
        emqxConfig.sendMessage(topic, JSONObject.toJSONString(params));
    }
}
