package com.smartcity.http.model;

/**
 * Created by Yancy on 2016/5/16
 * 选择支付方式   配送时间...模型.
 */
public class LifeOrderSelectType {
    public String name;
    public int type;
    public int showImg;

    public LifeOrderSelectType(String name, int type, int showImg) {
        this.name = name;
        this.type = type;
        this.showImg = showImg;
    }

    public LifeOrderSelectType() {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LifeOrderSelectType that = (LifeOrderSelectType) o;

        if (type != that.type) return false;
        if (showImg != that.showImg) return false;
        return !(name != null ? !name.equals(that.name) : that.name != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + type;
        result = 31 * result + showImg;
        return result;
    }
}
