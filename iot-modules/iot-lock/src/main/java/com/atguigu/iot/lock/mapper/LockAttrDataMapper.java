package com.atguigu.iot.lock.mapper;

import com.atguigu.iot.lock.pojo.LockAttrData;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/***
 * 状态表的mapper映射
 */
@Mapper
public interface LockAttrDataMapper extends BaseMapper<LockAttrData> {
}
