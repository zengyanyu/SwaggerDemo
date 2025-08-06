package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.commons.ResponseData;
import com.example.config.LogRecord;
import com.example.entity.UserInfo;
import com.example.query.UserQueryObject;
import com.example.service.IUserInfoService;
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
@Api(tags = "用户信息控制器")
@RequestMapping("/user-info")
public class UserInfoController extends BaseController {

    @Resource
    private IUserInfoService userInfoService;

    @LogRecord("保存或更新用户信息")
    @ApiOperation("保存或更新用户信息")
    @PostMapping("/save")
    public ResponseData save(@RequestBody UserInfo userInfo) {
        return userInfoService.saveOrUpdateUserInfo(userInfo);
    }

    @LogRecord("删除用户信息")
    @ApiOperation("删除用户信息")
    @GetMapping("/{id}")
    public ResponseData delete(@PathVariable String id) {
        userInfoService.removeById(id);
        return new ResponseData("删除成功");
    }

    @LogRecord("批量删除用户信息")
    @ApiOperation("批量删除用户信息")
    @PostMapping("/del/batch")
    public ResponseData deleteBatch(@RequestBody List<String> ids) {
        userInfoService.removeByIds(ids);
        return new ResponseData("批量删除成功");
    }

    @LogRecord("查询所有数据")
    @ApiOperation("查询所有数据")
    @GetMapping("/findAll")
    public ResponseData<List<UserInfo>> findAll() {
        return new ResponseData("根据ID查询指定数据", userInfoService.list());
    }

    @LogRecord("根据ID查询指定数据")
    @ApiOperation("根据ID查询指定数据")
    @GetMapping("/get/{id}")
    public ResponseData<UserInfo> get(@PathVariable String id) {
        return new ResponseData("根据ID查询指定数据", userInfoService.getById(id));
    }

    @LogRecord("用户信息分页查询数据")
    @ApiOperation("用户信息分页查询数据")
    @GetMapping("/page")
    public Page<UserInfo> page(UserQueryObject queryObject) {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        return userInfoService.page(new Page<>(queryObject.getPageNum(), queryObject.getPageSize()), wrapper);
    }
}

