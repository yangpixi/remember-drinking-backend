package com.yangpixi.rememberdrinkingbackend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.OffsetDateTime;

/**
 * @author yangpixi
 * @date 2026/1/1 10:58
 * @description
 */

@Data
public class User {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @TableField("public_id")
    private String publicId;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    @TableField("phone")
    private Long phone;

    @TableField("enabled")
    private Boolean enabled;

    @TableField("account_non_expired")
    private Boolean accountNonExpired;

    @TableField("account_nun_locked")
    private Boolean accountNonLocked;

    @TableField("credentials_non_expired")
    private Boolean credentialsNonExpired;

    @TableField("created_at")
    private OffsetDateTime createdAt;

    @TableField("updated_at")
    private OffsetDateTime updatedAt;
}
