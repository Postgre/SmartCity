package com.smartcity.http.model;

import java.io.Serializable;

/**
 * 在此写类用途
 *
 * @version V2.0
 * @FileName: CoolDetailInfo.java
 * @author: fengliang
 * @date: 2016-05-09 17:22
 */
public class CoolDetailInfo implements Serializable {
    private static final String TAG = "CoolDetailInfo";

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
