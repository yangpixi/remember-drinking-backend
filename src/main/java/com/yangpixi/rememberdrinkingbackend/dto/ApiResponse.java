package com.yangpixi.rememberdrinkingbackend.dto;

import lombok.Data;

/**
 * @author yangpixi
 * @date 2025/12/31 15:05
 * @description 统一相应
 */

@Data
public class ApiResponse <T> {
    private Integer code;
    private String msg;
    private T data;
}
