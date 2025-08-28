package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Permission;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.cache.decorators.FifoCache;

/**
 * 权限 Mapper 接口
 *
 * @author zengyanyu
 * @since 2025-08-12
 */
@Mapper
@CacheNamespace(flushInterval = 60000, size = 512, eviction = FifoCache.class)
public interface PermissionMapper extends BaseMapper<Permission> {

}
