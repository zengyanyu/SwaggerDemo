package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.LogRecordEntity;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.cache.decorators.FifoCache;

/**
 * 日志记录 Mapper 接口
 *
 * @author zengyanyu
 * @since 2025-07-30
 */
@Mapper
@CacheNamespace(flushInterval = 60000, size = 512, eviction = FifoCache.class)
public interface LogRecordMapper extends BaseMapper<LogRecordEntity> {

}
