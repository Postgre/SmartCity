package com.smartcity.bean;

import android.support.v4.app.Fragment;

import java.io.Serializable;
/**
 * 在此写类用途
 *
 * @version V2.0
 * @FileName: SelectItem.java
 * @author: fengliang
 * @date: 2016-05-09 11:09
 */
public class SelectItem implements Serializable {
    private Fragment fragment;
    private String desc;

    public SelectItem(Fragment fragment, String desc) {
        this.fragment = fragment;
        this.desc = desc;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}