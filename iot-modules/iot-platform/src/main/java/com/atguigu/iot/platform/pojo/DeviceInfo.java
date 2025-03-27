package com.atguigu.iot.platform.pojo;

import com.atguigu.iot.web.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * 设备信息对象 device_info
 */
@Data
@Schema(description = "设备信息")
public class DeviceInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "产品id")
    private Long productId;

    @Schema(description = "设备名称")
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "最后连接时间")
    private Date lastConnectTime;

    @Schema(description = "设备id")
    private String clientId;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "密码")
    private String password;

    @Schema(description = "是否超级用户")
    private String isSuperuser;

    @Schema(description = "运行状态【0：否 1：是】")
    private String runStatus;

    @Schema(description = "状态")
    private String status;

    @TableField(exist = false)
    private ProductInfo productInfo;

}