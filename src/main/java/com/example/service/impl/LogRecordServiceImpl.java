package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.LogRecordEntity;
import com.example.mapper.LogRecordMapper;
import com.example.service.ILogRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 日志记录 服务实现类
 *
 * @author zengyanyu
 * @since 2025-07-30
 */
@Service
@Transactional
public class LogRecordServiceImpl extends ServiceImpl<LogRecordMapper, LogRecordEntity> implements ILogRecordService {

}
