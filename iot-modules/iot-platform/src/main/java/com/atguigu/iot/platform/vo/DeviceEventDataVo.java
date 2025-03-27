package com.atguigu.iot.platform.vo;

import com.atguigu.iot.platform.pojo.DeviceEventData;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 设备物模型事件对象
 *
 */
@Data
@Schema(description = "设备物模型事件")
public class DeviceEventDataVo extends DeviceEventData {

    private static final long serialVersionUID = 1L;

    @Schema(description = "属性名称")
    @TableField(exist = false)
    private String name;

    @Schema(description = "标识符")
    @TableField(exist = false)
    private String identifier;

    @Schema(description = "事件类型【1：信息 2：告警 3：故障】")
    @TableField(exist = false)
    private String eventType;
}