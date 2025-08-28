package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.UserInfo;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.cache.decorators.FifoCache;

/**
 * 用户信息 Mapper 接口
 *
 * @author zengyanyu
 * @since 2025-07-30
 */
@Mapper
@CacheNamespace(flushInterval = 60000, size = 512, eviction = FifoCache.class)
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    /**
     * @param username
     * @return
     */
    UserInfo getUserInfo(@Param("username") String username);

    /**
     * @param token
     * @return
     */
    UserInfo userInfo(@Param("token") String token);

}
