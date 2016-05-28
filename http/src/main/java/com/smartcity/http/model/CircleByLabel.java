package com.smartcity.http.model;

import java.util.List;

/**
 * Created by Administrator on 2016/5/23.
 */
public class CircleByLabel {


    /**
     * total : 1
     * code : 1
     * msg :
     * data : [{"detailId":22,"detailTypeId":6,"detailName":"音乐圈","detailTitle":"圈子标题3","detailAds":null,"detailCreatePeople":56,"detailNumber":1,"detailActivityTimes":0,"detailLevel":null,"detailStatus":1,"detailIsOpen":1,"detailVideoUrl":"","detailTitlePic":"http://882.3.3.3","detailEwmPic":"","detailIsToll":1,"detailTollMethod":null,"detailTollMoney":null,"detailLoginName":null,"detailMorefield1":null,"detailMorefield2":null,"detailMorefield3":null,"sStartpage":null,"sPagerows":null,"joinActivityTotalNum":null,"detailPid":0,"detailPname":null,"detailTime":"2016-05-25 10:17:51","detailIsFansteam":1,"isApply":"","sPersonUserId":null,"sUserName":"Andy","detailTid":"4077134","lscd":[],"pscd":null,"detailMarkName":"音乐","detailIsTemp":1,"detailMerchantNo":"0","detailMerchantId":0}]
     */

    private int total;
    private int code;
    private String msg;
    /**
     * detailId : 22
     * detailTypeId : 6
     * detailName : 音乐圈
     * detailTitle : 圈子标题3
     * detailAds : null
     * detailCreatePeople : 56
     * detailNumber : 1
     * detailActivityTimes : 0
     * detailLevel : null
     * detailStatus : 1
     * detailIsOpen : 1
     * detailVideoUrl :
     * detailTitlePic : http://882.3.3.3
     * detailEwmPic :
     * detailIsToll : 1
     * detailTollMethod : null
     * detailTollMoney : null
     * detailLoginName : null
     * detailMorefield1 : null
     * detailMorefield2 : null
     * detailMorefield3 : null
     * sStartpage : null
     * sPagerows : null
     * joinActivityTotalNum : null
     * detailPid : 0
     * detailPname : null
     * detailTime : 2016-05-25 10:17:51
     * detailIsFansteam : 1
     * isApply :
     * sPersonUserId : null
     * sUserName : Andy
     * detailTid : 4077134
     * lscd : []
     * pscd : null
     * detailMarkName : 音乐
     * detailIsTemp : 1
     * detailMerchantNo : 0
     * detailMerchantId : 0
     */

    private List<DataEntity> data;

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

    public List<DataEntity> getData() {
        return data;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public static class DataEntity {
        private int detailId;
        private int detailTypeId;
        private String detailName;
        private String detailTitle;
        private Object detailAds;
        private int detailCreatePeople;
        private int detailNumber;
        private int detailActivityTimes;
        private Object detailLevel;
        private int detailStatus;
        private int detailIsOpen;
        private String detailVideoUrl;
        private String detailTitlePic;
        private String detailEwmPic;
        private int detailIsToll;
        private Object detailTollMethod;
        private Object detailTollMoney;
        private Object detailLoginName;
        private Object detailMorefield1;
        private Object detailMorefield2;
        private Object detailMorefield3;
        private Object sStartpage;
        private Object sPagerows;
        private Object joinActivityTotalNum;
        private int detailPid;
        private Object detailPname;
        private String detailTime;
        private int detailIsFansteam;
        private String isApply;
        private Object sPersonUserId;
        private String sUserName;
        private String detailTid;
        private Object pscd;
        private String detailMarkName;
        private int detailIsTemp;
        private String detailMerchantNo;
        private int detailMerchantId;
        private List<?> lscd;

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

        public Object getDetailAds() {
            return detailAds;
        }

        public void setDetailAds(Object detailAds) {
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

        public Object getDetailLevel() {
            return detailLevel;
        }

        public void setDetailLevel(Object detailLevel) {
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

        public String getDetailVideoUrl() {
            return detailVideoUrl;
        }

        public void setDetailVideoUrl(String detailVideoUrl) {
            this.detailVideoUrl = detailVideoUrl;
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

        public Object getDetailTollMethod() {
            return detailTollMethod;
        }

        public void setDetailTollMethod(Object detailTollMethod) {
            this.detailTollMethod = detailTollMethod;
        }

        public Object getDetailTollMoney() {
            return detailTollMoney;
        }

        public void setDetailTollMoney(Object detailTollMoney) {
            this.detailTollMoney = detailTollMoney;
        }

        public Object getDetailLoginName() {
            return detailLoginName;
        }

        public void setDetailLoginName(Object detailLoginName) {
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

        public int getDetailPid() {
            return detailPid;
        }

        public void setDetailPid(int detailPid) {
            this.detailPid = detailPid;
        }

        public Object getDetailPname() {
            return detailPname;
        }

        public void setDetailPname(Object detailPname) {
            this.detailPname = detailPname;
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

        public String getIsApply() {
            return isApply;
        }

        public void setIsApply(String isApply) {
            this.isApply = isApply;
        }

        public Object getSPersonUserId() {
            return sPersonUserId;
        }

        public void setSPersonUserId(Object sPersonUserId) {
            this.sPersonUserId = sPersonUserId;
        }

        public String getSUserName() {
            return sUserName;
        }

        public void setSUserName(String sUserName) {
            this.sUserName = sUserName;
        }

        public String getDetailTid() {
            return detailTid;
        }

        public void setDetailTid(String detailTid) {
            this.detailTid = detailTid;
        }

        public Object getPscd() {
            return pscd;
        }

        public void setPscd(Object pscd) {
            this.pscd = pscd;
        }

        public String getDetailMarkName() {
            return detailMarkName;
        }

        public void setDetailMarkName(String detailMarkName) {
            this.detailMarkName = detailMarkName;
        }

        public int getDetailIsTemp() {
            return detailIsTemp;
        }

        public void setDetailIsTemp(int detailIsTemp) {
            this.detailIsTemp = detailIsTemp;
        }

        public String getDetailMerchantNo() {
            return detailMerchantNo;
        }

        public void setDetailMerchantNo(String detailMerchantNo) {
            this.detailMerchantNo = detailMerchantNo;
        }

        public int getDetailMerchantId() {
            return detailMerchantId;
        }

        public void setDetailMerchantId(int detailMerchantId) {
            this.detailMerchantId = detailMerchantId;
        }

        public List<?> getLscd() {
            return lscd;
        }

        public void setLscd(List<?> lscd) {
            this.lscd = lscd;
        }
    }
}
