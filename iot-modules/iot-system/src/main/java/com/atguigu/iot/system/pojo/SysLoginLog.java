package com.atguigu.iot.system.pojo;

import com.atguigu.iot.web.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * 系统用户登录记录对象 sys_login_log
 *
 */
@Data
@Schema(description = "系统用户登录记录")
public class SysLoginLog extends BaseEntity {
    
    private static final long serialVersionUID = 1L;

    /**
     * 用户账号
     */
    @Schema(description = "用户账号")
    private String username;

    /**
     * 登录IP地址
     */
    @Schema(description = "登录IP地址")
    private String ipaddr;

    /**
     * 登录状态（0成功 1失败）
     */
    @Schema(description = "登录状态")
    private Integer status;

    /**
     * 提示信息
     */
    @Schema(description = "提示信息")
    private String msg;

    /**
     * 访问时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "访问时间")
    private Date accessTime;

}