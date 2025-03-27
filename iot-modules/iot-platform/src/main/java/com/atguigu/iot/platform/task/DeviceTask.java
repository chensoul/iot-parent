package com.atguigu.iot.platform.task;

import com.atguigu.iot.platform.mapper.DeviceConnectCountMapper;
import com.atguigu.iot.platform.mapper.DeviceConnectLogMapper;
import com.atguigu.iot.platform.mapper.DeviceMessageCountMapper;
import com.atguigu.iot.platform.mapper.DeviceOptionLogMapper;
import com.atguigu.iot.platform.pojo.DeviceConnectCount;
import com.atguigu.iot.platform.pojo.DeviceMessageCount;
import com.atguigu.iot.platform.vo.DataCountVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/***
 * 设备相关的定时任务
 */
@Component
public class DeviceTask {

    @Autowired
    private DeviceConnectLogMapper deviceConnectLogMapper;

    @Autowired
    private DeviceConnectCountMapper deviceConnectCountMapper;

    /**
     * 设备的连接数统计定时任务: 每1个小时统计一次
     */
//    @Scheduled(cron = "0 0 0/1 * * *")
    @Scheduled(cron = "5/30 * * * * *")//每30秒执行一次
    public void deviceConnectCountTask(){
        //获取当前系统时间
        Date endDate = new Date();
        //获取1小时以前的时间
        Calendar instance = Calendar.getInstance();
        instance.setTime(endDate);
        //减一小时
        instance.add(Calendar.HOUR, -1);
        Date startDate = instance.getTime();
        //查询当前开始时间和结束时间之间的设备连接统计结果
        List<DataCountVo> dataCountVoList
                = deviceConnectLogMapper.selectDeviceConnectLogCount(startDate, endDate);
        //将结果同步到统计表 device_connect_count
        dataCountVoList.stream().forEach(dataCountVo -> {
            //查询旧的
            DeviceConnectCount deviceConnectCount = deviceConnectCountMapper.selectOne(
                    new LambdaQueryWrapper<DeviceConnectCount>()
                            .eq(DeviceConnectCount::getDimensionTime, dataCountVo.getDimensionTime()));
            if(deviceConnectCount == null){
                //新增新的
                deviceConnectCount = new DeviceConnectCount();
                deviceConnectCount.setDimensionTime(dataCountVo.getDimensionTime());
                deviceConnectCount.setNum(dataCountVo.getNum());
                deviceConnectCount.setCreateTime(new Date());
                deviceConnectCount.setUpdateTime(new Date());
                deviceConnectCountMapper.insert(deviceConnectCount);
            }else{
                deviceConnectCount.setNum(dataCountVo.getNum());
                deviceConnectCount.setUpdateTime(new Date());
                deviceConnectCountMapper.updateById(deviceConnectCount);
            }
        });
    }

    @Autowired
    private DeviceOptionLogMapper deviceOptionLogMapper;

    @Autowired
    private DeviceMessageCountMapper deviceMessageCountMapper;
    /**
     * 统计设备的TPS
     */
    @Scheduled(cron = "5/30 * * * * *")//每30秒执行一次
    public void deviceTpsCountTask(){
        //获取当前系统时间
        Date endDate = new Date();
        //获取1小时以前的时间
        Calendar instance = Calendar.getInstance();
        instance.setTime(endDate);
        //减一小时
        instance.add(Calendar.HOUR, -1);
        Date startDate = instance.getTime();
        //查询当前开始时间和结束时间之间的设备连接统计结果
        List<DataCountVo> dataCountVoList
                = deviceOptionLogMapper.selectTpsCount(startDate, endDate);
        dataCountVoList.stream().forEach(count->{
            //查询
            DeviceMessageCount deviceMessageCount =
                    deviceMessageCountMapper.selectOne(
                            new LambdaQueryWrapper<DeviceMessageCount>()
                                    .eq(DeviceMessageCount::getDimensionTime, count.getDimensionTime()));
            if(deviceMessageCount == null){
                //新增
                deviceMessageCount = new DeviceMessageCount();
                deviceMessageCount.setDimensionTime(count.getDimensionTime());
                deviceMessageCount.setNum(count.getNum());
                deviceMessageCount.setCreateTime(new Date());
                deviceMessageCount.setUpdateTime(new Date());
                deviceMessageCountMapper.insert(deviceMessageCount);
            }else{
                deviceMessageCount.setNum(count.getNum());
                deviceMessageCount.setUpdateTime(new Date());
                deviceMessageCountMapper.updateById(deviceMessageCount);
            }
        });
    }
}
