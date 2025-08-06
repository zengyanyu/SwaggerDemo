package com.example.service.impl;

import com.example.commons.ResponseData;
import com.example.entity.Department;
import com.example.mapper.DepartmentMapper;
import com.example.service.IDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 部门管理 服务实现类
 *
 * @author zengyanyu
 * @since 2025-07-30
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

    /**
     * 保存或更新部门管理
     *
     * @param department 部门管理
     * @return
     */
    @Override
    public ResponseData saveOrUpdateDepartment(Department department) {
        this.saveOrUpdate(department);
        return new ResponseData("保存或更新成功");
    }

}
