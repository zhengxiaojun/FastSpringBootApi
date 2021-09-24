package com.xiaojun.MySpringBootApi.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 任务类
 */
@Component
public class SpringBootTaskConfig {
//    /**
//     * 每2秒执行1次
//     */
//    @Scheduled(fixedRate = 2000)
//    public void fixedRateMethod() throws InterruptedException {
//        System.out.println("fixedRateMethod:" + new Date());
//        Thread.sleep(1000);
//    }
//
//    /**
//     * 执行结束2秒后执行下次任务
//     */
//    @Scheduled(fixedDelay = 2000)
//    public void fixedDelayMethod() throws InterruptedException {
//        System.out.println("fixedDelayMethod:" + new Date());
//        Thread.sleep(1000);
//    }

//    /**
//     * 在每分钟的00秒执行
//     */
//    @Scheduled(cron = "0 * * * * ?")
//    public void jump() throws InterruptedException {
//        System.out.println("心跳检测:" + new Date());
//    }
//
//    /**
//     * 在每天的00:00:00执行
//     */
//    @Scheduled(cron = "0 08 14 * * ?")
//    public void stock() throws InterruptedException {
//        System.out.println("置满库存:" + new Date());
//    }
}