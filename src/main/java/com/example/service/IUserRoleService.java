package com.example.service;

import com.example.commons.ResponseData;
import com.example.entity.UserRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 用户关联的角色 服务类
 *
 * @author zengyanyu
 * @since 2025-07-30
 */
public interface IUserRoleService extends IService<UserRole> {

    /**
     * 保存或更新用户关联的角色
     *
     * @param userRole 用户关联的角色
     * @return
     */
    ResponseData saveOrUpdateUserRole(UserRole userRole);

}
