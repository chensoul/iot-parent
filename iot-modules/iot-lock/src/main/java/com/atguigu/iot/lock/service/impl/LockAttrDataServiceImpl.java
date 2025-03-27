package com.atguigu.iot.lock.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.atguigu.iot.lock.constant.LockConstants;
import com.atguigu.iot.lock.mapper.LockAttrDataMapper;
import com.atguigu.iot.lock.mapper.LockOptionLogMapper;
import com.atguigu.iot.lock.pojo.LockAttrData;
import com.atguigu.iot.lock.pojo.LockOptionLog;
import com.atguigu.iot.lock.service.LockAttrDataService;
import com.atguigu.iot.lock.vo.IndexDataVo;
import com.atguigu.iot.lock.vo.LockOptionLogVo;
import com.atguigu.iot.web.base.BaseEntity;
import com.atguigu.iot.web.user.UserDeviceInterface;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = Exception.class)
public class LockAttrDataServiceImpl
        extends ServiceImpl<LockAttrDataMapper, LockAttrData>
        implements LockAttrDataService {

    /**
     * 记录属性信息
     *
     * @param clientid
     * @param payload
     */
    @Override
    public void saveLockAttrData(String clientid, JSONObject payload) {
        //保存本次上报的全部属性
        payload.entrySet().stream().forEach(e->{
            //查询
            remove(new LambdaQueryWrapper<LockAttrData>()
                    .eq(LockAttrData::getClientId, clientid)
                    .eq(LockAttrData::getIdentifier, e.getKey()));
            //新增
            LockAttrData lockAttrData = new LockAttrData();
            lockAttrData.setClientId(clientid);
            lockAttrData.setStatus("1");
            lockAttrData.setDataValue(e.getValue().toString());
            lockAttrData.setIdentifier(e.getKey());
            save(lockAttrData);
        });
    }

    @Autowired
    private UserDeviceInterface userDeviceInterface;

    @Autowired
    private LockOptionLogMapper lockOptionLogMapper;
    /**
     * 查询设备的属性信息
     *
     * @param clientId
     * @return
     */
    @Override
    public IndexDataVo getIndexData(String clientId) {
        //查询设备的运行状态
        String status = userDeviceInterface.getRunStatus(clientId);
        //查询属性表
        LockAttrData lockAttrData = getOne(new LambdaQueryWrapper<LockAttrData>()
                .eq(LockAttrData::getClientId, clientId)
                .eq(LockAttrData::getIdentifier, LockConstants.ATTR_ELECTRIC));
        //查询设备的最新的操作日志
        LockOptionLog lockOptionLog =
                lockOptionLogMapper.selectOne(
                        new LambdaQueryWrapper<LockOptionLog>()
                                .eq(LockOptionLog::getClientId, clientId)
                                .orderByDesc(BaseEntity::getId)
                                .last("limit 1"));
        //返回结果初始化
        return IndexDataVo.builder()
                .electric(lockAttrData.getDataValue())//电量
                .runStatus(status)//运行状态
                .lastOpenTime(lockOptionLog.getCreateTime())//上次开锁时间
                .lockUpdateTime(lockOptionLog.getCreateTime())//最后修改时间
                .build();
    }

    /**
     * 分页条件查询操作列表数据
     *
     * @param page
     * @param clientId
     * @return
     */
    @Override
    public JSONObject getLockOptionLogList(Page<LockOptionLog> page,
                                           String clientId) {
        //分页条件查询操作日志
        Page<LockOptionLog> lockOptionLogPage =
                lockOptionLogMapper.selectPage(page,
                        new LambdaQueryWrapper<LockOptionLog>()
                                .eq(LockOptionLog::getClientId, clientId)
                                .orderByDesc(BaseEntity::getCreateTime));
        //转换为vo
        List<LockOptionLogVo> lockOptionLogVoList = lockOptionLogPage.getRecords().stream().map(lockOptionLog -> {
            LockOptionLogVo lockOptionLogVo = new LockOptionLogVo();
            lockOptionLogVo.setContent(lockOptionLog.getContent());
            lockOptionLogVo.setCreateDate(new DateTime(lockOptionLog.getCreateTime()).toString("yyyy-MM-dd"));
            lockOptionLogVo.setCreateTime(new DateTime(lockOptionLog.getCreateTime()).toString("HH:mm"));
            return lockOptionLogVo;
        }).collect(Collectors.toList());
        //分桶操作: key=2024-07-05
        Map<String, List<LockOptionLogVo>> LockOptionLogVoMap =
                lockOptionLogVoList.stream().collect(Collectors.groupingBy(LockOptionLogVo::getCreateDate));
        //处理
        List<JSONObject> resultList = LockOptionLogVoMap.entrySet().stream().map(entry -> {
            JSONObject vo = new JSONObject();
            //key:日期
            String key = entry.getKey();
            vo.put("date", key);
            //value
            List<LockOptionLogVo> value = entry.getValue();
            vo.put("list", value);
            //返回
            return vo;
        }).sorted((a,b)->new DateTime(b.get("date")).compareTo(new DateTime(a.get("date"))))
                .collect(Collectors.toList());
        //返回结果初始化
        JSONObject result = new JSONObject();
        result.put("total", lockOptionLogPage.getTotal());
        result.put("records", resultList);
        return result;
    }
}
