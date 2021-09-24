package com.xiaojun.MySpringBootApi.controller;

import com.xiaojun.MySpringBootApi.entity.UserEntity;
import com.xiaojun.MySpringBootApi.exception.BaseException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @GetMapping("/user")
    public List<UserEntity> findByUser(UserEntity user) {
        System.out.println("开始查询...");
        List<UserEntity> userList = new ArrayList<>();
        UserEntity user_entity = new UserEntity();
        user_entity.setId(1);
        user_entity.setName("xuwujing");
        user_entity.setAge(18);
        userList.add(user_entity);
        return userList;
    }

    @PostMapping("/user")
    public boolean insert(@RequestBody UserEntity user) {
        System.out.println("开始新增...");
        //如果姓名为空就手动抛出一个自定义的异常！
        if (user.getName() == null) {
            throw new BaseException("-1", "用户姓名不能为空！");
        }
        return true;
    }

    @PutMapping("/user")
    public boolean update(@RequestBody UserEntity user) {
        System.out.println("开始更新...");
        //这里故意造成一个空指针的异常，并且不进行处理
        String str = null;
        str.equals("111");
        return true;
    }

    @DeleteMapping("/user")
    public boolean delete(@RequestBody UserEntity user) {
        System.out.println("开始删除...");
        //这里故意造成一个异常，并且不进行处理
        Integer.parseInt("abc123");
        return true;
    }
}
