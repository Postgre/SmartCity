package com.smartcity.http.model;

import java.util.List;

/**
 * Created by Yancy on 2016/5/18.
 * 购物车
 */
public class CartInfo extends BaseModel{

    private List<ScShopCartVo> data;

    public List<ScShopCartVo> getData() {
        return data;

    }

    public void setData(List<ScShopCartVo> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CartInfo{" +
                "data=" + data +
                '}';
    }
}
