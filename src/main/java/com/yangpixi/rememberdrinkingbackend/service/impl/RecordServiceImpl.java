package com.yangpixi.rememberdrinkingbackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangpixi.rememberdrinkingbackend.entity.Record;
import com.yangpixi.rememberdrinkingbackend.mapper.RecordMapper;
import com.yangpixi.rememberdrinkingbackend.service.IRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
        List<String> existingIds = this.list().stream().map(Record::getRecordId).toList();

        List<Record> insertList = new ArrayList<>();
        List<Record> updateList = new ArrayList<>();

        for (Record record : list) {
            if (existingIds.contains(record.getRecordId())) {
                updateList.add(record);
            } else {
                insertList.add(record);
            }
        }

        boolean saveState = this.saveBatch(insertList);
        boolean updateState = true;

        for (Record record : updateList) {
            LambdaQueryWrapper<Record> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(Record::getRecordId, record.getRecordId());
            if (!this.update(record, wrapper)) {
                updateState = false;
            }
        }

        return saveState == updateState;
    }

}
