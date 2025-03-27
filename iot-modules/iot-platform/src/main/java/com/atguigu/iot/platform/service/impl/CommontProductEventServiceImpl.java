package com.atguigu.iot.platform.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.atguigu.iot.platform.mapper.ProductInfoMapper;
import com.atguigu.iot.platform.mapper.ProductModelEventMapper;
import com.atguigu.iot.platform.pojo.ProductInfo;
import com.atguigu.iot.platform.pojo.ProductModelEvent;
import com.atguigu.iot.platform.service.CommontProductEventService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommontProductEventServiceImpl implements CommontProductEventService {

    @Autowired
    private ProductModelEventMapper productModelEventMapper;
    @Autowired
    private ProductInfoMapper productInfoMapper;
    /**
     * 根据产品的key和标识符获取产品的事件详细信息
     *
     * @param key
     * @param identifier
     * @param value
     * @return
     */
    @Override
    public String getProductModelEventInfo(String key, String identifier, JSONObject value) {
        ProductInfo productInfo =
                productInfoMapper.selectOne(
                        new LambdaQueryWrapper<ProductInfo>()
                                .eq(ProductInfo::getProductKey, key));
        //找到了产品的事件的详细信息
        ProductModelEvent productModelEvent = productModelEventMapper.selectOne(
                new LambdaQueryWrapper<ProductModelEvent>()
                        .eq(ProductModelEvent::getProductId, productInfo.getId())
                        .eq(ProductModelEvent::getIdentifier, identifier));
        //判断是否为枚举类型
        String name = productModelEvent.getName();
        String outputParams = productModelEvent.getOutputParams();
        JSONArray objects = JSON.parseArray(outputParams);
        for (Object object : objects) {
            JSONObject jsonObject = JSONObject.parseObject(object.toString());
            if(jsonObject.get("dataTypeId").toString().equals("4")){
                //枚举数据
                JSONObject typeParams = JSONObject.parseObject(jsonObject.get("typeParams").toString());
                JSONArray enumList = JSON.parseArray(typeParams.get("enumList").toString());
                for (Object o : enumList) {
                    JSONObject jsonObject1 = JSONObject.parseObject(o.toString());
                    if(jsonObject1.get("value").toString().equals(value.get(jsonObject.get("identifier")))){
                        name += ":" + jsonObject.get("name") + "-" + jsonObject1.get("name");
                        break;
                    }
                }
            }
        }
        return name;
    }
}
