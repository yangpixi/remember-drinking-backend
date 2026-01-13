package com.yangpixi.rememberdrinkingbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangpixi.rememberdrinkingbackend.BusinessException;
import com.yangpixi.rememberdrinkingbackend.common.ErrorCode;
import com.yangpixi.rememberdrinkingbackend.entity.User;
import com.yangpixi.rememberdrinkingbackend.mapper.UserMapper;
import com.yangpixi.rememberdrinkingbackend.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * @author yangpixi
 * @date 2026/1/1 12:22
 * @description
 */

@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public User getByUsername(String username) {
        return this.baseMapper.selectByUsername(username);
    }

    @Override
    public String saveAvatar(MultipartFile file) {
        if (file.isEmpty()) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String originalFileName = file.getOriginalFilename();
        String fileExtension = StringUtils.getFilenameExtension(originalFileName);
        UUID uuid = UUID.randomUUID();
        String safeFileName = uuid + "." + fileExtension;

        Path dirPath = Paths.get("./uploads/avatar/"); // 文件保存文件夹

        try {

            // 防止文件夹不存在
            if (!Files.exists(dirPath)) {
                Files.createDirectories(dirPath);
            }

            Path filePath = dirPath.resolve(safeFileName);

            file.transferTo(filePath);
            return safeFileName; // 返回新文件名
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void modifyUserAvatar(String avatarPath, Long userId) {
        Integer rows = this.baseMapper.updateAvatarById(avatarPath, userId);
        if (rows == 0) {
            log.warn("更改用户头像失败");
            throw new RuntimeException("无此用户");
        }
        log.info("用户: {}, 更换了头像", userId);
    }
}
