package com.smartcity.http.model;

import java.util.List;

/**
 * Created by Administrator on 2016/4/23.
 */
public class ActivityModel extends BaseModel {

    /**
     * detailId : 25
     * detailCircleId : 2
     * detailUserId : 3
     * detailUserPhone : 13355555555
     * detailUserReward : 50
     * detailJoinMoney : 10
     * detailBudget : 500
     * detailPlace : nanjing
     * detailAssistPerson : wuwang,liliu
     * detailAppliedPersonNumber : 80
     * detailRealJoinNumber : 60
     * detailMinTotal : 50
     * detailMaxTotal : 100
     * detailName : 这个活动66
     * detailDetail : secret
     * detailProcess : secret
     * detailTypeId : 13
     * detailAim : 超越极限1
     * detailStatus : 2
     * detailQualification : null
     * detailIsPrivate : 1
     * detailIsBossPay : 1
     * detailUserIdOrMerchantId : 4
     * detailAds : ads111
     * detailPicUrl : http://123.1.1.1
     * detailPublishTime : 2016-04-12 00:00:00
     * detailCutOffTime : 2016-04-12 00:00:00
     * detailBeginTime : 2016-04-12 00:00:00
     * detailEndTime : 2016-04-12 00:00:00
     * detailMorefield1 : null
     * detailMorefield2 : null
     * detailMorefield3 : null
     * sStartpage : null
     * sPagerows : null
     * sIds : null
     * sTotalApplyNumber : 0
     * sTotalCollectNumber : 0
     * detailDeposit : 5000
     * detailIsMerchantSupport : 0
     * lsca : []
     * scSysUser : null
     * sHavePublicActivity : null
     * sSuccessActivity : null
     * sBossPayActivity : null
     * sOrderBy : null
     * detailSettlementStatus : null
     * detailMarkName : null
     * sPbgtime : null
     * sPedtime : null
     * sDetailMerchantNo : null
     * sSunOrderTimes : null
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
        private int detailCircleId;
        private int detailUserId;
        private String detailUserPhone;
        private int detailUserReward;
        private int detailJoinMoney;
        private int detailBudget;
        private String detailPlace;
        private String detailAssistPerson;
        private int detailAppliedPersonNumber;
        private int detailRealJoinNumber;
        private int detailMinTotal;
        private int detailMaxTotal;
        private String detailName;
        private String detailDetail;
        private String detailProcess;
        private int detailTypeId;
        private String detailAim;
        private int detailStatus;
        private Object detailQualification;
        private int detailIsPrivate;
        private int detailIsBossPay;
        private int detailUserIdOrMerchantId;
        private String detailAds;
        private String detailPicUrl;
        private String detailPublishTime;
        private String detailCutOffTime;
        private String detailBeginTime;
        private String detailEndTime;
        private Object detailMorefield1;
        private Object detailMorefield2;
        private Object detailMorefield3;
        private Object sStartpage;
        private Object sPagerows;
        private Object sIds;
        private String sTotalApplyNumber;
        private String sTotalCollectNumber;
        private int detailDeposit;
        private int detailIsMerchantSupport;
        private Object scSysUser;
        private Object sHavePublicActivity;
        private Object sSuccessActivity;
        private Object sBossPayActivity;
        private Object sOrderBy;
        private Object detailSettlementStatus;
        private Object detailMarkName;
        private Object sPbgtime;
        private Object sPedtime;
        private Object sDetailMerchantNo;
        private Object sSunOrderTimes;
        private List<?> lsca;

        public int getDetailId() {
            return detailId;
        }

        public void setDetailId(int detailId) {
            this.detailId = detailId;
        }

        public int getDetailCircleId() {
            return detailCircleId;
        }

        public void setDetailCircleId(int detailCircleId) {
            this.detailCircleId = detailCircleId;
        }

        public int getDetailUserId() {
            return detailUserId;
        }

        public void setDetailUserId(int detailUserId) {
            this.detailUserId = detailUserId;
        }

        public String getDetailUserPhone() {
            return detailUserPhone;
        }

        public void setDetailUserPhone(String detailUserPhone) {
            this.detailUserPhone = detailUserPhone;
        }

        public int getDetailUserReward() {
            return detailUserReward;
        }

        public void setDetailUserReward(int detailUserReward) {
            this.detailUserReward = detailUserReward;
        }

        public int getDetailJoinMoney() {
            return detailJoinMoney;
        }

        public void setDetailJoinMoney(int detailJoinMoney) {
            this.detailJoinMoney = detailJoinMoney;
        }

        public int getDetailBudget() {
            return detailBudget;
        }

        public void setDetailBudget(int detailBudget) {
            this.detailBudget = detailBudget;
        }

        public String getDetailPlace() {
            return detailPlace;
        }

        public void setDetailPlace(String detailPlace) {
            this.detailPlace = detailPlace;
        }

        public String getDetailAssistPerson() {
            return detailAssistPerson;
        }

        public void setDetailAssistPerson(String detailAssistPerson) {
            this.detailAssistPerson = detailAssistPerson;
        }

        public int getDetailAppliedPersonNumber() {
            return detailAppliedPersonNumber;
        }

        public void setDetailAppliedPersonNumber(int detailAppliedPersonNumber) {
            this.detailAppliedPersonNumber = detailAppliedPersonNumber;
        }

        public int getDetailRealJoinNumber() {
            return detailRealJoinNumber;
        }

        public void setDetailRealJoinNumber(int detailRealJoinNumber) {
            this.detailRealJoinNumber = detailRealJoinNumber;
        }

        public int getDetailMinTotal() {
            return detailMinTotal;
        }

        public void setDetailMinTotal(int detailMinTotal) {
            this.detailMinTotal = detailMinTotal;
        }

        public int getDetailMaxTotal() {
            return detailMaxTotal;
        }

        public void setDetailMaxTotal(int detailMaxTotal) {
            this.detailMaxTotal = detailMaxTotal;
        }

        public String getDetailName() {
            return detailName;
        }

        public void setDetailName(String detailName) {
            this.detailName = detailName;
        }

        public String getDetailDetail() {
            return detailDetail;
        }

        public void setDetailDetail(String detailDetail) {
            this.detailDetail = detailDetail;
        }

        public String getDetailProcess() {
            return detailProcess;
        }

        public void setDetailProcess(String detailProcess) {
            this.detailProcess = detailProcess;
        }

        public int getDetailTypeId() {
            return detailTypeId;
        }

        public void setDetailTypeId(int detailTypeId) {
            this.detailTypeId = detailTypeId;
        }

        public String getDetailAim() {
            return detailAim;
        }

        public void setDetailAim(String detailAim) {
            this.detailAim = detailAim;
        }

        public int getDetailStatus() {
            return detailStatus;
        }

        public void setDetailStatus(int detailStatus) {
            this.detailStatus = detailStatus;
        }

        public Object getDetailQualification() {
            return detailQualification;
        }

        public void setDetailQualification(Object detailQualification) {
            this.detailQualification = detailQualification;
        }

        public int getDetailIsPrivate() {
            return detailIsPrivate;
        }

        public void setDetailIsPrivate(int detailIsPrivate) {
            this.detailIsPrivate = detailIsPrivate;
        }

        public int getDetailIsBossPay() {
            return detailIsBossPay;
        }

        public void setDetailIsBossPay(int detailIsBossPay) {
            this.detailIsBossPay = detailIsBossPay;
        }

        public int getDetailUserIdOrMerchantId() {
            return detailUserIdOrMerchantId;
        }

        public void setDetailUserIdOrMerchantId(int detailUserIdOrMerchantId) {
            this.detailUserIdOrMerchantId = detailUserIdOrMerchantId;
        }

        public String getDetailAds() {
            return detailAds;
        }

        public void setDetailAds(String detailAds) {
            this.detailAds = detailAds;
        }

        public String getDetailPicUrl() {
            return detailPicUrl;
        }

        public void setDetailPicUrl(String detailPicUrl) {
            this.detailPicUrl = detailPicUrl;
        }

        public String getDetailPublishTime() {
            return detailPublishTime;
        }

        public void setDetailPublishTime(String detailPublishTime) {
            this.detailPublishTime = detailPublishTime;
        }

        public String getDetailCutOffTime() {
            return detailCutOffTime;
        }

        public void setDetailCutOffTime(String detailCutOffTime) {
            this.detailCutOffTime = detailCutOffTime;
        }

        public String getDetailBeginTime() {
            return detailBeginTime;
        }

        public void setDetailBeginTime(String detailBeginTime) {
            this.detailBeginTime = detailBeginTime;
        }

        public String getDetailEndTime() {
            return detailEndTime;
        }

        public void setDetailEndTime(String detailEndTime) {
            this.detailEndTime = detailEndTime;
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

        public Object getSIds() {
            return sIds;
        }

        public void setSIds(Object sIds) {
            this.sIds = sIds;
        }

        public String getSTotalApplyNumber() {
            return sTotalApplyNumber;
        }

        public void setSTotalApplyNumber(String sTotalApplyNumber) {
            this.sTotalApplyNumber = sTotalApplyNumber;
        }

        public String getSTotalCollectNumber() {
            return sTotalCollectNumber;
        }

        public void setSTotalCollectNumber(String sTotalCollectNumber) {
            this.sTotalCollectNumber = sTotalCollectNumber;
        }

        public int getDetailDeposit() {
            return detailDeposit;
        }

        public void setDetailDeposit(int detailDeposit) {
            this.detailDeposit = detailDeposit;
        }

        public int getDetailIsMerchantSupport() {
            return detailIsMerchantSupport;
        }

        public void setDetailIsMerchantSupport(int detailIsMerchantSupport) {
            this.detailIsMerchantSupport = detailIsMerchantSupport;
        }

        public Object getScSysUser() {
            return scSysUser;
        }

        public void setScSysUser(Object scSysUser) {
            this.scSysUser = scSysUser;
        }

        public Object getSHavePublicActivity() {
            return sHavePublicActivity;
        }

        public void setSHavePublicActivity(Object sHavePublicActivity) {
            this.sHavePublicActivity = sHavePublicActivity;
        }

        public Object getSSuccessActivity() {
            return sSuccessActivity;
        }

        public void setSSuccessActivity(Object sSuccessActivity) {
            this.sSuccessActivity = sSuccessActivity;
        }

        public Object getSBossPayActivity() {
            return sBossPayActivity;
        }

        public void setSBossPayActivity(Object sBossPayActivity) {
            this.sBossPayActivity = sBossPayActivity;
        }

        public Object getSOrderBy() {
            return sOrderBy;
        }

        public void setSOrderBy(Object sOrderBy) {
            this.sOrderBy = sOrderBy;
        }

        public Object getDetailSettlementStatus() {
            return detailSettlementStatus;
        }

        public void setDetailSettlementStatus(Object detailSettlementStatus) {
            this.detailSettlementStatus = detailSettlementStatus;
        }

        public Object getDetailMarkName() {
            return detailMarkName;
        }

        public void setDetailMarkName(Object detailMarkName) {
            this.detailMarkName = detailMarkName;
        }

        public Object getSPbgtime() {
            return sPbgtime;
        }

        public void setSPbgtime(Object sPbgtime) {
            this.sPbgtime = sPbgtime;
        }

        public Object getSPedtime() {
            return sPedtime;
        }

        public void setSPedtime(Object sPedtime) {
            this.sPedtime = sPedtime;
        }

        public Object getSDetailMerchantNo() {
            return sDetailMerchantNo;
        }

        public void setSDetailMerchantNo(Object sDetailMerchantNo) {
            this.sDetailMerchantNo = sDetailMerchantNo;
        }

        public Object getSSunOrderTimes() {
            return sSunOrderTimes;
        }

        public void setSSunOrderTimes(Object sSunOrderTimes) {
            this.sSunOrderTimes = sSunOrderTimes;
        }

        public List<?> getLsca() {
            return lsca;
        }

        public void setLsca(List<?> lsca) {
            this.lsca = lsca;
        }

        @Override
        public String toString() {
            return "DataEntity{" +
                    "detailId=" + detailId +
                    ", detailCircleId=" + detailCircleId +
                    ", detailUserId=" + detailUserId +
                    ", detailUserPhone='" + detailUserPhone + '\'' +
                    ", detailUserReward=" + detailUserReward +
                    ", detailJoinMoney=" + detailJoinMoney +
                    ", detailBudget=" + detailBudget +
                    ", detailPlace='" + detailPlace + '\'' +
                    ", detailAssistPerson='" + detailAssistPerson + '\'' +
                    ", detailAppliedPersonNumber=" + detailAppliedPersonNumber +
                    ", detailRealJoinNumber=" + detailRealJoinNumber +
                    ", detailMinTotal=" + detailMinTotal +
                    ", detailMaxTotal=" + detailMaxTotal +
                    ", detailName='" + detailName + '\'' +
                    ", detailDetail='" + detailDetail + '\'' +
                    ", detailProcess='" + detailProcess + '\'' +
                    ", detailTypeId=" + detailTypeId +
                    ", detailAim='" + detailAim + '\'' +
                    ", detailStatus=" + detailStatus +
                    ", detailQualification=" + detailQualification +
                    ", detailIsPrivate=" + detailIsPrivate +
                    ", detailIsBossPay=" + detailIsBossPay +
                    ", detailUserIdOrMerchantId=" + detailUserIdOrMerchantId +
                    ", detailAds='" + detailAds + '\'' +
                    ", detailPicUrl='" + detailPicUrl + '\'' +
                    ", detailPublishTime='" + detailPublishTime + '\'' +
                    ", detailCutOffTime='" + detailCutOffTime + '\'' +
                    ", detailBeginTime='" + detailBeginTime + '\'' +
                    ", detailEndTime='" + detailEndTime + '\'' +
                    ", detailMorefield1=" + detailMorefield1 +
                    ", detailMorefield2=" + detailMorefield2 +
                    ", detailMorefield3=" + detailMorefield3 +
                    ", sStartpage=" + sStartpage +
                    ", sPagerows=" + sPagerows +
                    ", sIds=" + sIds +
                    ", sTotalApplyNumber='" + sTotalApplyNumber + '\'' +
                    ", sTotalCollectNumber='" + sTotalCollectNumber + '\'' +
                    ", detailDeposit=" + detailDeposit +
                    ", detailIsMerchantSupport=" + detailIsMerchantSupport +
                    ", scSysUser=" + scSysUser +
                    ", sHavePublicActivity=" + sHavePublicActivity +
                    ", sSuccessActivity=" + sSuccessActivity +
                    ", sBossPayActivity=" + sBossPayActivity +
                    ", sOrderBy=" + sOrderBy +
                    ", detailSettlementStatus=" + detailSettlementStatus +
                    ", detailMarkName=" + detailMarkName +
                    ", sPbgtime=" + sPbgtime +
                    ", sPedtime=" + sPedtime +
                    ", sDetailMerchantNo=" + sDetailMerchantNo +
                    ", sSunOrderTimes=" + sSunOrderTimes +
                    ", lsca=" + lsca +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ActivityModel{" +
                "data=" + data +
                '}';
    }
}
