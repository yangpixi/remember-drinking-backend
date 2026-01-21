package com.yangpixi.rememberdrinkingbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangpixi.rememberdrinkingbackend.entity.Record;
import com.yangpixi.rememberdrinkingbackend.mapper.RecordMapper;
import com.yangpixi.rememberdrinkingbackend.service.IRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yangpixi
 * @date 2026/1/19 16:56
 * @description record对应的service实现类
 */

@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements IRecordService {

    @Override
    @Transactional
    public Boolean saveRecordList(List<Record> list) {
        return this.saveBatch(list);
    }

}
