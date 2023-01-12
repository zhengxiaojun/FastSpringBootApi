package com.xiaojun.MySpringBootApi.jobs;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 打折任务
 */
@Component // 注册到容器中
public class DiscountJob {
    /**
     * 执行打折
     */
    public void execute() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()) + " [Quartz任务调度器] INFO 更新数据库中商品价格，统一打5折");
    }
}

