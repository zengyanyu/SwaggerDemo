package com.example.mapper;

import com.example.entity.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户信息 Mapper 接口
 *
 * @author zengyanyu
 * @since 2025-07-30
 */
@Mapper
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
