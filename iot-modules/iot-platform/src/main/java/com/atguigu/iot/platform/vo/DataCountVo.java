package com.atguigu.iot.platform.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Schema(description = "统计维度数据")
@Data
@Builder
public class DataCountVo {

    private Date dimensionTime;

    private Integer num;
}