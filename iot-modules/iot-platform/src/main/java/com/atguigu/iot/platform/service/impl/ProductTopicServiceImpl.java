package com.atguigu.iot.platform.service.impl;

import com.atguigu.iot.platform.mapper.ProductInfoMapper;
import com.atguigu.iot.platform.mapper.ProductTopicMapper;
import com.atguigu.iot.platform.pojo.ProductInfo;
import com.atguigu.iot.platform.pojo.ProductTopic;
import com.atguigu.iot.platform.service.ProductTopicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/***
 * 产品topic的接口类的实现类
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ProductTopicServiceImpl
        extends ServiceImpl<ProductTopicMapper, ProductTopic>
        implements ProductTopicService {

    @Autowired
    private ProductInfoMapper productInfoMapper;

    /**
     * 保存自定义的topic
     *
     * @param productTopic
     */
    @Override
    public void saveproductTopic(ProductTopic productTopic) {
        //查询产品的信息
        ProductInfo productInfo =
                productInfoMapper.selectById(productTopic.getProductId());
        if(productInfo == null){
            return;
        }
        //将topic标准化
        productTopic.setTopic("custom/" + productInfo.getProductKey()
                + "/${clientId}/" + productTopic.getTopic());
        save(productTopic);
    }
}
