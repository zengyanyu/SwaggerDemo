package com.example.service.impl;

import com.example.commons.ResponseData;
import com.example.entity.UserRole;
import com.example.mapper.UserRoleMapper;
import com.example.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户关联的角色 服务实现类
 *
 * @author zengyanyu
 * @since 2025-07-30
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

    /**
     * 保存或更新用户关联的角色
     *
     * @param userRole 用户关联的角色
     * @return
     */
    @Override
    public ResponseData saveOrUpdateUserRole(UserRole userRole) {
        this.saveOrUpdate(userRole);
        return new ResponseData("保存或更新成功");
    }

}
