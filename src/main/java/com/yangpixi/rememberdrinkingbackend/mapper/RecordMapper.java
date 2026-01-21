package com.yangpixi.rememberdrinkingbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yangpixi.rememberdrinkingbackend.entity.Record;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yangpixi
 * @date 2026/1/19 16:55
 * @description record对应的mapper
 */

@Mapper
public interface RecordMapper extends BaseMapper<Record> {
}
