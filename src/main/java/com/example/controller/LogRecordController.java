package com.example.controller;

import com.alibaba.excel.EasyExcel;
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
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author zengyanyu
 * @since 2025-07-30
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

    @ApiOperation("导出Excel文件")
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 对中文编码
        String fileName = URLEncoder.encode("日志文件", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        List<LogRecordEntity> logRecordEntityList = logRecordService.list();
        EasyExcel.write(response.getOutputStream(), LogRecordEntity.class).sheet("日志记录").doWrite(logRecordEntityList);
    }

}

