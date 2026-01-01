package com.yangpixi.rememberdrinkingbackend.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @author yangpixi
 * @date 2026/1/1 10:58
 * @description
 */

@Data
public class UserRole {

    @TableField(value = "user_id")
    private Long userId;

    @TableField(value = "role_id")
    private Long roleId;

}
