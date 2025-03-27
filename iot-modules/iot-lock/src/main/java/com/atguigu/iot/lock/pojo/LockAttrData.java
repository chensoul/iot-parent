package com.atguigu.iot.lock.pojo;

import com.atguigu.iot.web.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "智能锁属性值表")
public class LockAttrData extends BaseEntity {
    
    private static final long serialVersionUID = 1L;

    @Schema(description = "设备clientid")
    private String clientId;

    @Schema(description = "标识符")
    private String identifier;

    @Schema(description = "属性值")
    private String dataValue;

    @Schema(description = "状态")
    private String status;
}