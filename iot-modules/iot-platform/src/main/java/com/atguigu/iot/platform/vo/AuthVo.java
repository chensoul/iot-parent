package com.atguigu.iot.platform.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Schema(description = "设备认证VO")
@Data
@Builder
public class AuthVo {

    @Schema(description = "认证结果 可选 allow deny ignore")
    private String result;

    @Schema(description = "超级用户 可选 true false。")
    private Boolean is_superuser = false;
}