package com.yangpixi.rememberdrinkingbackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * @author yangpixi
 * @date 2026/1/2 21:38
 * @description 注册请求
 */

@Data
public class RegisterRequest {

    @NotBlank(message = "用户名不能为空")
    @Size(min = 4, max = 20, message = "用户名长度必须在4-20个字符之间")
    private String username;

    @NotBlank()
    @Size(min = 10, max = 20, message = "密码长度必须在10-20个字符之间")
    private String password;

    @NotBlank
    @Pattern(regexp = "^1[0-9]\\d{9}$", message = "请输入正确的手机号")
    private String phone;
}
