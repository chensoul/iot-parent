package com.atguigu.iot.user.pojo;


import com.atguigu.iot.web.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * 会员设备对象 user_device
 */
@Data
@Schema(description = "会员设备")
public class UserDevice extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Schema(description = "用户id")
    private Long userId;

    @Schema(description = "设备类型")
    private String deviceType;

    @Schema(description = "设备clientid")
    private String clientId;

    @Schema(description = "图标url")
    private String iconUrl;

    @Schema(description = "设备名称")
    private String name;

    @Schema(description = "运行状态【0：否 1：是】")
    private String runStatus;

    @Schema(description = "摆放位置")
    private String position;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "最后连接时间")
    private Date lastConnectTime;

    @Schema(description = "状态：1为正常，0为禁止")
    private Integer status;

}