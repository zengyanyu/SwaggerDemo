package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.commons.ResponseData;
import com.example.entity.UserInfo;
import com.example.mapper.UserInfoMapper;
import com.example.service.IUserInfoService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 用户信息 服务实现类
 *
 * @author zengyanyu
 * @since 2025-07-30
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService, UserDetailsService {

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

    @Override
    public ResponseData<UserInfo> getUserInfoByToken(String token) {
        UserInfo userInfo = this.baseMapper.userInfo(token);
        return new ResponseData("根据token获取用户信息成功", userInfo);
    }

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名称，手机号码
     * @return
     */
    @Override
    public ResponseData<UserInfo> getUserInfoByUsername(String username) {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        UserInfo userInfo = this.getOne(wrapper);
        if (null != userInfo) {
            return new ResponseData("根据用户名查询用户信息成功", userInfo);
        }
        return new ResponseData(ResponseData.SUCCEED, "暂未查询到数据", null);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = this.getUserInfoByUsername(username).getData();
        if (null != userInfo) {
            return new User(username, userInfo.getToken(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

}
