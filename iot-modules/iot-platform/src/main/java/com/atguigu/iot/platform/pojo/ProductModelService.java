package com.atguigu.iot.platform.pojo;

import com.atguigu.iot.web.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 产品物模型服务对象 product_model_service
 *
 */
@Data
@Schema(description = "产品物模型服务")
public class ProductModelService extends BaseEntity {
    
    private static final long serialVersionUID = 1L;

    @Schema(description = "产品id")
    private Long productId;

    @Schema(description = "属性名称")
    private String name;

    @Schema(description = "标识符")
    private String identifier;

    @Schema(description = "调用类型【1：异步 2：同步】")
    private String callType;

    @Schema(description = "输入参数")
    private String inputParams;

    @Schema(description = "输出参数")
    private String outputParams;

    @Schema(description = "状态")
    private String status;

}