package com.example.config;

import com.example.job.ItemJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail itemJobDetail() {
        return JobBuilder.newJob(ItemJob.class)
                .withIdentity("itemJobDetail", "group1")
                .storeDurably()
                .build();
    }

//    @Bean
//    public Trigger itemJobTrigger() {
//        return TriggerBuilder.newTrigger()
//                .forJob(itemJobDetail())
//                .withIdentity("itemJobTrigger", "group1")
//                // 每天凌晨两点执行一次
//                // CronScheduleBuilder.cronSchedule("0 0 2 * * ?")
//                // 每3妙执行一次
//                .withSchedule(CronScheduleBuilder.cronSchedule("0/3 * * * * ?"))
//                .build();
//    }

}
