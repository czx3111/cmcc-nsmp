package com.ultrapower.web;

import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

public class AppTestJob1 {
    @Test
    public void Tests2() throws SchedulerException {
        // 创建JobDetail对象，指定对象的任务名称、组名
        JobDetail jobDetail = JobBuilder.newJob(TestJob.class)
                .withIdentity("job1","group1").build();

        //时间计划表
        CronScheduleBuilder schedule = CronScheduleBuilder
                .cronSchedule("0/1 * * * * ? *");
        CronTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1","group1")
                .withSchedule(schedule).build();

        // 创建任务管理器Scheduler对象
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();
        // 为Scheduler对象新增JOB以及对应的SimpleTrigger
        sched.scheduleJob(jobDetail,trigger);
        // 启动定时任务管理器
        System.out.println("开启定时任务.......");
        sched.start();
        // 主线程睡眠2分钟
        try {
            // wait five minutes to show jobs
          //  Thread.sleep(1200L * 1000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 关闭定时任务管理器
        for (int i=1;i<99999;i++){

        }
        System.out.println("定时任务结束.......");
        sched.shutdown(true);

    }
}
