package com.yangpixi.rememberdrinkingbackend.dto;

import lombok.Data;

import java.util.List;

/**
 * @author yangpixi
 * @date 2026/1/19 17:00
 * @description 记录上传dto类
 */

@Data
public class RecordUploadDTO {
    private List<RecordDTO> recordList;

    @Data
    public static class RecordDTO {
        private Integer amountMl;
        private String recordId;
        private Long recordTime;
        private Boolean is_deleted;
    }
}
