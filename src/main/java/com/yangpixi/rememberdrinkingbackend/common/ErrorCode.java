package com.yangpixi.rememberdrinkingbackend.common;

import lombok.Getter;

/**
 * @author yangpixi
 * @date 2026/1/1 17:30
 * @description 少年负壮气，奋烈自有时！
 */

@Getter
public enum ErrorCode {
    PARAMS_ERROR(400, "参数错误"),
    NOT_LOGIN(401, "未登录或登录已过期"),
    UNAUTHORIZED(403, "你没有访问该资源的权限"),
    NOT_FOUND(404, "请求的资源不存在"),
    METHOD_NOT_ALLOWED(405, "请求方法不支持"),
    SERVER_ERROR(500, "服务器内部错误"),
    OPERATION_ERROR(501, "操作失败"),
    HAD_EXIST(420, "用户名已被使用");


    private final int code;
    private final String msg;

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMessage() {
        return msg;
    }

}
