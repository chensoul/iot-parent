package com.atguigu.iot.platform.mapper;

import com.atguigu.iot.platform.pojo.TopicTemplate;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/***
 * topic模板表的mapper映射
 */
@Mapper
public interface TopicTemplateMapper extends BaseMapper<TopicTemplate> {
}
