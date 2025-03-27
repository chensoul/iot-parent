package com.atguigu.iot.lock.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "智能锁操作日志表")
public class LockOptionLogVo {

    @Schema(description = "创建日期")
    private String createDate;

    @Schema(description = "创建时间")
    private String createTime;

    @Schema(description = "日志内容")
    private String content;

}