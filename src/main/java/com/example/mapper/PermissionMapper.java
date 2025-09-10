package com.example.mapper;

import com.example.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 权限 Mapper 接口
 *
 * @author zengyanyu
 * @since 2025-09-10
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

}
