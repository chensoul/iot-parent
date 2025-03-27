package com.atguigu.iot.platform.pojo;

import com.atguigu.iot.web.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * 设备信息对象 device_info
 *
 */
@Data
@Schema(description = "设备信息")
public class DeviceConnectLog extends BaseEntity {
    
    private static final long serialVersionUID = 1L;

    @Schema(description = "产品id")
    private Long productId;

    @Schema(description = "设备id")
    private Long deviceId;

    @Schema(description = "统计维度时间，到小时")
    private Date dimensionTime;

    @Schema(description = "状态")
    private String status;
}