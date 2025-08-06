package com.example.service.impl;

import com.example.commons.ResponseData;
import com.example.entity.UserInfo;
import com.example.mapper.UserInfoMapper;
import com.example.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户信息 服务实现类
 *
 * @author zengyanyu
 * @since 2025-07-30
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

    /**
     * 保存或更新用户信息
     *
     * @param userInfo 用户信息
     * @return
     */
    @Override
    public ResponseData saveOrUpdateUserInfo(UserInfo userInfo) {
        this.saveOrUpdate(userInfo);
        return new ResponseData("保存或更新成功");
    }

}
