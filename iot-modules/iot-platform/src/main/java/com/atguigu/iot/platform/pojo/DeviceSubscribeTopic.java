package com.atguigu.iot.platform.pojo;

import com.atguigu.iot.web.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 设备订阅的topic对象 device_subscribe_topic
 *
 */
@Data
@Schema(description = "设备订阅的topic")
public class DeviceSubscribeTopic extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "产品id")
    private Long productId;

    @Schema(description = "设备id")
    private Long deviceId;

    @Schema(description = "商品topic的id")
    private Long topicId;

    @Schema(description = "产品topic模板")
    private String topicTemplate;

    @Schema(description = "设备订阅的topic")
    private String topic;

    @Schema(description = "状态")
    private String status;

}