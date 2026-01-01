package com.yangpixi.rememberdrinkingbackend.controller;

import com.yangpixi.rememberdrinkingbackend.dto.ApiResponse;
import com.yangpixi.rememberdrinkingbackend.dto.LoginRequest;
import com.yangpixi.rememberdrinkingbackend.entity.User;
import com.yangpixi.rememberdrinkingbackend.service.IAuthService;
import com.yangpixi.rememberdrinkingbackend.utils.SecurityUtils;
import com.yangpixi.rememberdrinkingbackend.vo.LoginSuccessVO;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangpixi
 * @date 2026/1/1 16:59
 * @description
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final IAuthService authService;

    @PostMapping("/user/login")
    public ApiResponse<LoginSuccessVO> login(@Validated @RequestBody LoginRequest request) {
        String token = authService.login(request.getUsername(), request.getPassword()); // 登录成功返回token
        User user;
        try {
            user = SecurityUtils.getCurrentUser().orElseThrow(() -> new Exception("登录异常!"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        LoginSuccessVO successVO = new LoginSuccessVO();
        successVO.setToken(token);
        successVO.setUserId(user.getId());
        return ApiResponse.success(successVO);
    }

}
