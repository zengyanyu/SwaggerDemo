package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.LogRecordEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 日志记录 Mapper 接口
 *
 * @author zengyanyu
 * @since 2024-11-20
 */
@Mapper
public interface LogRecordMapper extends BaseMapper<LogRecordEntity> {

}
