package com.smartcity.http.model;

/**
 * 在此写类用途
 *
 * @version V2.0
 * @FileName: ReqCodeInfo.java
 * @author: fengliang
 * @date: 2016-04-30 09:46
 */
public class ReqCodeInfo extends BaseModel {
    private static final String TAG = "ReqCodeInfo";


    /**
     * total : 0
     * code : 1
     * msg : 获取验证码成功!
     * data : {"randomcode":"417282"}
     */


    /**
     * randomcode : 417282
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String randomcode;

        public String getRandomcode() {
            return randomcode;
        }

        public void setRandomcode(String randomcode) {
            this.randomcode = randomcode;
        }
    }
}
