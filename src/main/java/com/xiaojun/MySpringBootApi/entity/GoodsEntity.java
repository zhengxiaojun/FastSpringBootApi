package com.xiaojun.MySpringBootApi.entity;

import com.alibaba.fastjson.JSONObject;

/**
 * 商品类
 */
public class GoodsEntity {
    /**
     * 商品id
     */
    public Long id;
    /**
     * 商品名称
     */
    public String name;
    /**
     * 商品价格
     */
    public String price;
    /**
     * 商品图片
     */
    public String pic;

    public Long getId() {
        return id;
    }

    public void setId(long l) {
        this.id = l;
    }

    public String getName() {
        return name;
    }

    public void setName(String s) {
        this.name = s;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String s) {
        this.pic = s;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String s) {
        this.price = s;
    }

    public String toString() {
        return JSONObject.toJSONString(this);
    }
}