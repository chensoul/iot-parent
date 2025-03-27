package com.atguigu.iot.system.pojo;

import com.atguigu.iot.web.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 角色菜单对象 sys_role_menu
 */
@Data
@Schema(description = "角色菜单")
public class SysRoleMenu extends BaseEntity {
    
    private static final long serialVersionUID = 1L;

    /**
     * 角色id
     */
    @Schema(description = "角色id")
    private Long roleId;

    /**
     * 菜单id
     */
    @Schema(description = "菜单id")
    private Long menuId;

}
