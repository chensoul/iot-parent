package com.atguigu.iot.platform.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.atguigu.iot.platform.mapper.DeviceConnectCountMapper;
import com.atguigu.iot.platform.mapper.DeviceInfoMapper;
import com.atguigu.iot.platform.mapper.DeviceMessageCountMapper;
import com.atguigu.iot.platform.mapper.DeviceOptionLogMapper;
import com.atguigu.iot.platform.pojo.DeviceConnectCount;
import com.atguigu.iot.platform.pojo.DeviceInfo;
import com.atguigu.iot.platform.pojo.DeviceMessageCount;
import com.atguigu.iot.platform.pojo.DeviceOptionLog;
import com.atguigu.iot.platform.query.DataTimeQuery;
import com.atguigu.iot.platform.query.DeviceOptionLogQuery;
import com.atguigu.iot.platform.service.DataCountService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/***
 * 数据统计接口的实现类
 */
@Service
public class DataCountServiceImpl implements DataCountService {

    @Autowired
    private DeviceConnectCountMapper deviceConnectCountMapper;

    @Autowired
    private DeviceInfoMapper deviceInfoMapper;
    /**
     * 查询设备的统计信息
     *
     * @param dataTimeQuery
     * @return
     */
    @Override
    public Map<String, Object> getDeviceData(DataTimeQuery dataTimeQuery) {
        //返回结果初始化
        JSONObject result = new JSONObject();
        //获取开始时间
        String beginTime = dataTimeQuery.getBeginTime();
        //获取结束时间
        String endTime = dataTimeQuery.getEndTime() + " 23:59:59";
        //查询
        List<DeviceConnectCount> deviceConnectCounts =
                deviceConnectCountMapper.selectList(
                        new LambdaQueryWrapper<DeviceConnectCount>()
                                .between(DeviceConnectCount::getDimensionTime, beginTime, endTime)
                                .orderByAsc(DeviceConnectCount::getDimensionTime));
        //时间列表
        List<String> dateList = new CopyOnWriteArrayList<>();
        //数量列表
        List<Integer> numList = new CopyOnWriteArrayList<>();
        //包装存储
        deviceConnectCounts.stream().forEach(count->{
            //时间存储
            dateList.add(new DateTime(count.getDimensionTime()).toString("MM/dd HH:mm"));
            //数量存储
            numList.add(count.getNum());
        });
        //存储到返回结果集
        result.put("dateList", dateList);
        result.put("numList", numList);
        //查询总设备数
        Long totalNum =
                deviceInfoMapper.selectCount(null);
        result.put("totalNum", totalNum);
        //查询当前在线设备数
        Long runNum =
                deviceInfoMapper.selectCount(
                        new LambdaQueryWrapper<DeviceInfo>()
                                .eq(DeviceInfo::getRunStatus, "1"));
        result.put("runNum", runNum);
        //返回
        return result;
    }

    @Autowired
    private DeviceMessageCountMapper deviceMessageCountMapper;

    @Autowired
    private DeviceOptionLogMapper deviceOptionLogMapper;
    /**
     * 查询TPS统计信息
     *
     * @param dataTimeQuery
     * @return
     */
    @Override
    public Map<String, Object> getMessageData(DataTimeQuery dataTimeQuery) {
        //返回结果初始化
        JSONObject result = new JSONObject();
        //获取开始时间
        String beginTime = dataTimeQuery.getBeginTime();
        //获取结束时间
        String endTime = dataTimeQuery.getEndTime() + " 23:59:59";
        //查询tps
        List<DeviceMessageCount> deviceMessageCounts =
                deviceMessageCountMapper.selectList(
                        new LambdaQueryWrapper<DeviceMessageCount>()
                                .between(DeviceMessageCount::getDimensionTime, beginTime, endTime)
                                .orderByAsc(DeviceMessageCount::getDimensionTime));
        //时间列表
        List<String> dateList = new CopyOnWriteArrayList<>();
        //数量列表
        List<Integer> numList = new CopyOnWriteArrayList<>();
        //遍历
        deviceMessageCounts.stream().forEach(deviceMessageCount -> {
            //保存时间
            dateList.add(new DateTime(deviceMessageCount.getDimensionTime()).toString("MM/dd HH:mm"));
            //保存数量
            numList.add(deviceMessageCount.getNum());
        });
        //存储到返回结果集
        result.put("dateList", dateList);
        result.put("numList", numList);
        //实时消息上下行 TPS: 当前系统时间和1小时以前
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.add(Calendar.HOUR, -1);
        Date time = instance.getTime();
        Long count =
                deviceOptionLogMapper.selectCount(
                        new LambdaQueryWrapper<DeviceOptionLog>()
                                .between(DeviceOptionLog::getDimensionTime, time, new Date()));
        result.put("runNum", count);
        //返回
        return result;
    }
}
