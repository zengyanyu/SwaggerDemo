package com.example.service;

import com.example.commons.ResponseData;
import com.example.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;

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

}
