package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.commons.ResponseData;
import com.example.config.LogRecord;
import com.example.entity.Permission;
import com.example.service.IPermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zengyanyu
 * @since 2025-08-12
 */
@RestController
@Api(tags = "权限控制器")
@RequestMapping("/permission")
public class PermissionController extends BaseController {

    @Resource
    private IPermissionService permissionService;

    @LogRecord("保存或更新权限")
    @ApiOperation("保存或更新权限")
    @PostMapping("/save")
    public ResponseData save(@RequestBody Permission permission) {
        return permissionService.saveOrUpdatePermission(permission);
    }

    @LogRecord("删除权限")
    @ApiOperation("删除权限")
    @GetMapping("/{id}")
    public ResponseData delete(@PathVariable String id) {
        permissionService.removeById(id);
        return new ResponseData("删除成功");
    }

    @LogRecord("批量删除权限")
    @ApiOperation("批量删除权限")
    @PostMapping("/del/batch")
    public ResponseData deleteBatch(@RequestBody List<String> ids) {
        permissionService.removeByIds(ids);
        return new ResponseData("批量删除成功");
    }

    @LogRecord("查询所有数据")
    @ApiOperation("查询所有数据")
    @GetMapping("/findAll")
    public ResponseData<List<Permission>> findAll() {
        return new ResponseData("根据ID查询指定数据", permissionService.list());
    }

    @LogRecord("根据ID查询指定数据")
    @ApiOperation("根据ID查询指定数据")
    @GetMapping("/get/{id}")
    public ResponseData<Permission> get(@PathVariable String id) {
        return new ResponseData("根据ID查询指定数据", permissionService.getById(id));
    }

    @LogRecord("权限分页查询数据")
    @ApiOperation("权限分页查询数据")
    @GetMapping("/page")
    public Page<Permission> page(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        QueryWrapper<Permission> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        return permissionService.page(new Page<>(pageNum, pageSize), wrapper);
    }
}

