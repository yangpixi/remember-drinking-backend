package com.yangpixi.rememberdrinkingbackend.controller;

import com.yangpixi.rememberdrinkingbackend.dto.ApiResponse;
import com.yangpixi.rememberdrinkingbackend.entity.User;
import com.yangpixi.rememberdrinkingbackend.service.IUserService;
import com.yangpixi.rememberdrinkingbackend.utils.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author yangpixi
 * @date 2026/1/13 21:06
 * @description 用户相关controller
 */

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @PreAuthorize("hasAuthority('record:add')")
    @PostMapping("/avatar/change")
    public ApiResponse<String> changeUserAvatar(@RequestParam("file") MultipartFile file) {
        User user = SecurityUtils.getCurrentUser().orElseThrow(() -> new RuntimeException("无法获取当前用户"));
        String filePath = "/uploads/avatar/" + userService.saveAvatar(file);
        userService.modifyUserAvatar(filePath, user.getId());
        return ApiResponse.success("更改头像成功");
    }
}
