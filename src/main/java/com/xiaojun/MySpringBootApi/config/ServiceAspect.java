package com.xiaojun.MySpringBootApi.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 服务层方法切面
 */
@Component
@Aspect // 标注为切面
public class ServiceAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // 切入点表达式，表示切入点为服务层包中的所有方法
    @Pointcut("within(com.xiaojun.MySpringBootApi.services..*)")
    public void ServiceAspect() {
    }

    @Around("ServiceAspect()") // 环绕通知
    public Object deAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();// 记录开始时间
        Object result = joinPoint.proceed();
        logger.info("服务层方法:{}--执行时间:{}毫秒", joinPoint.getSignature(), System.currentTimeMillis() - startTime);
        return result;
    }
}
