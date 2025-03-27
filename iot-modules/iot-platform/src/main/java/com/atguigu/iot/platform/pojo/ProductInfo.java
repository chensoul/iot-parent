package com.atguigu.iot.platform.pojo;

import com.atguigu.iot.web.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * 产品信息对象 product_info
 */
@Data
@Schema(description = "产品信息")
public class ProductInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 产品名称
     */
    @Schema(description = "产品名称")
    @NotEmpty(message = "产品名称不能为空")
    private String name;

    /**
     * 产品key
     */
    @Schema(description = "产品key")
    private String productKey;

    /**
     * 节点类型
     */
    @Schema(description = "节点类型")
    @NotEmpty(message = "节点类型不能为空")
    private String nodeType;

    /**
     * 产品状态（1正常 0停用）
     */
    @Schema(description = "产品状态")
    private String status;

    @Schema(description = "设备数量")
    @TableField(exist = false)
    private Long deviceNum;

}