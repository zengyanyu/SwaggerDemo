package com.example.service;

import com.example.commons.ResponseData;
import com.example.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 权限 服务类
 *
 * @author zengyanyu
 * @since 2025-08-12
 */
public interface IPermissionService extends IService<Permission> {

    /**
     * 保存或更新权限
     *
     * @param permission 权限
     * @return
     */
    ResponseData saveOrUpdatePermission(Permission permission);

}
