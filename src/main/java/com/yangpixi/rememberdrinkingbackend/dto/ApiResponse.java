package com.yangpixi.rememberdrinkingbackend.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yangpixi
 * @date 2025/12/31 15:05
 * @description 统一相应
 */

@Data
public class ApiResponse <T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    // 带上数据的成功返回
    public static <T> ApiResponse<T> success(T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setCode(0);
        response.setData(data);
        return response;
    }

    // 不带数据的成功返回
    public static <T> ApiResponse<T> success() {
        return success(null);
    }

    public static <T> ApiResponse<T> error(Integer code, String msg) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }
}
