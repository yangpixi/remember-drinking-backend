package com.yangpixi.rememberdrinkingbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangpixi.rememberdrinkingbackend.entity.User;
import com.yangpixi.rememberdrinkingbackend.mapper.UserMapper;
import com.yangpixi.rememberdrinkingbackend.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @author yangpixi
 * @date 2026/1/1 12:22
 * @description
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
}
