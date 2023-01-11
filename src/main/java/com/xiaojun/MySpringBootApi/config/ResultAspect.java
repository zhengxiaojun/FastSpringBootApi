package com.xiaojun.MySpringBootApi.config;

import com.xiaojun.MySpringBootApi.entity.ResultBo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 返回值切面
 */
@Component
@Aspect
public class ResultAspect {
    // 切入点表达式，表示切入点为返回类型ResultBo的所有方法
    @Pointcut("within(com.xiaojun.MySpringBootApi.entity.ResultBo..*)")
    public void ResultAspect() {
    }

    // 环绕通知
    @Around("ResultAspect()")
    public Object deAround(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            return joinPoint.proceed();// 返回正常结果
        } catch (Exception ex) {
            return new ResultBo<>(ex);// 被切入的方法执行异常时，返回ResultBo
        }
    }
}

