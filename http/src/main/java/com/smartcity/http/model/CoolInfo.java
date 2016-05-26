package com.smartcity.http.model;

import java.util.List;

/**
 * 在此写类用途
 *
 * @version V2.0
 * @FileName: CoolInfo.java
 * @author: fengliang
 * @date: 2016-05-04 16:32
 */
public class CoolInfo extends BaseModel {

    /**
     * coolId : 36
     * coolVideoTypeId : 1
     * coolCoverPic : http://tsnrhapp.oss-cn-hangzhou.aliyuncs.com/1464248009050.jpg
     * coolFileAddress : http://tsnrhapp.oss-cn-hangzhou.aliyuncs.com/1464248009356.mp4
     * coolDecrip : hello123456789
     * coolUserId : 60
     * coolPlayTimes : 0
     * coolMarkId : 1
     * coolAreaNo : BJHD
     * coolJwd : 123,321
     * coolRename : æ¹åæ­¦æ±
     * coolMorefield1 : null
     * coolMorefield2 : null
     * coolMorefield3 : null
     * coolTime : 2016-05-26 15:30:22
     * sysUser : {"id":60,"usercode":null,"username":"admin","password":null,"userpic":"http://tsnrhapp.oss-cn-hangzhou.aliyuncs.com/sysImg/01.jpg","usersex":null,"userbirth":null,"residence":null,"signature":null,"salt":null,"locked":null,"isdel":null,"ismerchant":null,"isadmin":null,"createtime":null,"createtimeStart":null,"createtimeEnd":null,"lasttime":null,"lasttimeStart":null,"lasttimeEnd":null,"operation":null,"version":null,"remark":null}
     * sStartpage : null
     * sPagerows : null
     * iIsATed : null
     * iCurrUserId : null
     * mPlmap : {"isClicked":0,"hotCommentList":[],"totalCount":0,"newestCommentList":[],"totalLikeCount":0,"commentList":[]}
     * scua : null
     * coolCoverWidth : null
     * coolCoverHeight : null
     */

    private List<CoolListInfo> data;

    public List<CoolListInfo> getData() {
        return data;
    }

    public void setData(List<CoolListInfo> data) {
        this.data = data;
    }

    public static class CoolListInfo {
        private int coolId;
        private int coolVideoTypeId;
        private String coolCoverPic;
        private String coolFileAddress;
        private String coolDecrip;
        private int coolUserId;
        private int coolPlayTimes;
        private int coolMarkId;
        private String coolAreaNo;
        private String coolJwd;
        private String coolRename;
        private Object coolMorefield1;
        private Object coolMorefield2;
        private Object coolMorefield3;
        private String coolTime;
        /**
         * id : 60
         * usercode : null
         * username : admin
         * password : null
         * userpic : http://tsnrhapp.oss-cn-hangzhou.aliyuncs.com/sysImg/01.jpg
         * usersex : null
         * userbirth : null
         * residence : null
         * signature : null
         * salt : null
         * locked : null
         * isdel : null
         * ismerchant : null
         * isadmin : null
         * createtime : null
         * createtimeStart : null
         * createtimeEnd : null
         * lasttime : null
         * lasttimeStart : null
         * lasttimeEnd : null
         * operation : null
         * version : null
         * remark : null
         */

        private SysUserBean sysUser;
        private Object sStartpage;
        private Object sPagerows;
        private Object iIsATed;
        private Object iCurrUserId;
        /**
         * isClicked : 0
         * hotCommentList : []
         * totalCount : 0
         * newestCommentList : []
         * totalLikeCount : 0
         * commentList : []
         */

        private MPlmapBean mPlmap;
        private Object scua;
        private int coolCoverWidth;
        private int coolCoverHeight;

        public int getCoolId() {
            return coolId;
        }

        public void setCoolId(int coolId) {
            this.coolId = coolId;
        }

        public int getCoolVideoTypeId() {
            return coolVideoTypeId;
        }

        public void setCoolVideoTypeId(int coolVideoTypeId) {
            this.coolVideoTypeId = coolVideoTypeId;
        }

        public String getCoolCoverPic() {
            return coolCoverPic;
        }

