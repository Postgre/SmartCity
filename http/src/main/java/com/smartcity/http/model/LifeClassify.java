package com.smartcity.http.model;

import java.util.List;

/**
 * Created by Yancy on 2016/5/12.
 */
public class LifeClassify {

    public  int img;
    public String title;
    public String name;
    public boolean isShow;
    public List<String> classify;

    public int type;

    public LifeClassify() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LifeClassify that = (LifeClassify) o;

        if (img != that.img) return false;
        if (isShow != that.isShow) return false;
        if (type != that.type) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return !(classify != null ? !classify.equals(that.classify) : that.classify != null);

    }

    @Override
    public int hashCode() {
        int result = img;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (isShow ? 1 : 0);
        result = 31 * result + (classify != null ? classify.hashCode() : 0);
        result = 31 * result + type;
        return result;
    }

    public LifeClassify(int img, String title, String name, boolean isShow, List<String> classify, int type) {
        this.img = img;
        this.title = title;
        this.name = name;
        this.isShow = isShow;
        this.classify = classify;
        this.type = type;
    }

}
