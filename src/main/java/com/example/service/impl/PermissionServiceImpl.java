package com.example.service.impl;

import com.example.commons.ResponseData;
import com.example.entity.Permission;
import com.example.mapper.PermissionMapper;
import com.example.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 权限 服务实现类
 *
 * @author zengyanyu
 * @since 2025-08-12
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

    /**
     * 保存或更新权限
     *
     * @param permission 权限
     * @return
     */
    @Override
    public ResponseData saveOrUpdatePermission(Permission permission) {
        this.saveOrUpdate(permission);
        return new ResponseData("保存或更新成功");
    }

}
