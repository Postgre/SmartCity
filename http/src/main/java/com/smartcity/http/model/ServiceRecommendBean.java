package com.smartcity.http.model;

import java.util.List;

/**
 * Created by Administrator on 2016/5/23.
 */
public class ServiceRecommendBean {


    /**
     * total : 0
     * code : 1
     * msg : 查询成功
     * data : [{"typeId":1,"parentTypeId":0,"typeName":"美妆","typeIcon":"http://tsnrhapp.oss-cn-hangzhou.aliyuncs.com/service%2Fmeizhuang%402x.png"},{"typeId":2,"parentTypeId":0,"typeName":"健康","typeIcon":"http://tsnrhapp.oss-cn-hangzhou.aliyuncs.com/service%2Fjiankang%402x.png"},{"typeId":4,"parentTypeId":0,"typeName":"教育","typeIcon":"http://tsnrhapp.oss-cn-hangzhou.aliyuncs.com/service%2Fjiaoyu%402x.png"},{"typeId":6,"parentTypeId":0,"typeName":"租房","typeIcon":"http://tsnrhapp.oss-cn-hangzhou.aliyuncs.com/service%2Ffangzi-%402x.png"},{"typeId":8,"parentTypeId":0,"typeName":"维修","typeIcon":"http://tsnrhapp.oss-cn-hangzhou.aliyuncs.com/service%2Fweixiu%402x.png"},{"typeId":9,"parentTypeId":0,"typeName":"商务","typeIcon":"http://tsnrhapp.oss-cn-hangzhou.aliyuncs.com/service%2Fshangwu%402x.png"},{"typeId":10,"parentTypeId":0,"typeName":"专家团","typeIcon":"http://tsnrhapp.oss-cn-hangzhou.aliyuncs.com/service%2Fzhuangjiatuan%402x.png"}]
     */

    private int total;
    private int code;
    private String msg;
    /**
     * typeId : 1
     * parentTypeId : 0
     * typeName : 美妆
     * typeIcon : http://tsnrhapp.oss-cn-hangzhou.aliyuncs.com/service%2Fmeizhuang%402x.png
     */

    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private int typeId;
        private int parentTypeId;
        private String typeName;
        private String typeIcon;

        public int getTypeId() {
            return typeId;
        }

        public void setTypeId(int typeId) {
            this.typeId = typeId;
        }

        public int getParentTypeId() {
            return parentTypeId;
        }

        public void setParentTypeId(int parentTypeId) {
            this.parentTypeId = parentTypeId;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public String getTypeIcon() {
            return typeIcon;
        }

        public void setTypeIcon(String typeIcon) {
            this.typeIcon = typeIcon;
        }
    }
}
