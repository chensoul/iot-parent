package com.atguigu.iot.platform.mapper;

import com.atguigu.iot.platform.pojo.ProductModelEvent;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 物模型事件的mapper映射
 */
@Mapper
public interface ProductModelEventMapper extends BaseMapper<ProductModelEvent> {
}
