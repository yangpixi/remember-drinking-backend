package com.yangpixi.rememberdrinkingbackend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


/**
 * @author yangpixi
 * @date 2026/1/1 17:09
 * @description 登录请求dto类
 */

@Data
public class LoginRequest {

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;
}
