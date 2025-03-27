package com.atguigu.iot.system.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 操作日志搜索对象 
 *
 */
@Data
@Schema(description = "操作日志搜索对象")
public class SysLoginLogVo {

    @Schema(description = "操作人员")
    private String username;

    @Schema(description = "开始时间")
    private String beginTime;

    @Schema(description = "结束时间")
    private String endTime;

    @Schema(description = "页码")
    private Integer pageNum;

    @Schema(description = "每页数据量")
    private Integer pageSize;

}