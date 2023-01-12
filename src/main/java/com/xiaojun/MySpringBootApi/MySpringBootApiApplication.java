package com.xiaojun.MySpringBootApi;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableAdminServer // 开启监控管理
//@EnableScheduling // 开启定时任务
public class MySpringBootApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApiApplication.class, args);
    }
}
