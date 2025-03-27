package com.atguigu.iot.platform.pojo;

import com.atguigu.iot.web.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * 设备操作日志记录对象 device_option_log
 *
 */
@Data
@Schema(description = "设备操作日志记录表")
public class DeviceOptionLog extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Schema(description = "产品id")
    private Long productId;

    @Schema(description = "设备id")
    private Long deviceId;

    @Schema(description = "消息id")
    private String messageId;

    @Schema(description = "操作类型【1：属性 2：事件 3：服务】")
    private String optionType;

    @Schema(description = "topic")
    private String topic;

    @Schema(description = "返回码")
    private String responseCode;

    @Schema(description = "请求参数")
    private String requestParams;

    @Schema(description = "响应数据")
    private String responseData;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "请求时间")
    private Date requestTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "响应时间")
    private Date responseTime;

    @Schema(description = "是否完成")
    private String isFinish;

    @Schema(description = "状态")
    private String status;

    @Schema(description = "统计维度时间，到小时")
    private Date dimensionTime;

    @Schema(description = "设备名称")
    @TableField(exist = false)
    private String deviceName;

    @Schema(description = "产品名称")
    @TableField(exist = false)
    private String productName;
}