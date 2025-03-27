package com.atguigu.iot.platform.handler;

import cn.hutool.core.util.ReUtil;
import com.alibaba.fastjson2.JSONObject;
import com.atguigu.iot.common.constant.GuiguEmqxConstants;
import com.atguigu.iot.platform.emqx.GuiguEmqx;
import com.atguigu.iot.platform.mapper.DeviceInfoMapper;
import com.atguigu.iot.platform.mapper.ProductInfoMapper;
import com.atguigu.iot.platform.pojo.DeviceInfo;
import com.atguigu.iot.platform.pojo.ProductInfo;
import com.atguigu.iot.platform.service.CommontProductEventService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

/***
 * 和app端进行消息互通的实现类
 */
@Service
@GuiguEmqx(event = GuiguEmqxConstants.EVENT_PUBLISH)
public class EventPublishHandler implements MessageHandler {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Autowired
    private DeviceInfoMapper deviceInfoMapper;

    @Autowired
    private CommontProductEventService commontProductEventService;

    /**
     * 具体事先和消息的处理方法逻辑
     *
     * @param message
     */
    @Override
    public void handleMessage(JSONObject message) {
        //只处理当前handle的
        if(message.get("event").toString().equals("message.dropped")){
            return;
        }
        //判断
        if(message.get("topic") == null){
            //设备的客户端id
            String clientid = message.get("clientid").toString();
            //查询设备的信息
            DeviceInfo deviceInfo =
                    deviceInfoMapper.selectOne(
                            new LambdaQueryWrapper<DeviceInfo>()
                                    .eq(DeviceInfo::getClientId, clientid)
                                    .eq(DeviceInfo::getStatus, "1")
                                    .last("limit 1"));
            //获取产品的信息
            ProductInfo productInfo =
                    productInfoMapper.selectById(deviceInfo.getProductId());
            //系统事件: SYS-系统事件
            rabbitTemplate.convertAndSend("sys_event_iot_exchange", "sys", message.toJSONString());
        }else{
            //获取topic
            String topic = message.get("topic").toString();
            //解析
            String[] split = topic.split("/");
            //判断是否为事件上报
            String format =
                    MessageFormat.format(GuiguEmqxConstants.TOPIC_EVENT_POST, "[A-Za-z0-9]+", "[A-Za-z0-9]+", "[A-Za-z0-9]+");
            if(ReUtil.isMatch(format, topic)){
                JSONObject payload = JSONObject.parseObject(message.get("payload").toString());
                String name = commontProductEventService.getProductModelEventInfo(split[1], split[4], payload);
                message.put("iotEventName", name);
            }
            //平台消息-IOT平台消息
            rabbitTemplate.convertAndSend("sys_event_iot_exchange", "iot", message.toJSONString());
        }
    }
}
