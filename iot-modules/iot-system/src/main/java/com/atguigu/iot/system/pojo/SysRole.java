package com.atguigu.iot.system.pojo;

import com.atguigu.iot.web.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/***
 * 角色对象 sys_role
 */
@Data
@Schema(description = "角色")
public class SysRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 角色名称
     */
    @Schema(description = "角色名称")
    @NotEmpty(message = "角色名称不能为空!")
    private String roleName;

    /**
     * 角色编码
     */
    @Schema(description = "角色编码")
    @NotEmpty(message = "角色编码不能为空!")
    private String roleCode;

    /**
     * 描述
     */
    @Schema(description = "描述")
    private String description;

}