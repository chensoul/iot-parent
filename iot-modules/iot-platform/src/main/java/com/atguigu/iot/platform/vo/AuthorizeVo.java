package com.atguigu.iot.platform.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Schema(description = "设备授权VO")
@Data
@Builder
public class AuthorizeVo {

    @Schema(description = "授权结果 可选 allow deny ignore")
    private String result;
}