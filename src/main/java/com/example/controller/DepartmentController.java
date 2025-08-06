package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.commons.ResponseData;
import com.example.config.LogRecord;
import com.example.entity.Department;
import com.example.query.DepartmentQueryObject;
import com.example.service.IDepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zengyanyu
 * @since 2025-07-30
 */
@RestController
@Api(tags = "部门管理控制器")
@RequestMapping("/department")
public class DepartmentController extends BaseController {

    @Resource
    private IDepartmentService departmentService;

    @LogRecord("保存或更新部门管理")
    @ApiOperation("保存或更新部门管理")
    @PostMapping("/save")
    public ResponseData save(@RequestBody Department department) {
        return departmentService.saveOrUpdateDepartment(department);
    }

    @LogRecord("删除部门管理")
    @ApiOperation("删除部门管理")
    @GetMapping("/{id}")
    public ResponseData delete(@PathVariable String id) {
        departmentService.removeById(id);
        return new ResponseData("删除成功");
    }

    @LogRecord("批量删除部门管理")
    @ApiOperation("批量删除部门管理")
    @PostMapping("/del/batch")
    public ResponseData deleteBatch(@RequestBody List<String> ids) {
        departmentService.removeByIds(ids);
        return new ResponseData("批量删除成功");
    }

    @LogRecord("查询所有数据")
    @ApiOperation("查询所有数据")
    @GetMapping("/findAll")
    public ResponseData<List<Department>> findAll() {
        return new ResponseData("根据ID查询指定数据", departmentService.list());
    }

    @LogRecord("根据ID查询指定数据")
    @ApiOperation("根据ID查询指定数据")
    @GetMapping("/get/{id}")
    public ResponseData<Department> get(@PathVariable String id) {
        return new ResponseData("根据ID查询指定数据", departmentService.getById(id));
    }

    @LogRecord("部门管理分页查询数据")
    @ApiOperation("部门管理分页查询数据")
    @GetMapping("/page")
    public Page<Department> page(DepartmentQueryObject queryObject) {
        QueryWrapper<Department> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        return departmentService.page(new Page<>(queryObject.getPageNum(), queryObject.getPageSize()), wrapper);
    }
}

