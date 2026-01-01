package com.yangpixi.rememberdrinkingbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangpixi.rememberdrinkingbackend.entity.Role;
import com.yangpixi.rememberdrinkingbackend.mapper.RoleMapper;
import com.yangpixi.rememberdrinkingbackend.service.IRoleService;
import org.springframework.stereotype.Service;

/**
 * @author yangpixi
 * @date 2026/1/1 12:23
 * @description
 */

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
}
