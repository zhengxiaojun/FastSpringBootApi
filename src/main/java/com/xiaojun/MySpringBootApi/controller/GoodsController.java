package com.xiaojun.MySpringBootApi.controller;

import com.xiaojun.MySpringBootApi.entity.GoodsEntity;
import com.xiaojun.MySpringBootApi.entity.ResultBo;
import com.xiaojun.MySpringBootApi.services.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品控制器类
 */
//@RequestMapping("/test")
@RestController // 通过该注解，第一是将GoodsController注册为控制器，可以响应Http请求；第二是可以将控制器中的方法返回值序列化为json格式
public class GoodsController {
    @Autowired // 自动装配goodsService
    private GoodsService goodsService;


    /**
     * 查询商品列表，使用get方法
     */
    @GetMapping("/goods")
    public List<GoodsEntity> getList() {
//        int a = 1 / 0;
        return goodsService.getGoodsList();
    }

    /**
     * 按ID查询商品列表，使用get方法
     */
    @GetMapping("/goods/{id}")
    public GoodsEntity getOne(@PathVariable("id") long id) {
        return goodsService.getGoodsById(id);
    }

    /**
     * 新增商品
     * 1、@PostMapping表示使用post方法
     * 2、@RequestBody表示将请求中的json信息转换为GoodsDo类型的对象信息，该转换也是由SpringMVC自动完成的
     */
    @PostMapping("/goods")
    public String add(@RequestBody GoodsEntity goods) {
        return goodsService.addGoods(goods);
    }

    /**
     * 修改商品
     */
    @PutMapping("/goods")
    public String update(@RequestBody GoodsEntity goods) {
        // 修改指定id的商品信息
        return goodsService.editGoods(goods);
    }

    /**
     * 删除商品
     */
    @DeleteMapping("/goods/{id}")
    public String delete(@PathVariable("id") long id) {
        return goodsService.removeGoods(id);
    }
}

