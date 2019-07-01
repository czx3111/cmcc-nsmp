package com.ultrapower.web;

import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

public class AppTestJob {
    @Test
    public void Tests1() throws SchedulerException {
        // 创建JobDetail对象，指定对象的任务名称、组名
        JobDetail jobDetail = JobBuilder.newJob(TestJob.class)
                .withIdentity("job1","group1").build();
        // 获取当前时间
        Date startTime = new Date(System.currentTimeMillis());
        //时间计划表
        SimpleScheduleBuilder schedule =
                SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(10).withRepeatCount(10);
        // 创建SimpleTrigger对象
        //指定对象名称、组名 设置任务重复执行间隔时间，重复执行次数 启动时间
        SimpleTrigger trigger = TriggerBuilder.newTrigger()
                /// 设置触发器名，组名
                .withIdentity("trigger1","group1")
                // 设置重复间隔+重复次数，一直重复的话设置repeatForever()
                .withSchedule(schedule)
                // 设置开始时间
                .startNow().build();
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
            Thread.sleep(120L * 1000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 关闭定时任务管理器
        System.out.println("定时任务结束.......");
        sched.shutdown(true);

    }
}
