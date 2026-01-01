package com.yangpixi.rememberdrinkingbackend.service.impl;

import com.yangpixi.rememberdrinkingbackend.entity.User;
import com.yangpixi.rememberdrinkingbackend.service.CustomUserDetails;
import com.yangpixi.rememberdrinkingbackend.service.IAuthService;
import com.yangpixi.rememberdrinkingbackend.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * @author yangpixi
 * @date 2026/1/1 16:42
 * @description 登录服务实现类
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Override
    public String login(String username, String password) {

        // 创建空的认证token对象
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        log.info(username);
        log.info(password);
        User user = new User();
        try {
            // 认证
            Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            if (authentication.isAuthenticated()) {
                CustomUserDetails principal = (CustomUserDetails) authentication.getPrincipal();
                // 如果登录成功，必然可以拿到用户，不会产生空指针，但为了防止特殊情况，仍然catch NPE
                user = principal.getUser();

                // 设置authentication
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (AuthenticationException | NullPointerException e) {
            log.warn("用户名或密码错误");
            throw new RuntimeException("用户名或密码错误");
        }

        return jwtUtil.generateToken(user.getId().toString());
    }
}
