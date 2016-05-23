package com.smartcity.http.model;

import java.util.List;

/**
 * Created by Yancy on 2016/5/20.
 */
public class CouponModel extends BaseModel{

    /**
     * id : 1
     * shopId : 1
     * name : 优惠券1
     * type : 0
     * scopeType : 0
     * scopeData : null
     * rule : null
     * numberOne : 1
     * numberTotal : 100
     * amount : 10
     * status : 0
     * beginTime : 2016-04-07 17:09:00
     * endTime : 2016-04-30 17:09:02
     * createTime : 2016-04-07 17:09:06
     * editTime : null
     * createUser : 10000
     * modifyTime : 2016-05-18 16:01:27
     * modifyUser : 10000
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private int id;
        private int shopId;//店铺ID
        private String name;//优惠券名称
        private int type;//暂时取值只有0表示优惠券
        private int scopeType;//暂时取值只有0表示优惠范围，0-全店不限
        private String scopeData;
        private String rule;//优惠规则，0-不限消费额度
        private int numberOne;//单人领取数量限制
        private int numberTotal;//总数量限制
        private int amount;//抵扣金额
        private int status;//优惠状态，0可用，1不可用
        private String beginTime;//优惠开始时间
        private String endTime;//优惠结束时间
        private String createTime;//创建时间
        private String editTime;
        private int createUser;
        private String modifyTime;
        private int modifyUser;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getShopId() {
            return shopId;
        }

        public void setShopId(int shopId) {
            this.shopId = shopId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getScopeType() {
            return scopeType;
        }

        public void setScopeType(int scopeType) {
            this.scopeType = scopeType;
        }

        public Object getScopeData() {
            return scopeData;
        }

        public void setScopeData(String scopeData) {
            this.scopeData = scopeData;
        }

        public Object getRule() {
            return rule;
        }

        public void setRule(String rule) {
            this.rule = rule;
        }

        public int getNumberOne() {
            return numberOne;
        }

        public void setNumberOne(int numberOne) {
            this.numberOne = numberOne;
        }

        public int getNumberTotal() {
            return numberTotal;
        }

        public void setNumberTotal(int numberTotal) {
            this.numberTotal = numberTotal;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(String beginTime) {
            this.beginTime = beginTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Object getEditTime() {
            return editTime;
        }

        public void setEditTime(String editTime) {
            this.editTime = editTime;
        }

        public int getCreateUser() {
            return createUser;
        }

        public void setCreateUser(int createUser) {
            this.createUser = createUser;
        }

        public String getModifyTime() {
            return modifyTime;
        }

        public void setModifyTime(String modifyTime) {
            this.modifyTime = modifyTime;
        }

        public int getModifyUser() {
            return modifyUser;
        }

        public void setModifyUser(int modifyUser) {
            this.modifyUser = modifyUser;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", shopId=" + shopId +
                    ", name='" + name + '\'' +
                    ", type=" + type +
                    ", scopeType=" + scopeType +
                    ", scopeData='" + scopeData + '\'' +
                    ", rule='" + rule + '\'' +
                    ", numberOne=" + numberOne +
                    ", numberTotal=" + numberTotal +
                    ", amount=" + amount +
                    ", status=" + status +
                    ", beginTime='" + beginTime + '\'' +
                    ", endTime='" + endTime + '\'' +
                    ", createTime='" + createTime + '\'' +
                    ", editTime='" + editTime + '\'' +
                    ", createUser=" + createUser +
                    ", modifyTime='" + modifyTime + '\'' +
                    ", modifyUser=" + modifyUser +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "CouponModel{" +
                "data=" + data +
                '}';
    }
}
