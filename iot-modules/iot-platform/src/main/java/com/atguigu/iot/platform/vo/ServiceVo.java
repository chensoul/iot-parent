package com.atguigu.iot.platform.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Map;

@Schema(description = "服务调用DTO")
@Data
public class ServiceVo {

    @Schema(description = "设备ID")
    private Long deviceId;

    @Schema(description = "服务标识")
    private String identifier;

    @Schema(description = "服务调用参数")
    private Map<String, Object> params;

    @Schema(description = "页面ID")
    private String pageId;

}