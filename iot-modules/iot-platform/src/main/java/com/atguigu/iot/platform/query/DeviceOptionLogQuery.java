package com.atguigu.iot.platform.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "设备操作日志搜索对象")
public class DeviceOptionLogQuery {

    @Schema(description = "产品名称")
    private String productId;

    @Schema(description = "设备名称")
    private String deviceId;

    @Schema(description = "消息id")
    private String messageId;

    private Integer pageNum;

    private Integer pageSize;

}