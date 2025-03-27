package com.atguigu.iot.system.pojo;

import com.atguigu.iot.web.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 用户角色对象 sys_user_role
 */
@Data
@Schema(description = "用户角色")
public class SysUserRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 角色id
     */
    @Schema(description = "角色id")
    private Long roleId;

    /**
     * 用户id
     */
    @Schema(description = "用户id")
    private Long userId;

}