package com.smartcity.bean;

/**
 * Created by Administrator on 2016/4/23.
 */
public class CircleDetailModel {
    /**
     * total : 1
     * code : 1
     * msg : null
     * data : {"detailId":4,"detailTypeId":1,"detailName":"圈子1","detailTitle":"圈子标题1","detailAds":"广告1","detailCreatePeople":3,"detailNumber":100,"detailActivityTimes":50,"detailLevel":5,"detailStatus":1,"detailIsOpen":0,"detailLevelPic":"http://333.3.3.3","detailTitlePic":"http://231.1.1.1","detailEwmPic":"http://123.3.3.3","detailIsToll":0,"detailTollMethod":1,"detailTollMoney":500,"detailLoginName":"zhangsan","detailMorefield1":null,"detailMorefield2":null,"detailMorefield3":null,"sStartpage":null,"sPagerows":null,"joinActivityTotalNum":null,"detailPid":null,"detailTime":"2016-04-13 00:00:00","detailIsFansteam":1,"isApply":null,"sPersonUserId":null,"sUserName":null,"detailTid":"","lscd":null}
     */

    private int total;
    private int code;
    private Object msg;
    /**
     * detailId : 4
     * detailTypeId : 1
     * detailName : 圈子1
     * detailTitle : 圈子标题1
     * detailAds : 广告1
     * detailCreatePeople : 3
     * detailNumber : 100
     * detailActivityTimes : 50
     * detailLevel : 5
     * detailStatus : 1
     * detailIsOpen : 0
     * detailLevelPic : http://333.3.3.3
     * detailTitlePic : http://231.1.1.1
     * detailEwmPic : http://123.3.3.3
     * detailIsToll : 0
     * detailTollMethod : 1
     * detailTollMoney : 500
     * detailLoginName : zhangsan
     * detailMorefield1 : null
     * detailMorefield2 : null
     * detailMorefield3 : null
     * sStartpage : null
     * sPagerows : null
     * joinActivityTotalNum : null
     * detailPid : null
     * detailTime : 2016-04-13 00:00:00
     * detailIsFansteam : 1
     * isApply : null
     * sPersonUserId : null
     * sUserName : null
     * detailTid :
     * lscd : null
     */

