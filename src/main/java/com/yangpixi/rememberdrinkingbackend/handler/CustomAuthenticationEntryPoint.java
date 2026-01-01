package com.yangpixi.rememberdrinkingbackend.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yangpixi.rememberdrinkingbackend.dto.ApiResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author yangpixi
 * @date 2026/1/1 15:32
 * @description 自定义用户未登录处理
 */

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setStatus(200);
        ApiResponse<Object> result = ApiResponse.error(401, "用户未认证或登录已过期，请重新登录后再访问");
        String json = objectMapper.writeValueAsString(result);
        response.getWriter().write(json);
    }
}
