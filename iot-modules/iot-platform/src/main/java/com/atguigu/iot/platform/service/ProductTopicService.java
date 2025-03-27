package com.atguigu.iot.platform.service;

import com.atguigu.iot.platform.pojo.ProductTopic;
import com.baomidou.mybatisplus.extension.service.IService;

/***
 * 产品topic的接口类
 */
public interface ProductTopicService extends IService<ProductTopic> {
    /**
     * 保存自定义的topic
     * @param productTopic
     */
    void saveproductTopic(ProductTopic productTopic);
}
