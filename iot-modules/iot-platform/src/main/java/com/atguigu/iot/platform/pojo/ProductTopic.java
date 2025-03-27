package com.atguigu.iot.platform.pojo;

import com.atguigu.iot.web.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 产品Topic对象 product_topic
 *
 */
@Data
@Schema(description = "产品Topic")
public class ProductTopic extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "产品Id")
    private Long productId;

    @Schema(description = "topic类型【1：基础类 2：物模型类 3：自定义】")
    private String topicType;

    @Schema(description = "topic")
    private String topic;

    @Schema(description = "功能名称")
    private String groupName;

    @Schema(description = "操作类型【1：发布 2：订阅】")
    private String optionType;

    @Schema(description = "产品状态")
    private String status;

}