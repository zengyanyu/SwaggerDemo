package com.example.mapper;

import com.example.entity.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户信息 Mapper 接口
 *
 * @author zengyanyu
 * @since 2025-07-30
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

}
