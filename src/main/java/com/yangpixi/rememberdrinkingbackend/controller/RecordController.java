package com.yangpixi.rememberdrinkingbackend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yangpixi.rememberdrinkingbackend.BusinessException;
import com.yangpixi.rememberdrinkingbackend.common.ErrorCode;
import com.yangpixi.rememberdrinkingbackend.dto.ApiResponse;
import com.yangpixi.rememberdrinkingbackend.dto.RecordDTO;
import com.yangpixi.rememberdrinkingbackend.entity.Record;
import com.yangpixi.rememberdrinkingbackend.entity.User;
import com.yangpixi.rememberdrinkingbackend.service.IRecordService;
import com.yangpixi.rememberdrinkingbackend.utils.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
    public ApiResponse<String> saveRecords(@RequestBody List<RecordDTO> request) {
        User user = SecurityUtils.getCurrentUser().orElseThrow(() -> new RuntimeException("获取用户失败"));
        List<Record> recordList = request.stream().map(recordDTO -> {
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

    @GetMapping
    @PreAuthorize("hasAuthority('record:add')")
    public ApiResponse<List<RecordDTO>> getRecords() {
        User user = SecurityUtils.getCurrentUser().orElseThrow(() -> new RuntimeException("获取用户失败"));

        QueryWrapper<Record> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", user.getId());
        List<RecordDTO> list = recordService.list(queryWrapper).stream().map(record -> {
            RecordDTO recordDTO = new RecordDTO(); // 此处复用DTO类，不在单独使用VO类
            BeanUtils.copyProperties(record, recordDTO);
            return recordDTO;
        }).toList();

        return ApiResponse.success(list);
    }

}
