package com.yangpixi.rememberdrinkingbackend.service;

import com.yangpixi.rememberdrinkingbackend.entity.Role;
import com.yangpixi.rememberdrinkingbackend.entity.User;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangpixi
 * @date 2026/1/1 12:01
 * @description 用户详情实现类
 */

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final IUserService userService;
    private final IRoleService roleService;
    private final IPermissionService permissionService;
    private final IUserRoleService userRoleService;
    private final IRolePermissionService rolePermissionService;

    @Override
    @NonNull
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        User user = userService.getByUsername(username);
        List<String> roleNames = getRoleNamesByUser(user);
        List<String> permissionNames = getPermissionNameByUser(user);
        return new CustomUserDetails(user, roleNames, permissionNames);
    }

    public UserDetails loadUserByUserId(String userId) {
        User user = userService.getById(userId);
        List<String> roleNames = getRoleNamesByUser(user);
        List<String> permissionNames = getPermissionNameByUser(user);
        return new CustomUserDetails(user, roleNames, permissionNames);
    }

    private List<String> getRoleNamesByUser(User user) {
        List<Long> roleIds = userRoleService.getByUserId(user.getId());
        List<Role> roleList = roleService.list();
        return roleList.stream().filter(role -> roleIds.contains(role.getId())).map(Role::getRoleName).toList();
    }

    private List<String> getPermissionNameByUser(User user) {
        List<Long> roleIds = userRoleService.getByUserId(user.getId());
        List<String> permissionNames = new ArrayList<>();
        for (Long id : roleIds) {
            List<Long> permissions = rolePermissionService.getAllByRoleId(id);
            for (Long permissionId : permissions) {
                permissionNames.add(permissionService.getById(permissionId).getPermissionName());
            }
        }
        return permissionNames;
    }

}
