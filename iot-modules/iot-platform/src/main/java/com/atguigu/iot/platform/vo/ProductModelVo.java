package com.atguigu.iot.platform.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 产品物模型对象 
 */
@Data
@Schema(description = "产品物模型属性")
public class ProductModelVo {

    @Schema(description = "id")
    private Long id;

    @Schema(description = "功能类型")
    private Integer modelType;

    @Schema(description = "产品id")
    private Long productId;

    //@Excel(name = "功能名称")
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

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "状态")
    private String callType;
    @Schema(description = "输入参数")
    private String inputParams;
    @Schema(description = "输出参数")
    private String outputParams;

    @Schema(description = "事件类型")
    private String eventType;

}