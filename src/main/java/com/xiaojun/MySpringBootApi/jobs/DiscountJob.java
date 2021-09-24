package com.xiaojun.MySpringBootApi.jobs;

import org.springframework.stereotype.Component;

/**
 * 打折任务
 */
@Component // 注册到容器中
public class DiscountJob {
    /**
     * 执行打折
     */
    public void execute() {
        System.out.println("更新数据库中商品价格，统一打5折");
    }
}

