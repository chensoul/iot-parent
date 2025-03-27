package com.atguigu.iot.platform.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 产品信息对象 product_info
 */
@Data
@Schema(description = "产品信息")
public class ProductInfoQuery {

    /**
     * 产品名称
     */
    @Schema(description = "产品名称")
    private String name;

    /**
     * 产品key
     */
    @Schema(description = "产品key")
    private String productKey;

    @Schema(description = "页码")
    private Integer pageNum;

    @Schema(description = "每页条数")
    private Integer pageSize;

}