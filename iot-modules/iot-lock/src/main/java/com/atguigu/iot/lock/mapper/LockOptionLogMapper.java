package com.atguigu.iot.lock.mapper;

import com.atguigu.iot.lock.pojo.LockOptionLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/***
 * 设备日志表mapper
 */
@Mapper
public interface LockOptionLogMapper extends BaseMapper<LockOptionLog> {
}
