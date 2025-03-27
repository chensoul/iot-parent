package com.atguigu.iot.user.pojo;

import com.atguigu.iot.web.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * 会员对象 user_info
 *
 */
@Data
@Schema(description = "会员")
public class UserInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "密码")
    private String password;

    @Schema(description = "昵称")
    private String nickName;

    @Schema(description = "电话号码")
    private String phone;

    @Schema(description = "头像")
    private String avatar;

    @Schema(description = "性别")
    private Integer sex;

    @Schema(description = "备注")
    private String memo;

    @Schema(description = "微信open id")
    private String openId;

    @Schema(description = "微信开放平台unionID")
    private String unionId;

    @Schema(description = "最后一次登录ip")
    private String lastLoginIp;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "最后一次登录时间")
    private Date lastLoginTime;

    @Schema(description = "状态：1为正常，0为禁止")
    private Integer status;

}