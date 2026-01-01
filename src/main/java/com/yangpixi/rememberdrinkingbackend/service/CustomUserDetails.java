package com.yangpixi.rememberdrinkingbackend.service;

import com.yangpixi.rememberdrinkingbackend.entity.User;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author yangpixi
 * @date 2026/1/1 11:28
 * @description 自定义用户详细，为context提供上下文数据
 */

@Data
@RequiredArgsConstructor
public class CustomUserDetails implements UserDetails, CredentialsContainer {

    private final User user;

    private final List<String> roleNames;

    private final List<String> permissionNames;

    /*
    下面虽然是从user里面获取的数据，但默认全为true
     */
    @Override
    public boolean isEnabled() {
        return user.getEnabled();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return user.getCredentialsNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.getAccountNonLocked();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.getAccountNonExpired();
    }

    /*
    加载用户名等信息
     */
    @Override
    @NonNull // 加上非空注解,防止产生警告
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public @Nullable String getPassword() {
        return user.getPassword();
    }

    @Override
    @NonNull
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        if (!roleNames.isEmpty()) {
            for (String role : roleNames) {
                authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
            }
        }

        if (!permissionNames.isEmpty()) {
            for (String permission : permissionNames) {
                authorities.add(new SimpleGrantedAuthority(permission));
            }
        }

        return authorities;
    }

    /*
    实现该方法，擦除context里用户的密码信息
     */
    @Override
    public void eraseCredentials() {
        user.setPassword(null);
    }
}
