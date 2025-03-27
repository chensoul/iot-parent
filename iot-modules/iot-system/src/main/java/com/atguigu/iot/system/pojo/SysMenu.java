package com.atguigu.iot.system.pojo;

import com.atguigu.iot.web.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.List;

/**
 * 菜单对象 sys_menu
 */
@Data
@Schema(description = "菜单")
public class SysMenu extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "所属上级")
    @NotEmpty(message = "所属上级不能为空!")
    private Long parentId;

    @Schema(description = "类型(1:菜单,2:按钮)")
    private Integer type;

    @Schema(description = "菜单标题")
    @NotEmpty(message = "菜单标题不能为空!")
    private String title;

    @Schema(description = "组件名称")
    private String component;

    @Schema(description = "权限标识")
    private String perms;

    @Schema(description = "排序")
    @Positive(message = "排序不能为空!")
    private Long sortValue;

    @Schema(description = "状态(0:禁止,1:正常)")
    @Positive(message = "状态不能为空!")
    private Integer status;

    // 下级列表
    @TableField(exist = false)
    private List<SysMenu> children;

    @Schema(description = "是否选中")
    @TableField(exist = false)
    private boolean isSelect;
}