        public void setCoolCoverPic(String coolCoverPic) {
            this.coolCoverPic = coolCoverPic;
        }

        public String getCoolFileAddress() {
            return coolFileAddress;
        }

        public void setCoolFileAddress(String coolFileAddress) {
            this.coolFileAddress = coolFileAddress;
        }

        public String getCoolDecrip() {
            return coolDecrip;
        }

        public void setCoolDecrip(String coolDecrip) {
            this.coolDecrip = coolDecrip;
        }

        public int getCoolUserId() {
            return coolUserId;
        }

        public void setCoolUserId(int coolUserId) {
            this.coolUserId = coolUserId;
        }

        public int getCoolPlayTimes() {
            return coolPlayTimes;
        }

        public void setCoolPlayTimes(int coolPlayTimes) {
            this.coolPlayTimes = coolPlayTimes;
        }

        public int getCoolMarkId() {
            return coolMarkId;
        }

        public void setCoolMarkId(int coolMarkId) {
            this.coolMarkId = coolMarkId;
        }

        public String getCoolAreaNo() {
            return coolAreaNo;
        }

        public void setCoolAreaNo(String coolAreaNo) {
            this.coolAreaNo = coolAreaNo;
        }

        public String getCoolJwd() {
            return coolJwd;
        }

        public void setCoolJwd(String coolJwd) {
            this.coolJwd = coolJwd;
        }

        public String getCoolRename() {
            return coolRename;
        }

        public void setCoolRename(String coolRename) {
            this.coolRename = coolRename;
        }

        public Object getCoolMorefield1() {
            return coolMorefield1;
        }

        public void setCoolMorefield1(Object coolMorefield1) {
            this.coolMorefield1 = coolMorefield1;
        }

        public Object getCoolMorefield2() {
            return coolMorefield2;
        }

        public void setCoolMorefield2(Object coolMorefield2) {
            this.coolMorefield2 = coolMorefield2;
        }

        public Object getCoolMorefield3() {
            return coolMorefield3;
        }

        public void setCoolMorefield3(Object coolMorefield3) {
            this.coolMorefield3 = coolMorefield3;
        }

        public String getCoolTime() {
            return coolTime;
        }

        public void setCoolTime(String coolTime) {
            this.coolTime = coolTime;
        }

        public SysUserBean getSysUser() {
            return sysUser;
        }

