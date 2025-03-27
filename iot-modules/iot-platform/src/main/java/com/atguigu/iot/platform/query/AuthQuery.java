package com.atguigu.iot.platform.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "设备认证DTO")
@Data
public class AuthQuery {

    @Schema(description = "设备客户端的 ID")
    private String clientid;

    @Schema(description = "客户端登录的用户名")
    private String username;

    @Schema(description = "客户端登录的密码")
    private String password;
}