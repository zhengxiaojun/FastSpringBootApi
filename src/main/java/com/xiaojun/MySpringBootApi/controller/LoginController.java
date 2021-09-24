package com.xiaojun.MySpringBootApi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录控制器
 */
@RestController
public class LoginController {
    /**
     * 登录方法
     */
    @RequestMapping("/login")
    public Map<String, Object> login(HttpServletRequest request, String username, String password) {
        HashMap<String, Object> resp = new HashMap<String, Object>();
        if (username.equals("xiaojun") && password.equals("123456")) {
            // 登录成功，则添加Session并存储登录用户名
            request.getSession().setAttribute("LOGIN_NAME", username);
            // 添加键值对
            resp.put("msg", "登录成功");

        } else {
            resp.put("msg", "用户名密码不对，请输入正确的用户名或密码");
        }
        return resp;
    }

    /**
     * 获取登录人员信息
     */
    @RequestMapping("/info")
    public Map<String, Object> info(HttpServletRequest request) {
        HashMap<String, Object> resp = new HashMap<String, Object>();
        if (request.getSession().getAttribute("LOGIN_NAME") == null) {
            resp.put("msg", "请先登录");
        } else {
            resp.put("msg", "当前用户：" + request.getSession().getAttribute("LOGIN_NAME"));
        }
        return resp;
    }
}
