package com.example.service;

import com.example.commons.ResponseData;
import com.example.entity.Department;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 部门管理 服务类
 *
 * @author zengyanyu
 * @since 2025-07-30
 */
public interface IDepartmentService extends IService<Department> {

    /**
     * 保存或更新部门管理
     *
     * @param department 部门管理
     * @return
     */
    ResponseData saveOrUpdateDepartment(Department department);

}
