package com.atguigu.iot.platform.pojo;

import com.atguigu.iot.web.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 设备服务数据对象 device_service_data
 */
@Data
@Schema(description = "设备服务数据")
public class DeviceServiceData extends BaseEntity {
    
    private static final long serialVersionUID = 1L;


    @Schema(description = "消息id")
    private String messageId;

    @Schema(description = "产品id")
    private Long productId;

    @Schema(description = "设备id")
    private Long deviceId;

    @Schema(description = "物模型事件Id")
    private Long modelServiceId;

    @Schema(description = "输入参数值")
    private String inputValues;

    @Schema(description = "输出参数值")
    private String outputValues;

    @Schema(description = "状态")
    private String status;

}