package com.atguigu.iot.platform.vo;

import com.atguigu.iot.platform.pojo.ProductModelAttr;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * 产品物模型属性对象 product_model_attr
 *
 */
@Data
@Schema(description = "产品物模型属性")
public class ProductModelAttrValueVo extends ProductModelAttr {

    private static final long serialVersionUID = 1L;

    @Schema(description = "设备id")
    private Long deviceId;

    @Schema(description = "属性值")
    private String dataValue;

    @Schema(description = "属性值最新创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastCreateTime;

}