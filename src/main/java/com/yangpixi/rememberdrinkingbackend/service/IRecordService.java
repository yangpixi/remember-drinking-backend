package com.yangpixi.rememberdrinkingbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yangpixi.rememberdrinkingbackend.entity.Record;

import java.util.List;

/**
 * @author yangpixi
 * @date 2026/1/19 16:55
 * @description record对应的service接口
 */

public interface IRecordService extends IService<Record> {

    Boolean saveRecordList(List<Record> list);
}
