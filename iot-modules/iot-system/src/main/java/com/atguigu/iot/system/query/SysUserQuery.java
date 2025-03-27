package com.atguigu.iot.system.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 用户搜索对象
 */
@Data
@Schema(description = "用户")
public class SysUserQuery {

    @Schema(description = "关键字")
    private String keyword;

    @Schema(description = "开始时间")
    private String beginTime;

    @Schema(description = "结束时间")
    private String endTime;
}
