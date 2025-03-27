package com.atguigu.iot.system.pojo;

import com.atguigu.iot.web.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * 用户对象 sys_user
 */
@Data
@Schema(description = "用户")
public class SysUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    @Schema(description = "用户名")
    @NotEmpty(message = "用户名不能为空!")
    private String username;

    /**
     * 密码
     */
    @Schema(description = "密码")
    @NotEmpty(message = "密码不能为空!")
    private String password;

    /**
     * 姓名
     */
    @Schema(description = "姓名")
    @NotEmpty(message = "姓名不能为空!")
    private String name;

    /**
     * 手机
     */
    @Schema(description = "手机")
    @NotEmpty(message = "手机不能为空!")
    private String phone;

    /**
     * 头像
     */
    @Schema(description = "头像")
    private String avatar;

    /**
     * 描述
     */
    @Schema(description = "描述")
    private String description;

    /**
     * 状态（1：正常 0：停用）
     */
    @Schema(description = "状态")
    private Integer status;

}