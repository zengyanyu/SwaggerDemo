package com.example.service.impl;

import com.example.commons.ResponseData;
import com.example.entity.Role;
import com.example.mapper.RoleMapper;
import com.example.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 角色 服务实现类
 *
 * @author zengyanyu
 * @since 2025-09-10
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    /**
     * 保存或更新角色
     *
     * @param role 角色
     * @return
     */
    @Override
    public ResponseData saveOrUpdateRole(Role role) {
        this.saveOrUpdate(role);
        return new ResponseData("保存或更新成功");
    }

}
