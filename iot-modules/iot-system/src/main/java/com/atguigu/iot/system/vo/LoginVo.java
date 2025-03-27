package com.atguigu.iot.system.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Schema(description = "登录对象")
@Data
public class LoginVo {

    @Schema(description = "用户名")
    @NotEmpty(message = "用户名不能为空")
    @Length(min = 5, max = 8, message = "用户名最小长度不能小于5,最大长度不超过8")
    private String username;

    @Schema(description = "密码")
    @NotEmpty(message = "密码不能为空")
    @Length(min = 6, max = 16, message = "密码最小长度不能小于6,最大长度不超过16")
    private String password;

    @Schema(description = "验证码图片key")
    @NotEmpty(message = "验证码图片key不能为空")
    private String codeKey ;

    @Schema(description = "输入的验证码")
    @NotEmpty(message = "验证码不能为空")
    @Length(max = 4, min = 4, message = "验证码为4位")
    private String captcha ;

}