        public void setSysUser(SysUserBean sysUser) {
            this.sysUser = sysUser;
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

        public Object getIIsATed() {
            return iIsATed;
        }

        public void setIIsATed(Object iIsATed) {
            this.iIsATed = iIsATed;
        }

        public Object getICurrUserId() {
            return iCurrUserId;
        }

        public void setICurrUserId(Object iCurrUserId) {
            this.iCurrUserId = iCurrUserId;
        }

        public MPlmapBean getMPlmap() {
            return mPlmap;
        }

        public void setMPlmap(MPlmapBean mPlmap) {
            this.mPlmap = mPlmap;
        }

        public Object getScua() {
            return scua;
        }

        public void setScua(Object scua) {
            this.scua = scua;
        }

        public int getCoolCoverWidth() {
            return coolCoverWidth;
        }

        public void setCoolCoverWidth(int coolCoverWidth) {
            this.coolCoverWidth = coolCoverWidth;
        }

        public int getCoolCoverHeight() {
            return coolCoverHeight;
        }

        public void setCoolCoverHeight(int coolCoverHeight) {
            this.coolCoverHeight = coolCoverHeight;
        }

        public static class SysUserBean {
            private int id;
            private Object usercode;
            private String username;
            private Object password;
            private String userpic;
            private Object usersex;
            private Object userbirth;
            private Object residence;
            private Object signature;
            private Object salt;
            private Object locked;
            private Object isdel;
            private Object ismerchant;
            private Object isadmin;
            private Object createtime;
            private Object createtimeStart;
            private Object createtimeEnd;
            private Object lasttime;
            private Object lasttimeStart;
            private Object lasttimeEnd;
            private Object operation;
            private Object version;
            private Object remark;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public Object getUsercode() {
                return usercode;
            }

            public void setUsercode(Object usercode) {
                this.usercode = usercode;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public Object getPassword() {
                return password;
            }

            public void setPassword(Object password) {
                this.password = password;
            }

            public String getUserpic() {
                return userpic;
            }

            public void setUserpic(String userpic) {
                this.userpic = userpic;
            }

            public Object getUsersex() {
                return usersex;
            }

            public void setUsersex(Object usersex) {
                this.usersex = usersex;
            }

            public Object getUserbirth() {
                return userbirth;
            }

            public void setUserbirth(Object userbirth) {
                this.userbirth = userbirth;
            }

            public Object getResidence() {
                return residence;
            }

            public void setResidence(Object residence) {
                this.residence = residence;
            }

            public Object getSignature() {
                return signature;
            }

            public void setSignature(Object signature) {
                this.signature = signature;
            }

            public Object getSalt() {
                return salt;
            }

            public void setSalt(Object salt) {
                this.salt = salt;
            }

            public Object getLocked() {
                return locked;
            }

            public void setLocked(Object locked) {
                this.locked = locked;
            }

            public Object getIsdel() {
                return isdel;
            }

            public void setIsdel(Object isdel) {
                this.isdel = isdel;
            }

            public Object getIsmerchant() {
                return ismerchant;
            }

            public void setIsmerchant(Object ismerchant) {
                this.ismerchant = ismerchant;
            }

            public Object getIsadmin() {
                return isadmin;
            }

            public void setIsadmin(Object isadmin) {
                this.isadmin = isadmin;
            }

            public Object getCreatetime() {
                return createtime;
            }

            public void setCreatetime(Object createtime) {
                this.createtime = createtime;
            }

            public Object getCreatetimeStart() {
                return createtimeStart;
            }

            public void setCreatetimeStart(Object createtimeStart) {
                this.createtimeStart = createtimeStart;
            }

            public Object getCreatetimeEnd() {
                return createtimeEnd;
            }

            public void setCreatetimeEnd(Object createtimeEnd) {
                this.createtimeEnd = createtimeEnd;
            }

            public Object getLasttime() {
                return lasttime;
            }

            public void setLasttime(Object lasttime) {
                this.lasttime = lasttime;
            }

            public Object getLasttimeStart() {
                return lasttimeStart;
            }

            public void setLasttimeStart(Object lasttimeStart) {
                this.lasttimeStart = lasttimeStart;
            }

            public Object getLasttimeEnd() {
                return lasttimeEnd;
            }

            public void setLasttimeEnd(Object lasttimeEnd) {
                this.lasttimeEnd = lasttimeEnd;
            }

            public Object getOperation() {
                return operation;
            }

            public void setOperation(Object operation) {
                this.operation = operation;
            }

            public Object getVersion() {
                return version;
            }

            public void setVersion(Object version) {
                this.version = version;
            }

            public Object getRemark() {
                return remark;
            }

            public void setRemark(Object remark) {
                this.remark = remark;
            }
        }

        public static class MPlmapBean {
            private int isClicked;
            private int totalCount;
            private int totalLikeCount;
            private List<?> hotCommentList;
            private List<?> newestCommentList;
            private List<?> commentList;

            public int getIsClicked() {
                return isClicked;
            }

            public void setIsClicked(int isClicked) {
                this.isClicked = isClicked;
            }

            public int getTotalCount() {
                return totalCount;
            }

            public void setTotalCount(int totalCount) {
                this.totalCount = totalCount;
            }

            public int getTotalLikeCount() {
                return totalLikeCount;
            }

            public void setTotalLikeCount(int totalLikeCount) {
                this.totalLikeCount = totalLikeCount;
            }

            public List<?> getHotCommentList() {
                return hotCommentList;
            }

            public void setHotCommentList(List<?> hotCommentList) {
                this.hotCommentList = hotCommentList;
            }

            public List<?> getNewestCommentList() {
                return newestCommentList;
            }

            public void setNewestCommentList(List<?> newestCommentList) {
                this.newestCommentList = newestCommentList;
            }

            public List<?> getCommentList() {
                return commentList;
            }

            public void setCommentList(List<?> commentList) {
                this.commentList = commentList;
            }
        }
    }
}
