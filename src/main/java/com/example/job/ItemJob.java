package com.example.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class ItemJob implements Job {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEEE");

    @Override
    public void execute(JobExecutionContext context) {
        log.info("currentTime ==>> " + DATE_FORMAT.format(new Date()));
    }
}
