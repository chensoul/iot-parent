package com.atguigu.iot.platform.pojo;

import com.atguigu.iot.web.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 产品物模型事件对象 product_model_event
 *
 */
@Data
@Schema(description = "产品物模型事件")
public class ProductModelEvent extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "产品id")
    private Long productId;

    @Schema(description = "属性名称")
    private String name;

    @Schema(description = "标识符")
    private String identifier;

    @Schema(description = "事件类型【1：信息 2：告警 3：故障】")
    private String eventType;

    @Schema(description = "输出参数")
    private String outputParams;

    @Schema(description = "状态")
    private String status;

}