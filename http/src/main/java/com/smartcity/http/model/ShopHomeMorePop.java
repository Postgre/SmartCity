package com.smartcity.http.model;

/**
 * Created by Yancy on 2016/5/11.
 */
public class ShopHomeMorePop {
    public int icon;
    public String name;
    public int type;


    public ShopHomeMorePop() {
    }

    public ShopHomeMorePop(int icon, String name, int type) {
        this.icon = icon;
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "ShopHomeMorePop{" +
                "icon=" + icon +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
