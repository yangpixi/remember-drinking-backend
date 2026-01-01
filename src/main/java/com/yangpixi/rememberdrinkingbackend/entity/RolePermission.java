package com.yangpixi.rememberdrinkingbackend.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @author yangpixi
 * @date 2026/1/1 10:58
 * @description
 */

@Data
public class RolePermission {

    @TableField("role_id")
    private Long roleId;

    @TableField("permission_id")
    private Long permissionId;

}
