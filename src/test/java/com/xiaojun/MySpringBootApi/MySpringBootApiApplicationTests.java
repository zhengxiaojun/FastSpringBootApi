package com.xiaojun.MySpringBootApi;

import com.xiaojun.MySpringBootApi.services.VisitService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 访问统计服务测试
 */
@SpringBootTest
class VisitServiceTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private VisitService visitService;

    @Test
    void test() {
        logger.info("访问次数：{}", visitService.getCurrentCount());
        // 使用线程池快速发起10000次访问
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            cachedThreadPool.execute(() -> visitService.addCount());
        }
    }
}
