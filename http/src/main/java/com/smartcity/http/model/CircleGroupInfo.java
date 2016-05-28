package com.smartcity.http.model;

import java.util.List;

/**
 * Created by Administrator on 2016/5/26.
 */
public class CircleGroupInfo extends BaseModel {

    /**
     * detailId : 7
     * detailTypeId : 1
     * detailName : 组4
     * detailTitle : 组标题4
     * detailAds : 广告4
     * detailCreatePeople : 4
     * detailNumber : 1020
     * detailActivityTimes : 20
     * detailLevel : 5
     * detailStatus : 1
     * detailIsOpen : 0
     * detailLevelPic : http://oss-cn-hangzhou.aliyuncs.com/tsnrhapp/circle/2457bdd3928549c696c2aabc1e7f317e.png
     * detailTitlePic : http://oss-cn-hangzhou.aliyuncs.com/tsnrhapp/circle/d20ca493c0da4473955e729cd40767bb.png
     * detailEwmPic : http://oss-cn-hangzhou.aliyuncs.com/tsnrhapp/circle/c90a7431bc604bf09d7271665f5edf1f.png
     * detailIsToll : 0
     * detailTollMethod : 1
     * detailTollMoney : 50
     * detailLoginName : zhangsan
     * detailMorefield1 :
     * detailMorefield2 :
     * detailMorefield3 :
     * sStartpage :
     * sPagerows :
     * joinActivityTotalNum :
     * detailPid : 5
     * detailPname :
     * detailTime : 2016-04-13 00:00:00
     * detailIsFansteam : 0
     * isApply :
     * sPersonUserId :
     * sUserName :
     * detailTid :
     * lscd :
     * pscd :
     * detailMarkName : 时尚生活
     * detailIsTemp :
     * detailMerchantNo : 1036
     * detailMerchantId : 10001
     */

    private List<DataEntity> data;

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
        private String detailMorefield1;
        private String detailMorefield2;
        private String detailMorefield3;
        private String sStartpage;
        private String sPagerows;
        private String joinActivityTotalNum;
        private int detailPid;
        private String detailPname;
        private String detailTime;
        private int detailIsFansteam;
        private String isApply;
        private String sPersonUserId;
        private String sUserName;
        private String detailTid;
        private String lscd;
        private String pscd;
        private String detailMarkName;
        private String detailIsTemp;
        private String detailMerchantNo;
        private int detailMerchantId;

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

        public String getDetailMorefield1() {
            return detailMorefield1;
        }

        public void setDetailMorefield1(String detailMorefield1) {
            this.detailMorefield1 = detailMorefield1;
        }

        public String getDetailMorefield2() {
            return detailMorefield2;
        }

        public void setDetailMorefield2(String detailMorefield2) {
            this.detailMorefield2 = detailMorefield2;
        }

        public String getDetailMorefield3() {
            return detailMorefield3;
        }

        public void setDetailMorefield3(String detailMorefield3) {
            this.detailMorefield3 = detailMorefield3;
        }

        public String getSStartpage() {
            return sStartpage;
        }

        public void setSStartpage(String sStartpage) {
            this.sStartpage = sStartpage;
        }

        public String getSPagerows() {
            return sPagerows;
        }

        public void setSPagerows(String sPagerows) {
            this.sPagerows = sPagerows;
        }

        public String getJoinActivityTotalNum() {
            return joinActivityTotalNum;
        }

        public void setJoinActivityTotalNum(String joinActivityTotalNum) {
            this.joinActivityTotalNum = joinActivityTotalNum;
        }

        public int getDetailPid() {
            return detailPid;
        }

        public void setDetailPid(int detailPid) {
            this.detailPid = detailPid;
        }

        public String getDetailPname() {
            return detailPname;
        }

        public void setDetailPname(String detailPname) {
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

        public String getSPersonUserId() {
            return sPersonUserId;
        }

        public void setSPersonUserId(String sPersonUserId) {
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

        public String getLscd() {
            return lscd;
        }

        public void setLscd(String lscd) {
            this.lscd = lscd;
        }

        public String getPscd() {
            return pscd;
        }

        public void setPscd(String pscd) {
            this.pscd = pscd;
        }

        public String getDetailMarkName() {
            return detailMarkName;
        }

        public void setDetailMarkName(String detailMarkName) {
            this.detailMarkName = detailMarkName;
        }

        public String getDetailIsTemp() {
            return detailIsTemp;
        }

        public void setDetailIsTemp(String detailIsTemp) {
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

        @Override
        public String toString() {
            return "DataEntity{" +
                    "detailId=" + detailId +
                    ", detailTypeId=" + detailTypeId +
                    ", detailName='" + detailName + '\'' +
                    ", detailTitle='" + detailTitle + '\'' +
                    ", detailAds='" + detailAds + '\'' +
                    ", detailCreatePeople=" + detailCreatePeople +
                    ", detailNumber=" + detailNumber +
                    ", detailActivityTimes=" + detailActivityTimes +
                    ", detailLevel=" + detailLevel +
                    ", detailStatus=" + detailStatus +
                    ", detailIsOpen=" + detailIsOpen +
                    ", detailLevelPic='" + detailLevelPic + '\'' +
                    ", detailTitlePic='" + detailTitlePic + '\'' +
                    ", detailEwmPic='" + detailEwmPic + '\'' +
                    ", detailIsToll=" + detailIsToll +
                    ", detailTollMethod=" + detailTollMethod +
                    ", detailTollMoney=" + detailTollMoney +
                    ", detailLoginName='" + detailLoginName + '\'' +
                    ", detailMorefield1='" + detailMorefield1 + '\'' +
                    ", detailMorefield2='" + detailMorefield2 + '\'' +
                    ", detailMorefield3='" + detailMorefield3 + '\'' +
                    ", sStartpage='" + sStartpage + '\'' +
                    ", sPagerows='" + sPagerows + '\'' +
                    ", joinActivityTotalNum='" + joinActivityTotalNum + '\'' +
                    ", detailPid=" + detailPid +
                    ", detailPname='" + detailPname + '\'' +
                    ", detailTime='" + detailTime + '\'' +
                    ", detailIsFansteam=" + detailIsFansteam +
                    ", isApply='" + isApply + '\'' +
                    ", sPersonUserId='" + sPersonUserId + '\'' +
                    ", sUserName='" + sUserName + '\'' +
                    ", detailTid='" + detailTid + '\'' +
                    ", lscd='" + lscd + '\'' +
                    ", pscd='" + pscd + '\'' +
                    ", detailMarkName='" + detailMarkName + '\'' +
                    ", detailIsTemp='" + detailIsTemp + '\'' +
                    ", detailMerchantNo='" + detailMerchantNo + '\'' +
                    ", detailMerchantId=" + detailMerchantId +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "CircleGroupInfo{" +
                "data=" + data +
                '}';
    }

}
