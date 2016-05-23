package com.smartcity.http.model;

import com.smartcity.http.model.BaseModel;

import java.util.List;

/**
 * Created by Administrator on 2016/5/7.
 */
public class CircleBean extends BaseModel {

    /**
     * detailId : 5
     * detailTypeId : 1
     * detailName : 圈子2
     * detailTitle : 圈子标题2
     * detailAds : 广告2
     * detailCreatePeople : 3
     * detailNumber : 1020
     * detailActivityTimes : 20
     * detailLevel : 5
     * detailStatus : 1
     * detailIsOpen : 0
     * detailLevelPic : http://333.3.3.3
     * detailTitlePic : http://231.1.1.1
     * detailEwmPic : http://123.3.3.3
     * detailIsToll : 0
     * detailTollMethod : 1
     * detailTollMoney : 50
     * detailLoginName : zhangsan
     * detailMorefield1 : null
     * detailMorefield2 : null
     * detailMorefield3 : null
     * sStartpage : null
     * sPagerows : null
     * joinActivityTotalNum : 160
     * detailPid : null
     * detailPname : null
     * detailTime : 2016-04-13 00:00:00
     * detailIsFansteam : 0
     * isApply : 0
     * sPersonUserId : null
     * sUserName : 李四
     * detailTid :
     * lscd : []
     * pscd : null
     * detailMarkName : null
     */

    private List<CirDataEntity> data;

    public List<CirDataEntity> getData() {
        return data;
    }

    public void setData(List<CirDataEntity> data) {
        this.data = data;
    }

    public static class CirDataEntity {
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
        private String joinActivityTotalNum;
        private Object detailPid;
        private Object detailPname;
        private String detailTime;
        private int detailIsFansteam;
        private int isApply;
        private Object sPersonUserId;
        private String sUserName;
        private String detailTid;
        private Object pscd;
        private Object detailMarkName;
        public List<LscdBean> lscd;

        public CirDataEntity(String detailName, String sUserName, String detailEwmPic) {
            this.detailName = detailName;
            this.sUserName = sUserName;
            this.detailEwmPic = detailEwmPic;
        }

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

        public String getJoinActivityTotalNum() {
            return joinActivityTotalNum;
        }

        public void setJoinActivityTotalNum(String joinActivityTotalNum) {
            this.joinActivityTotalNum = joinActivityTotalNum;
        }

        public Object getDetailPid() {
            return detailPid;
        }

        public void setDetailPid(Object detailPid) {
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

        public int getIsApply() {
            return isApply;
        }

        public void setIsApply(int isApply) {
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

        public Object getDetailMarkName() {
            return detailMarkName;
        }

        public void setDetailMarkName(Object detailMarkName) {
            this.detailMarkName = detailMarkName;
        }

        public List<LscdBean> getLscd() {
            return lscd;
        }

        public void setLscd(List<LscdBean> lscd) {
            this.lscd = lscd;
        }
        public static class LscdBean {
            private Object detailId;
            private Object detailTypeId;
            private String detailName;
            private String detailTitle;
            private Object detailAds;
            private Object detailCreatePeople;
            private int detailNumber;
            private Object detailActivityTimes;
            private Object detailLevel;
            private Object detailStatus;
            private Object detailIsOpen;
            private Object detailLevelPic;
            private String detailTitlePic;
            private Object detailEwmPic;
            private Object detailIsToll;
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
            private Object detailTime;
            private Object detailIsFansteam;
            private Object isApply;
            private Object sPersonUserId;
            private Object sUserName;
            private Object detailTid;
            private Object lscd;
            private Object pscd;
            private Object detailMarkName;
            private Object detailIsTemp;

            public Object getDetailId() {
                return detailId;
            }

            public void setDetailId(Object detailId) {
                this.detailId = detailId;
            }

            public Object getDetailTypeId() {
                return detailTypeId;
            }

            public void setDetailTypeId(Object detailTypeId) {
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

            public Object getDetailCreatePeople() {
                return detailCreatePeople;
            }

            public void setDetailCreatePeople(Object detailCreatePeople) {
                this.detailCreatePeople = detailCreatePeople;
            }

            public int getDetailNumber() {
                return detailNumber;
            }

            public void setDetailNumber(int detailNumber) {
                this.detailNumber = detailNumber;
            }

            public Object getDetailActivityTimes() {
                return detailActivityTimes;
            }

            public void setDetailActivityTimes(Object detailActivityTimes) {
                this.detailActivityTimes = detailActivityTimes;
            }

            public Object getDetailLevel() {
                return detailLevel;
            }

            public void setDetailLevel(Object detailLevel) {
                this.detailLevel = detailLevel;
            }

            public Object getDetailStatus() {
                return detailStatus;
            }

            public void setDetailStatus(Object detailStatus) {
                this.detailStatus = detailStatus;
            }

            public Object getDetailIsOpen() {
                return detailIsOpen;
            }

            public void setDetailIsOpen(Object detailIsOpen) {
                this.detailIsOpen = detailIsOpen;
            }

            public Object getDetailLevelPic() {
                return detailLevelPic;
            }

            public void setDetailLevelPic(Object detailLevelPic) {
                this.detailLevelPic = detailLevelPic;
            }

            public String getDetailTitlePic() {
                return detailTitlePic;
            }

            public void setDetailTitlePic(String detailTitlePic) {
                this.detailTitlePic = detailTitlePic;
            }

            public Object getDetailEwmPic() {
                return detailEwmPic;
            }

            public void setDetailEwmPic(Object detailEwmPic) {
                this.detailEwmPic = detailEwmPic;
            }

            public Object getDetailIsToll() {
                return detailIsToll;
            }

            public void setDetailIsToll(Object detailIsToll) {
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

            public Object getDetailTime() {
                return detailTime;
            }

            public void setDetailTime(Object detailTime) {
                this.detailTime = detailTime;
            }

            public Object getDetailIsFansteam() {
                return detailIsFansteam;
            }

            public void setDetailIsFansteam(Object detailIsFansteam) {
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

            public Object getDetailTid() {
                return detailTid;
            }

            public void setDetailTid(Object detailTid) {
                this.detailTid = detailTid;
            }

            public Object getLscd() {
                return lscd;
            }

            public void setLscd(Object lscd) {
                this.lscd = lscd;
            }

            public Object getPscd() {
                return pscd;
            }

            public void setPscd(Object pscd) {
                this.pscd = pscd;
            }

            public Object getDetailMarkName() {
                return detailMarkName;
            }

            public void setDetailMarkName(Object detailMarkName) {
                this.detailMarkName = detailMarkName;
            }

            public Object getDetailIsTemp() {
                return detailIsTemp;
            }

            public void setDetailIsTemp(Object detailIsTemp) {
                this.detailIsTemp = detailIsTemp;
            }
        }
    }
}
