package com.atguigu.iot.system.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "菜单路由响应结果")
@Data
public class SysMenuVo {

    @Schema(description = "菜单标题")
    private String title;

    @Schema(description = "组件名称")
    private String name;

    @Schema(description = "下级列表")
    private List<SysMenuVo> children;

}