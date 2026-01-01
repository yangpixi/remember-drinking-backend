package com.yangpixi.rememberdrinkingbackend.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yangpixi.rememberdrinkingbackend.dto.ApiResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author yangpixi
 * @date 2026/1/1 15:56
 * @description
 */

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setHeader("Content-Type", "application/json");
        response.setStatus(200);
        response.setCharacterEncoding("UTF-8");

        // 设置返回数据
        ApiResponse<Object> result = ApiResponse.error(403, "用户权限不足，无法访问此资源");

        // 使用jackson将消息序列化
        String json = objectMapper.writeValueAsString(result);
        response.getWriter().write(json);
    }
}
