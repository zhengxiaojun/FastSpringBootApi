package com.xiaojun.MySpringBootApi.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiaojun.MySpringBootApi.entity.GoodsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 商品排行榜服务类
 */
@Service
public class GoodsRankService {
    // 设定商品排行榜Redis键名
    private final static String KEY = "goods_rank";

    // 注入redisTemplate操作Redis
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    // 更新Redis缓存的排行榜
    public void updateRankList() throws JsonProcessingException {
        // 此处直接定义商品排行榜，真实场景应为从数据库获取
        List<GoodsEntity> rankList = new ArrayList<>();
        GoodsEntity goods = new GoodsEntity();
        goods.setId(1L);
        goods.setName("鸡蛋" + new Date());// 添加时间信息，以便测试缓存更新了
        goods.setPic("test.png");
        goods.setPrice("99.99");
        rankList.add(goods);
        // 将rankList序列化后写入Reidis
        ObjectMapper mapper = new ObjectMapper();
        redisTemplate.opsForValue().set(KEY, mapper.writeValueAsString(rankList));
    }

    // 获取Redis缓存的排行榜
    public List getRandkList() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(redisTemplate.opsForValue().get(KEY), List.class);
    }
}

