package com.yangpixi.rememberdrinkingbackend.controller;

import com.yangpixi.rememberdrinkingbackend.BusinessException;
import com.yangpixi.rememberdrinkingbackend.common.ErrorCode;
import com.yangpixi.rememberdrinkingbackend.dto.ApiResponse;
import com.yangpixi.rememberdrinkingbackend.dto.RecordUploadDTO;
import com.yangpixi.rememberdrinkingbackend.entity.Record;
import com.yangpixi.rememberdrinkingbackend.entity.User;
import com.yangpixi.rememberdrinkingbackend.service.IRecordService;
import com.yangpixi.rememberdrinkingbackend.utils.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yangpixi
 * @date 2026/1/20 10:49
 * @description 记录controller
 */

@RestController
@RequestMapping("/record")
@RequiredArgsConstructor
public class RecordController {
    private final IRecordService recordService;

    @PostMapping("/upload")
    @PreAuthorize("hasAuthority('record:add')")
    public ApiResponse<String> saveRecords(@RequestBody RecordUploadDTO request) {
        User user = SecurityUtils.getCurrentUser().orElseThrow(() -> new RuntimeException("获取用户失败"));
        List<Record> recordList = request.getRecordList().stream().map(recordDTO -> {
            Record record = new Record();
            BeanUtils.copyProperties(recordDTO, record);
            record.setUserId(user.getId());
            return record;
        }).toList();
        Boolean res = recordService.saveRecordList(recordList);
        if (!res) {
            throw new BusinessException(ErrorCode.SERVER_ERROR);
        }
        return ApiResponse.success("存储记录成功");
    }
}
