package com.yangpixi.rememberdrinkingbackend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.OffsetDateTime;

/**
 * @author yangpixi
 * @date 2026/1/19 16:50
 * @description 记录实体类
 */

@Data
public class Record {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @TableField("record_id")
    private String recordId;

    @TableField("user_id")
    private Long userId;

    @TableField("amount_ml")
    private Integer amountMl;

    @TableField("record_time")
    private Long recordTime;

    @TableField("is_deleted")
    private Boolean isDeleted;

    @TableField("created_at")
    private OffsetDateTime createdAt;

    @TableField("updated_at")
    private OffsetDateTime updatedAt;
}
