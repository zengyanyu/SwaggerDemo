package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.commons.ResponseData;
import com.example.entity.UserInfo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 用户信息 服务类
 *
 * @author zengyanyu
 * @since 2025-07-30
 */
public interface IUserInfoService extends IService<UserInfo> {

    /**
     * 保存或更新用户信息
     *
     * @param userInfo 用户信息
     * @return
     */
    ResponseData saveOrUpdateUserInfo(UserInfo userInfo);

    ResponseData<UserInfo> getUserInfoByToken(String token);

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名称，手机号码
     * @return
     */
    ResponseData<UserInfo> getUserInfoByUsername(String username);

    /**
     * 根据用户名称加载用户
     *
     * @param username 用户名称
     * @return
     */
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
