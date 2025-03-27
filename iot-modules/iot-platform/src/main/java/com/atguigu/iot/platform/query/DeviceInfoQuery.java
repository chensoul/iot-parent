package com.atguigu.iot.platform.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 设备信息搜索对象
 *
 */
@Data
@Schema(description = "设备信息")
public class DeviceInfoQuery {

    @Schema(description = "产品名称")
    private String productName;

    @Schema(description = "设备名称")
    private String name;

    private Integer pageNum = 1;

    private Integer pageSize = 10;

}