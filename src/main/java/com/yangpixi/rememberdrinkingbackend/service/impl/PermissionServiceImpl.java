package com.yangpixi.rememberdrinkingbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangpixi.rememberdrinkingbackend.entity.Permission;
import com.yangpixi.rememberdrinkingbackend.mapper.PermissionMapper;
import com.yangpixi.rememberdrinkingbackend.service.IPermissionService;
import org.springframework.stereotype.Service;

/**
 * @author yangpixi
 * @date 2026/1/1 12:24
 * @description
 */

@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {
}
