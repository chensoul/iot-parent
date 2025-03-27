package com.atguigu.iot.platform.mapper;

import com.atguigu.iot.platform.pojo.ProductTopic;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/***
 * 产品topic的mapper映射
 */
@Mapper
public interface ProductTopicMapper extends BaseMapper<ProductTopic> {
}
