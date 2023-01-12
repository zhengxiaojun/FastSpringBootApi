package com.xiaojun.MySpringBootApi.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 任务类
 */
@Component
public class SpringBootTaskConfig {
    /**
     * 每5秒执行1次
     */
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void fixedRateMethod() throws InterruptedException {
        System.out.println(sdf.format(new Date()) + " 【内置定时任务】fixedRateMethod: " + "每5秒执行1次");
        Thread.sleep(1000);
    }

    /**
     * 执行结束10秒后执行下次任务
     */
    @Scheduled(fixedDelay = 10000)
    public void fixedDelayMethod() throws InterruptedException {
        System.out.println(sdf.format(new Date()) + " 【内置定时任务】fixedDelayMethod: " + "执行结束10秒后执行下次任务");
    }

    /**
     * 在每分钟的00秒执行
     */
    @Scheduled(cron = "0 * * * * ?")
    public void jump() throws InterruptedException {
        System.out.println(sdf.format(new Date()) + " 【内置定时任务】心跳检测: " + "在每分钟的00秒执行");
    }

    /**
     * 在每天的10:25:00执行
     */
    @Scheduled(cron = "0 25 10 * * ?")
    public void stock() throws InterruptedException {
        System.out.println(sdf.format(new Date()) + " 【内置定时任务】开始清理库存: " + "在每天的10:25:00执行");
    }
}