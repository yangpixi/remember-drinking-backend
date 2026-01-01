package com.yangpixi.rememberdrinkingbackend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author yangpixi
 * @date 2026/1/1 10:58
 * @description
 */

@Data
public class Permission {

    @TableId(value = "id",  type = IdType.ASSIGN_ID)
    private Long id;

    @TableField("permission_name")
    private String permissionName;

}
