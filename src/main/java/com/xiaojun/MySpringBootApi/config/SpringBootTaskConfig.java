package com.xiaojun.MySpringBootApi.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xiaojun.MySpringBootApi.services.GoodsRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 任务类
 */
@Component
public class SpringBootTaskConfig {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    GoodsRankService goodsRankService;

    /**
     * 每5秒执行1次
     */
    @Scheduled(fixedRate = 5000)
    public void fixedRateMethod() throws InterruptedException {
        System.out.println(sdf.format(new Date()) + " 【内置定时任务】fixedRateMethod: " + "每5秒执行1次");
        Thread.sleep(1000);
    }

    /**
     * 执行结束10秒后执行下次任务
     */
    @Scheduled(fixedDelay = 10000)
    public void fixedDelayMethod() {
        System.out.println(sdf.format(new Date()) + " 【内置定时任务】fixedDelayMethod: " + "执行结束10秒后执行下次任务");
    }

    /**
     * 在每分钟的00秒执行
     */
    @Scheduled(cron = "0 * * * * ?")
    public void jump() {
        System.out.println(sdf.format(new Date()) + " 【内置定时任务】心跳检测: " + "在每分钟的00秒执行");
    }

    /**
     * 在每天的10:25:00执行
     */
    @Scheduled(cron = "0 25 10 * * ?")
    public void stock() {
        System.out.println(sdf.format(new Date()) + " 【内置定时任务】开始清理库存: " + "在每天的10:25:00执行");
    }

    /**
     * 排行榜更新任务
     * 容器启动后马上执行，且每3秒执行1次
     */
    @Scheduled(initialDelay = 0, fixedRate = 3000)
    public void execute() throws JsonProcessingException {
        System.out.println(sdf.format(new Date()) + " 【内置定时任务】开始更新排行榜缓存: " + "每3秒执行1次");
        goodsRankService.updateRankList();
    }
}