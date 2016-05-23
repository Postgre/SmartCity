package com.smartcity.http.model;

import java.util.List;

/**
 * Created by Administrator on 2016/5/18.
 */
public class CircleVideo {

    /**
     * total : 1
     * code : 1
     * msg : null
     * data : [{"videoAlbumId":1,"videoAlbumCircleId":4,"videoAlbumUploadId":null,"videoAlbumType":0,"videoAlbumTypeName":"视频1","videoAlbumUrl":"http://125.1.1.1/1.mp4","videoAlbumDescription":"视频描述1","videoAlbumRemark":null,"videoAlbumTimes":1,"videoAlbumMorefield1":null,"videoAlbumMorefield2":null,"videoAlbumMorefield3":null,"sStartpage":null,"sPagerows":null,"sIds":null,"sAlbPicNum":null,"videoAlbumCoverUrl":"http://122.2.2.2/2.png","videoAlbumUserId":60,"scSysUser":{"id":null,"usercode":null,"username":null,"password":null,"userpic":"http://tsnrhapp.oss-cn-hangzhou.aliyuncs.com/sysImg/01.jpg","usersex":null,"userbirth":null,"residence":null,"signature":null,"salt":null,"locked":null,"isdel":null,"ismerchant":null,"isadmin":null,"createtime":null,"createtimeStart":null,"createtimeEnd":null,"lasttime":null,"lasttimeStart":null,"lasttimeEnd":null,"operation":null,"version":null,"remark":null}}]
     */

    private int total;
    private int code;
    private Object msg;
    /**
     * videoAlbumId : 1
     * videoAlbumCircleId : 4
     * videoAlbumUploadId : null
     * videoAlbumType : 0
     * videoAlbumTypeName : 视频1
     * videoAlbumUrl : http://125.1.1.1/1.mp4
     * videoAlbumDescription : 视频描述1
     * videoAlbumRemark : null
     * videoAlbumTimes : 1
     * videoAlbumMorefield1 : null
     * videoAlbumMorefield2 : null
     * videoAlbumMorefield3 : null
     * sStartpage : null
     * sPagerows : null
     * sIds : null
     * sAlbPicNum : null
     * videoAlbumCoverUrl : http://122.2.2.2/2.png
     * videoAlbumUserId : 60
     * scSysUser : {"id":null,"usercode":null,"username":null,"password":null,"userpic":"http://tsnrhapp.oss-cn-hangzhou.aliyuncs.com/sysImg/01.jpg","usersex":null,"userbirth":null,"residence":null,"signature":null,"salt":null,"locked":null,"isdel":null,"ismerchant":null,"isadmin":null,"createtime":null,"createtimeStart":null,"createtimeEnd":null,"lasttime":null,"lasttimeStart":null,"lasttimeEnd":null,"operation":null,"version":null,"remark":null}
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

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private int videoAlbumId;
        private int videoAlbumCircleId;
        private Object videoAlbumUploadId;
        private int videoAlbumType;
        private String videoAlbumTypeName;
        private String videoAlbumUrl;
        private String videoAlbumDescription;
        private Object videoAlbumRemark;
        private int videoAlbumTimes;
        private Object videoAlbumMorefield1;
        private Object videoAlbumMorefield2;
        private Object videoAlbumMorefield3;
        private Object sStartpage;
        private Object sPagerows;
        private Object sIds;
        private Object sAlbPicNum;
        private String videoAlbumCoverUrl;
        private int videoAlbumUserId;
        /**
         * id : null
         * usercode : null
         * username : null
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

        private ScSysUserBean scSysUser;

        public int getVideoAlbumId() {
            return videoAlbumId;
        }

        public void setVideoAlbumId(int videoAlbumId) {
            this.videoAlbumId = videoAlbumId;
        }

        public int getVideoAlbumCircleId() {
            return videoAlbumCircleId;
        }

        public void setVideoAlbumCircleId(int videoAlbumCircleId) {
            this.videoAlbumCircleId = videoAlbumCircleId;
        }

        public Object getVideoAlbumUploadId() {
            return videoAlbumUploadId;
        }

        public void setVideoAlbumUploadId(Object videoAlbumUploadId) {
            this.videoAlbumUploadId = videoAlbumUploadId;
        }

        public int getVideoAlbumType() {
            return videoAlbumType;
        }

        public void setVideoAlbumType(int videoAlbumType) {
            this.videoAlbumType = videoAlbumType;
        }

        public String getVideoAlbumTypeName() {
            return videoAlbumTypeName;
        }

        public void setVideoAlbumTypeName(String videoAlbumTypeName) {
            this.videoAlbumTypeName = videoAlbumTypeName;
        }

        public String getVideoAlbumUrl() {
            return videoAlbumUrl;
        }

        public void setVideoAlbumUrl(String videoAlbumUrl) {
            this.videoAlbumUrl = videoAlbumUrl;
        }

        public String getVideoAlbumDescription() {
            return videoAlbumDescription;
        }

        public void setVideoAlbumDescription(String videoAlbumDescription) {
            this.videoAlbumDescription = videoAlbumDescription;
        }

        public Object getVideoAlbumRemark() {
            return videoAlbumRemark;
        }

        public void setVideoAlbumRemark(Object videoAlbumRemark) {
            this.videoAlbumRemark = videoAlbumRemark;
        }

        public int getVideoAlbumTimes() {
            return videoAlbumTimes;
        }

        public void setVideoAlbumTimes(int videoAlbumTimes) {
            this.videoAlbumTimes = videoAlbumTimes;
        }

        public Object getVideoAlbumMorefield1() {
            return videoAlbumMorefield1;
        }

        public void setVideoAlbumMorefield1(Object videoAlbumMorefield1) {
            this.videoAlbumMorefield1 = videoAlbumMorefield1;
        }

        public Object getVideoAlbumMorefield2() {
            return videoAlbumMorefield2;
        }

        public void setVideoAlbumMorefield2(Object videoAlbumMorefield2) {
            this.videoAlbumMorefield2 = videoAlbumMorefield2;
        }

        public Object getVideoAlbumMorefield3() {
            return videoAlbumMorefield3;
        }

        public void setVideoAlbumMorefield3(Object videoAlbumMorefield3) {
            this.videoAlbumMorefield3 = videoAlbumMorefield3;
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

        public Object getSAlbPicNum() {
            return sAlbPicNum;
        }

        public void setSAlbPicNum(Object sAlbPicNum) {
            this.sAlbPicNum = sAlbPicNum;
        }

        public String getVideoAlbumCoverUrl() {
            return videoAlbumCoverUrl;
        }

        public void setVideoAlbumCoverUrl(String videoAlbumCoverUrl) {
            this.videoAlbumCoverUrl = videoAlbumCoverUrl;
        }

        public int getVideoAlbumUserId() {
            return videoAlbumUserId;
        }

        public void setVideoAlbumUserId(int videoAlbumUserId) {
            this.videoAlbumUserId = videoAlbumUserId;
        }

        public ScSysUserBean getScSysUser() {
            return scSysUser;
        }

        public void setScSysUser(ScSysUserBean scSysUser) {
            this.scSysUser = scSysUser;
        }

        public static class ScSysUserBean {
            private Object id;
            private Object usercode;
            private Object username;
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

            public Object getId() {
                return id;
            }

            public void setId(Object id) {
                this.id = id;
            }

            public Object getUsercode() {
                return usercode;
            }

            public void setUsercode(Object usercode) {
                this.usercode = usercode;
            }

            public Object getUsername() {
                return username;
            }

            public void setUsername(Object username) {
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
    }
}
