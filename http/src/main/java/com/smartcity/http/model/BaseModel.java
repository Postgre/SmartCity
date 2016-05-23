package com.smartcity.http.model;

import java.io.Serializable;

/**
 * 在此写类用途
 *
 * @version V2.0
 * @FileName: BaseModel.java
 * @author: fengliang
 * @date: 2016-04-29 15:15
 */
public class BaseModel implements Serializable {
    private static final String TAG = "BaseModel";
    private String msg;
    private int code;
    private String total;

    public BaseModel(String msg, int code, String total) {
        this.msg = msg;
        this.code = code;
        this.total = total;
    }

    public BaseModel() {
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public String getTotal() {
        return total;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "BaseBeans{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", total='" + total + '\'' +
                '}';
    }
}
