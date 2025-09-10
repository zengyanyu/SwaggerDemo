package com.example.service;

import com.example.commons.ResponseData;
import com.example.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 角色 服务类
 *
 * @author zengyanyu
 * @since 2025-09-10
 */
public interface IRoleService extends IService<Role> {

    /**
     * 保存或更新角色
     *
     * @param role 角色
     * @return
     */
    ResponseData saveOrUpdateRole(Role role);

}
