package com.atguigu.iot.platform.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Map;

@Schema(description = "属性设置DTO")
@Data
public class PropertyVo {

    @Schema(description = "设备ID")
    private Long deviceId;

    @Schema(description = "属性设置参数")
    private Map<String, Object> params;

    @Schema(description = "websocket页面ID")
    private String pageId;

}