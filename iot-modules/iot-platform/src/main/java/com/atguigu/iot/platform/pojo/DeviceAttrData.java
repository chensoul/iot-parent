package com.atguigu.iot.platform.pojo;

import com.atguigu.iot.web.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 设备属性数据对象 device_atrr_data
 *
 */
@Data
@Schema(description = "设备属性数据")
@TableName(value = "device_attr_data")
public class DeviceAttrData extends BaseEntity {
    
    private static final long serialVersionUID = 1L;

    @Schema(description = "消息id")
    private String messageId;

    @Schema(description = "产品id")
    private Long productId;

    @Schema(description = "设备id")
    private Long deviceId;

    @Schema(description = "物模型属性Id")
    private Long modelAttrId;

    @Schema(description = "数据类型id")
    private Long dataTypeId;

    @Schema(description = "属性值")
    private String dataValue;

    @Schema(description = "状态")
    private String status;
}