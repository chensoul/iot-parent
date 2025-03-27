package com.atguigu.iot.platform.pojo;

import com.atguigu.iot.web.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 产品物模型属性对象 product_model_attr
 *
 */
@Data
@Schema(description = "产品物模型属性")
public class ProductModelAttr extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "产品id")
    private Long productId;

    @Schema(description = "功能名称")
    private String name;

    @Schema(description = "标识符")
    private String identifier;

    @Schema(description = "数据类型id")
    private Long dataTypeId;

    @Schema(description = "数据类型参数")
    private String typeParams;

    @Schema(description = "数据单位")
    private String dataUnit;

    @Schema(description = "读写状态【1：只读 2：读写】")
    private String optionStatus;

    @Schema(description = "状态")
    private String status;

}