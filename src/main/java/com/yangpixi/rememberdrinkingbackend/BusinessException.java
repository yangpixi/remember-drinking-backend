package com.yangpixi.rememberdrinkingbackend;

import com.yangpixi.rememberdrinkingbackend.common.ErrorCode;
import lombok.Getter;

/**
 * @author yangpixi
 * @date 2026/1/1 17:28
 * @description
 */

@Getter
public class BusinessException extends RuntimeException {
    private final ErrorCode code;
    private final String msg;

    public BusinessException(ErrorCode code) {
        this.code = code;
        this.msg = code.getMessage();
    }
}
