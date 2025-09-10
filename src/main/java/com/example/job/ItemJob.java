package com.example.job;

import com.example.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.util.Date;

@Slf4j
public class ItemJob implements Job {

    @Override
    public void execute(JobExecutionContext context) {
        log.info("currentTime ==>> " + DateUtils.SIMPLE_DATE_FORMAT.format(new Date()));
    }
}
