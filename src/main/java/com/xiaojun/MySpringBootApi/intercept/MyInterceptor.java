package com.xiaojun.MySpringBootApi.intercept;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 自定义拦截器类
 */
public class MyInterceptor implements HandlerInterceptor {// 实现HandlerInterceptor接口

    /**
     * 访问控制器方法前执行
     *
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(new Date() + "请求开始前:" + request.getRequestURL());
        if (request.getRequestURI().contains("/login") || request.getRequestURI().contains("/info")) {// 登录方法直接放行
            return true;
        } else {// 其他方法需要先检验是否存在Session,未登录的不允许访问
            return request.getSession().getAttribute("LOGIN_NAME") != null;
        }
    }


    /**
     * 访问控制器方法后执行
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println(new Date() + "请求执行中:" + request.getRequestURL());
    }

    /**
     * postHandle方法执行完成后执行，一般用于释放资源
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println(new Date() + "请求完成后:" + request.getRequestURL());
    }
}