package com.yangpixi.rememberdrinkingbackend.common;

import com.yangpixi.rememberdrinkingbackend.BusinessException;
import com.yangpixi.rememberdrinkingbackend.dto.ApiResponse;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author yangpixi
 * @date 2025/12/31 15:06
 * @description 全局异常处理器
 */

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 处理缺少请求参数异常
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ApiResponse<Object>> handleMissingServletRequestParameterException(Exception ex) {
        String errorMessage = "缺少请求参数：" + ex.getMessage();
        ApiResponse<Object> apiResponse = ApiResponse.error(400, errorMessage);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    /**
     * 处理参数校验异常（注释声明即可）
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiResponse<Object>> handleConstraintViolationException(ConstraintViolationException ex) {
        String errorMessage = ex.getMessage();
        ApiResponse<Object> apiResponse = ApiResponse.error(400, errorMessage);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    /**
     * 处理参数校验异常（注释声明即可）
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Object>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        ApiResponse<Object> apiResponse = ApiResponse.error(400, "参数传递有误或者缺少参数");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    /**
     * 处理业务逻辑异常（注释声明即可）
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiResponse<Object>> handleBusinessException(BusinessException ex) {
        String errorMessage = ex.getMessage();
        ApiResponse<Object> apiResponse = ApiResponse.error(ex.getCode().getCode(), errorMessage);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    /**
     * 处理其他异常（注释声明即可）
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleException(Exception ex) {
        String errorMessage = ex.getMessage();
        log.error("系统异常: {}", errorMessage, ex);  // 使用日志框架记录异常，包含完整堆栈
        ApiResponse<Object> apiResponse = ApiResponse.error(500, "服务器发生内部错误，您可以尝试刷新，如果问题依旧，请联系我们");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    /**
     * 处理请求方法异常
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ApiResponse<Object>> handleHttpRequestMethodNotSupportedException(Exception ex) {
        ApiResponse<Object> apiResponse = ApiResponse.error(405, "请求方法错误，请检查");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
