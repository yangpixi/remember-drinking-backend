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
}
