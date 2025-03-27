package com.atguigu.iot.lock.pojo;

import com.atguigu.iot.web.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "智能锁操作日志表")
public class LockOptionLog extends BaseEntity {
    
    private static final long serialVersionUID = 1L;

    @Schema(description = "设备clientid")
    private String clientId;

    @Schema(description = "日志内容")
    private String content;

    @Schema(description = "状态")
    private String status;

}