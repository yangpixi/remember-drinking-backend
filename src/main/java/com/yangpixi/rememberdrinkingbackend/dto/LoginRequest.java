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
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
