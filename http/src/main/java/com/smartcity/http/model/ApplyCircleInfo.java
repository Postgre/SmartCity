package com.smartcity.http.model;

/**
 * Created by Administrator on 2016/5/25.
 */
public class ApplyCircleInfo {


    /**
     * total : 0
     * code : 1
     * msg : 申请成功
     * data : 1
     */

    private int total;
    private int code;
    private String msg;
    private int data;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

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

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ApplyCircleInfo{" +
                "total=" + total +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
