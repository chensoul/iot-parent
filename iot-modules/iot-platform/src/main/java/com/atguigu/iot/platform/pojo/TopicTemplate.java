package com.atguigu.iot.platform.pojo;

import com.atguigu.iot.web.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Topic模板对象 topic_template
 */
@Data
@Schema(description = "Topic模板")
public class TopicTemplate extends BaseEntity {
    
    private static final long serialVersionUID = 1L;

    @Schema(description = "topic类型【1：基础类 2：物模型类 3：自定义】")
    private String topicType;

    @Schema(description = "topic")
    private String topic;

    @Schema(description = "功能名称")
    private String groupName;

    @Schema(description = "操作类型【1：发布 2：订阅】")
    private String optionType;

    @Schema(description = "状态")
    private String status;
}
