package com.atguigu.iot.system.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 角色搜索对象
 */
@Data
@Schema(description = "角色搜索对象")
public class SysRoleQuery {

    /**
     * 角色名称
     */
    @Schema(description = "角色名称")
    private String roleName;

    /**
     * 角色编码
     */
    @Schema(description = "角色编码")
    private String roleCode;

}