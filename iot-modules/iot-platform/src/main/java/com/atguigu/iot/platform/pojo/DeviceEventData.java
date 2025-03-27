package com.atguigu.iot.platform.pojo;

import com.atguigu.iot.web.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 设备事件数据对象 device_event_data
 *
 */
@Data
@Schema(description = "设备事件数据")
public class DeviceEventData extends BaseEntity {
    
    private static final long serialVersionUID = 1L;

    @Schema(description = "消息id")
    private String messageId;

    @Schema(description = "产品id")
    private Long productId;

    @Schema(description = "设备id")
    private Long deviceId;

    @Schema(description = "物模型事件Id")
    private Long modelEventId;

    @Schema(description = "输出参数值")
    private String outputValues;

    @Schema(description = "状态")
    private String status;
}