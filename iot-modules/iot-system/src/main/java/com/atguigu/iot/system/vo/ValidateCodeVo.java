package com.atguigu.iot.system.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "图片验证码响应结果")
@Data
public class ValidateCodeVo {

    @Schema(description = "存储在Redis中的验证码key")
    private String codeKey ;

    @Schema(description = "返回给前端的验证码字符串")
    private String codeValue ;

}