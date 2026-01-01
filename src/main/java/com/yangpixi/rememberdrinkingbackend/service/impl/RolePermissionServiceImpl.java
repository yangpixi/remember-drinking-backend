package com.yangpixi.rememberdrinkingbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangpixi.rememberdrinkingbackend.entity.RolePermission;
import com.yangpixi.rememberdrinkingbackend.mapper.RolePermissionMapper;
import com.yangpixi.rememberdrinkingbackend.service.IRolePermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangpixi
 * @date 2026/1/1 12:25
 * @description
 */

@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements IRolePermissionService {
    @Override
    public List<Long> getAllByRoleId(Long roleId) {
        return this.baseMapper.selectAllByRoleId(roleId);
    }
}
