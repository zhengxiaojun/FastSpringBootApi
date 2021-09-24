package com.xiaojun.MySpringBootApi.services;

//import com.sun.org.slf4j.internal.Logger;
//import com.sun.org.slf4j.internal.LoggerFactory;

import com.xiaojun.MySpringBootApi.entity.GoodsEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;
import java.util.Map.Entry;

/**
 * 商品服务
 */
@Service // 注册为服务类
public class GoodsService {
    /**
     * 获取商品列表
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public List<GoodsEntity> getGoodsList() {
        List<GoodsEntity> goodsList = new ArrayList<>();

        String sql = "select * from goods";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : list) {
//            Set<Entry<String, Object>> entries = map.entrySet();
//            for (Entry<String, Object> entry : entries) {
//                Object key = entry.getKey();
//                Object value = entry.getValue();
//                logger.info(key + ":" + value);
//            }
            logger.info(String.valueOf(map));
            GoodsEntity goods_entity = new GoodsEntity();
            goods_entity.setId(Long.parseLong(map.get("id").toString()));
            goods_entity.setName(map.get("name").toString());
            goods_entity.setPic(map.get("pic").toString());
            goods_entity.setPrice(map.get("price").toString());
            goodsList.add(goods_entity);
        }

        return goodsList;
    }

    /**
     * 按id获取商品信息，模拟返回对应商品信息
     */
    public GoodsEntity getGoodsById(Long id) {
        GoodsEntity goods_entity = new GoodsEntity();
        List<GoodsEntity> list = getGoodsList();

        for (GoodsEntity goodEntity : list) {
            if (goodEntity.id.equals(id)) {
                goods_entity = goodEntity;
            }
        }
        return goods_entity;
//        Map<String, Object> map = null;
//        for (Map<String, Object> dbmap : list) {
//            Set<String> set = dbmap.keySet();
//            for (String key : set) {
//                if (key.equals("id")) {
//                    if (dbmap.get(key).equals(id)) {
//                        map = dbmap;
//                    }
//                }
//            }
//        }
//        if (map == null) {
//            HashMap<String, Object> good = new HashMap<String, Object>();
//            // 添加键值对
//            good.put("msg", "未查询到商品");
//            map = good;
//        }
    }

    /**
     * 新增商品，模拟返回数据库影响行数
     */
    public String addGoods(GoodsEntity goods) {
        String sql = "insert into goods values(" + goods.id + ",'" + goods.name + "','" + goods.pic + "','" + goods.price + "');";
        jdbcTemplate.execute(sql);
        return "添加成功";
    }

    /**
     * 根据商品id更新商品信息，模拟返回数据库影响行数
     */
    public String editGoods(GoodsEntity goods) {
        String sql = "update goods set name='" + goods.name + "',pic='" + goods.pic + "',price='" + goods.price + "' where id=" + goods.id + ";";
        jdbcTemplate.execute(sql);
        return "更新成功";
    }

    /**
     * 根据商品id删除对应商品，模拟返回数据库影响行数
     */
    public String removeGoods(Long id) {
        String sql = "delete from goods where id=" + id + ";";
        jdbcTemplate.execute(sql);
        return "删除成功";
    }
}

