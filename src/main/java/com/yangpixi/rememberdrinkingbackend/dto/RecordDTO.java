package com.yangpixi.rememberdrinkingbackend.dto;

import lombok.Data;

/**
 * @author yangpixi
 * @date 2026/1/21 15:51
 * @description 喝水记录传输dto
 */

@Data
public class RecordDTO {
    private Integer amountMl;
    private String recordId;
    private Long recordTime;
    private Boolean isDeleted;
}
