package com.atguigu.iot.platform.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "设备授权DTO")
@Data
public class AuthorizeQuery {

    @Schema(description = "客户端的 ID")
    private String clientid;

    @Schema(description = "客户端登录时用的用户名")
    private String username;

    @Schema(description = "客户端的源 IP 地址")
    private String peerhost;

    @Schema(description = "网关监听器的挂载点（主题前缀）")
    private String mountpoint;

    @Schema(description = "当前请求想要发布或订阅的主题（或主题过滤器）")
    private String topic;

    @Schema(description = "当前执行的动作请求，例如 publish，subscribe")
    private String action;
}