package com.yangpixi.rememberdrinkingbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yangpixi.rememberdrinkingbackend.entity.User;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author yangpixi
 * @date 2026/1/1 12:20
 * @description
 */

public interface IUserService extends IService<User> {
    User getByUsername(String username);

    String saveAvatar(MultipartFile file);

    void modifyUserAvatar(String avatarPath, Long userId);
}
