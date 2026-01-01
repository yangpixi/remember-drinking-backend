package com.yangpixi.rememberdrinkingbackend.vo;

import lombok.Data;
import tools.jackson.databind.annotation.JsonSerialize;
import tools.jackson.databind.ser.std.ToStringSerializer;

/**
 * @author yangpixi
 * @date 2026/1/1 17:01
 * @description 登录成功返回
 */

@Data
public class LoginSuccessVO {
    // 将Long型转换成String，防止前端精度不够
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;

    private String token;
}
