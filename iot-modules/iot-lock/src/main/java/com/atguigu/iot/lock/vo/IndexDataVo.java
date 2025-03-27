package com.atguigu.iot.lock.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Schema(description = "首页数据")
@Data
@Builder
public class IndexDataVo {

    @Schema(description = "剩余电量")
    private String electric;

    @Schema(description = "上次开锁时间")
    private Date lastOpenTime;

    @Schema(description = "运行状态")
    private String runStatus;

    @Schema(description = "门锁最近更新时间")
    private Date lockUpdateTime;
}