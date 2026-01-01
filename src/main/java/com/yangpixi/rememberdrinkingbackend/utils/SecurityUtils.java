package com.yangpixi.rememberdrinkingbackend.utils;

import com.yangpixi.rememberdrinkingbackend.entity.User;
import com.yangpixi.rememberdrinkingbackend.service.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

/**
 * @author yangpixi
 * @date 2026/1/1 17:04
 * @description 工具类
 */

public class SecurityUtils {

    public static Optional<User> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof CustomUserDetails principal) {
            return Optional.ofNullable(principal.getUser()); // 使用Optional包装类，解决NPE问题
        }
        return Optional.empty();
    }
}
