package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Department;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.cache.decorators.FifoCache;

/**
 * 部门管理 Mapper 接口
 *
 * @author zengyanyu
 * @since 2025-07-30
 */
@Mapper
@CacheNamespace(flushInterval = 60000, size = 512, eviction = FifoCache.class)
public interface DepartmentMapper extends BaseMapper<Department> {

}
