package com.atguigu.iot.system.pojo;

import com.atguigu.iot.web.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 操作日志记录对象 sys_oper_log
 */
@Data
@Schema(description = "操作日志记录")
public class SysOperLog extends BaseEntity {
    
    private static final long serialVersionUID = 1L;

    /**
     * 模块标题
     */
    @Schema(description = "模块标题")
    private String title;

    /**
     * 方法名称
     */
    @Schema(description = "方法名称")
    private String method;

    /**
     * 请求方式
     */
    @Schema(description = "请求方式")
    private String requestMethod;

    /**
     * 操作类别（0其它 1后台用户 2手机端用户）
     */
    @Schema(description = "操作类别")
    private String operatorType;

    /**
     * 操作人员
     */
    @Schema(description = "操作人员")
    private String operName;

    /**
     * 请求URL
     */
    @Schema(description = "请求URL")
    private String operUrl;

    /**
     * 主机地址
     */
    @Schema(description = "主机地址")
    private String operIp;

    /**
     * 请求参数
     */
    @Schema(description = "请求参数")
    private String operParam;

    /**
     * 返回参数
     */
    @Schema(description = "返回参数")
    private String jsonResult;

    /**
     * 操作状态（0正常 1异常）
     */
    @Schema(description = "操作状态")
    private Integer status;

    /**
     * 错误消息
     */
    @Schema(description = "错误消息")
    private String errorMsg;

}