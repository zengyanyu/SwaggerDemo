package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.LogRecordEntity;
import com.example.query.LogRecordQueryObject;
import com.example.service.ILogRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zengyanyu
 * @since 2024-11-20
 */
@RestController
@Api(tags = "日志记录控制器")
@RequestMapping("/log-record")
public class LogRecordController extends BaseController {

    @Resource
    private ILogRecordService logRecordService;

    @ApiOperation("分页查询数据")
    @GetMapping("/page")
    public Page<LogRecordEntity> page(LogRecordQueryObject queryObject) {
        QueryWrapper<LogRecordEntity> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("request_time");
        if (StringUtils.isNotEmpty(queryObject.getStartTime()) && StringUtils.isNotEmpty(queryObject.getEndTime())) {
            wrapper.between("request_time", queryObject.getStartTime(), queryObject.getEndTime());
        }
        // 操作账号
        if (StringUtils.isNotEmpty(queryObject.getOperateUsername())) {
            wrapper.like("operate_username", queryObject.getOperateUsername());
        }
        return logRecordService.page(new Page<>(queryObject.getPageNum(), queryObject.getPageSize()), wrapper);
    }
}

