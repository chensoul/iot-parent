package com.atguigu.iot.system.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 用户对象
 */
@Data
@Schema(description = "用户")
public class SysUserExcelVo {

    /**
     * 用户名
     */
    @ExcelProperty(value = "用户名", index = 0)
    private String username;

    /**
     * 姓名
     */
    @ExcelProperty(value = "姓名", index = 1)
    private String name;

    /**
     * 手机
     */
    @ExcelProperty(value = "手机", index = 2)
    private String phone;
}