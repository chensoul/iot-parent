package com.atguigu.iot.platform.vo;


import com.atguigu.iot.platform.pojo.DeviceServiceData;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 产品物模型服务对象 
 *
 */
@Data
@Schema(description = "产品物模型服务")
public class DeviceServiceDataVo extends DeviceServiceData {
    
    private static final long serialVersionUID = 1L;

    @Schema(description = "属性名称")
    @TableField(exist = false)
    private String name;

    @Schema(description = "标识符")
    @TableField(exist = false)
    private String identifier;

    @Schema(description = "调用类型【1：异步 2：同步】")
    @TableField(exist = false)
    private String callType;

}