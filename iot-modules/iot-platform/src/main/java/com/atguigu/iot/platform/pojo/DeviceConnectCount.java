package com.atguigu.iot.platform.pojo;

import com.atguigu.iot.web.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * 设备连接统计 device_connect_count
 *
 */
@Data
@Schema(description = "设备连接统计")
public class DeviceConnectCount extends BaseEntity {
    
    private static final long serialVersionUID = 1L;

    @Schema(description = "统计维度时间，到小时")
    private Date dimensionTime;

    @Schema(description = "统计个数")
    private Integer num;
}