    private DataEntity data;

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

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public static class DataEntity {
        private int detailId;
        private int detailTypeId;
        private String detailName;
        private String detailTitle;
        private String detailAds;
        private int detailCreatePeople;
        private int detailNumber;
        private int detailActivityTimes;
        private int detailLevel;
        private int detailStatus;
        private int detailIsOpen;
        private String detailLevelPic;
        private String detailTitlePic;
        private String detailEwmPic;
        private int detailIsToll;
        private int detailTollMethod;
        private int detailTollMoney;
        private String detailLoginName;
        private Object detailMorefield1;
        private Object detailMorefield2;
        private Object detailMorefield3;
        private Object sStartpage;
        private Object sPagerows;
        private Object joinActivityTotalNum;
        private Object detailPid;
        private String detailTime;
        private int detailIsFansteam;
        private Object isApply;
        private Object sPersonUserId;
        private Object sUserName;
        private String detailTid;
        private Object lscd;

        public int getDetailId() {
            return detailId;
        }

        public void setDetailId(int detailId) {
            this.detailId = detailId;
        }

        public int getDetailTypeId() {
            return detailTypeId;
        }

        public void setDetailTypeId(int detailTypeId) {
            this.detailTypeId = detailTypeId;
        }

        public String getDetailName() {
            return detailName;
        }

        public void setDetailName(String detailName) {
            this.detailName = detailName;
        }

        public String getDetailTitle() {
            return detailTitle;
        }

        public void setDetailTitle(String detailTitle) {
            this.detailTitle = detailTitle;
        }

        public String getDetailAds() {
            return detailAds;
        }

        public void setDetailAds(String detailAds) {
            this.detailAds = detailAds;
        }

        public int getDetailCreatePeople() {
            return detailCreatePeople;
        }

        public void setDetailCreatePeople(int detailCreatePeople) {
            this.detailCreatePeople = detailCreatePeople;
        }

        public int getDetailNumber() {
            return detailNumber;
        }

        public void setDetailNumber(int detailNumber) {
            this.detailNumber = detailNumber;
        }

        public int getDetailActivityTimes() {
            return detailActivityTimes;
        }

        public void setDetailActivityTimes(int detailActivityTimes) {
            this.detailActivityTimes = detailActivityTimes;
        }

        public int getDetailLevel() {
            return detailLevel;
        }

        public void setDetailLevel(int detailLevel) {
            this.detailLevel = detailLevel;
        }

        public int getDetailStatus() {
            return detailStatus;
        }

        public void setDetailStatus(int detailStatus) {
            this.detailStatus = detailStatus;
        }

        public int getDetailIsOpen() {
            return detailIsOpen;
        }

        public void setDetailIsOpen(int detailIsOpen) {
            this.detailIsOpen = detailIsOpen;
        }

        public String getDetailLevelPic() {
            return detailLevelPic;
        }

        public void setDetailLevelPic(String detailLevelPic) {
            this.detailLevelPic = detailLevelPic;
        }

        public String getDetailTitlePic() {
            return detailTitlePic;
        }

        public void setDetailTitlePic(String detailTitlePic) {
            this.detailTitlePic = detailTitlePic;
        }

        public String getDetailEwmPic() {
            return detailEwmPic;
        }

        public void setDetailEwmPic(String detailEwmPic) {
            this.detailEwmPic = detailEwmPic;
        }

        public int getDetailIsToll() {
            return detailIsToll;
        }

        public void setDetailIsToll(int detailIsToll) {
            this.detailIsToll = detailIsToll;
        }

        public int getDetailTollMethod() {
            return detailTollMethod;
        }

        public void setDetailTollMethod(int detailTollMethod) {
            this.detailTollMethod = detailTollMethod;
        }

        public int getDetailTollMoney() {
            return detailTollMoney;
        }

        public void setDetailTollMoney(int detailTollMoney) {
            this.detailTollMoney = detailTollMoney;
        }

        public String getDetailLoginName() {
            return detailLoginName;
        }

        public void setDetailLoginName(String detailLoginName) {
            this.detailLoginName = detailLoginName;
        }

        public Object getDetailMorefield1() {
            return detailMorefield1;
        }

        public void setDetailMorefield1(Object detailMorefield1) {
            this.detailMorefield1 = detailMorefield1;
        }

        public Object getDetailMorefield2() {
            return detailMorefield2;
        }

        public void setDetailMorefield2(Object detailMorefield2) {
            this.detailMorefield2 = detailMorefield2;
        }

        public Object getDetailMorefield3() {
            return detailMorefield3;
        }

        public void setDetailMorefield3(Object detailMorefield3) {
            this.detailMorefield3 = detailMorefield3;
        }

        public Object getSStartpage() {
            return sStartpage;
        }

        public void setSStartpage(Object sStartpage) {
            this.sStartpage = sStartpage;
        }

        public Object getSPagerows() {
            return sPagerows;
        }

        public void setSPagerows(Object sPagerows) {
            this.sPagerows = sPagerows;
        }

        public Object getJoinActivityTotalNum() {
            return joinActivityTotalNum;
        }

        public void setJoinActivityTotalNum(Object joinActivityTotalNum) {
            this.joinActivityTotalNum = joinActivityTotalNum;
        }

        public Object getDetailPid() {
            return detailPid;
        }

        public void setDetailPid(Object detailPid) {
            this.detailPid = detailPid;
        }

        public String getDetailTime() {
            return detailTime;
        }

        public void setDetailTime(String detailTime) {
            this.detailTime = detailTime;
        }

        public int getDetailIsFansteam() {
            return detailIsFansteam;
        }

        public void setDetailIsFansteam(int detailIsFansteam) {
            this.detailIsFansteam = detailIsFansteam;
        }

        public Object getIsApply() {
            return isApply;
        }

        public void setIsApply(Object isApply) {
            this.isApply = isApply;
        }

        public Object getSPersonUserId() {
            return sPersonUserId;
        }

        public void setSPersonUserId(Object sPersonUserId) {
            this.sPersonUserId = sPersonUserId;
        }

        public Object getSUserName() {
            return sUserName;
        }

        public void setSUserName(Object sUserName) {
            this.sUserName = sUserName;
        }

        public String getDetailTid() {
            return detailTid;
        }

        public void setDetailTid(String detailTid) {
            this.detailTid = detailTid;
        }

        public Object getLscd() {
            return lscd;
        }

        public void setLscd(Object lscd) {
            this.lscd = lscd;
        }
    }
}
