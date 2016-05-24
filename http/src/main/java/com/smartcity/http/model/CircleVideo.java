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

        private MPlmapBean mPlmap;
        private ScSysUserBean scSysUser;
        public MPlmapBean getMPlmap() {
            return mPlmap;
        }

        public void setMPlmap(MPlmapBean mPlmap) {
            this.mPlmap = mPlmap;
        }
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
        public static class MPlmapBean {
            private int totalCount;
            private int totalLikeCount;
            /**
             * sId : ad712fdc578e490aab8136bace601b14
             * sType : 4
             * sActivityId : null
             * sCircleId : null
             * sCoolId : null
             * sShareId : null
             * sVideoAlbumId : 1
             * sUserId : 56
             * sUserCode : 1
             * sCommentDate : 2016-05-20 10:23:40
             * sCommentNumber : null
             * sCommentTitle : 标题1
             * sCommentContent : 评论内容110
             * sLikeDate : 2016-05-20 10:23:40
             * sIsLike : 0
             * sLikeCount : null
             * sImgNameList : null
             * sMemberImgName : http://zxcity.com/111.jpg
             * commentSum : 0
             * lsccr : null
             * pagination : null
             */

            private List<HotCommentListBean> hotCommentList;
            /**
             * sId : 71999bf5b2324c3f9d0f0f74cb956deb
             * sType : 4
             * sActivityId : null
             * sCircleId : null
             * sCoolId : null
             * sShareId : null
             * sVideoAlbumId : 1
             * sUserId : 56
             * sUserCode : abc
             * sCommentDate : 2016-05-24 14:12:01
             * sCommentNumber : null
             * sCommentTitle : 标题1
             * sCommentContent : 评论内容10
             * sLikeDate : 2016-05-24 14:12:01
             * sIsLike : 0
             * sLikeCount : null
             * sImgNameList : null
             * sMemberImgName : http://zxcity.com/111.jpg
             * commentSum : 0
             * lsccr : null
             * pagination : null
             */

            private List<NewestCommentListBean> newestCommentList;
            /**
             * sId : ad712fdc578e490aab8136bace601b14
             * sType : 4
             * sActivityId : null
             * sCircleId : null
             * sCoolId : null
             * sShareId : null
             * sVideoAlbumId : 1
             * sUserId : 56
             * sUserCode : 1
             * sCommentDate : 2016-05-20 10:23:40
             * sCommentNumber : null
             * sCommentTitle : 标题1
             * sCommentContent : 评论内容110
             * sLikeDate : 2016-05-20 10:23:40
             * sIsLike : 0
             * sLikeCount : null
             * sImgNameList : null
             * sMemberImgName : http://zxcity.com/111.jpg
             * commentSum : 0
             * lsccr : null
             * pagination : null
             */

            private List<CommentListBean> commentList;

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

            public List<HotCommentListBean> getHotCommentList() {
                return hotCommentList;
            }

            public void setHotCommentList(List<HotCommentListBean> hotCommentList) {
                this.hotCommentList = hotCommentList;
            }

            public List<NewestCommentListBean> getNewestCommentList() {
                return newestCommentList;
            }

            public void setNewestCommentList(List<NewestCommentListBean> newestCommentList) {
                this.newestCommentList = newestCommentList;
            }

            public List<CommentListBean> getCommentList() {
                return commentList;
            }

            public void setCommentList(List<CommentListBean> commentList) {
                this.commentList = commentList;
            }

            public static class HotCommentListBean {
                private String sId;
                private String sType;
                private Object sActivityId;
                private Object sCircleId;
                private Object sCoolId;
                private Object sShareId;
                private String sVideoAlbumId;
                private String sUserId;
                private String sUserCode;
                private String sCommentDate;
                private Object sCommentNumber;
                private String sCommentTitle;
                private String sCommentContent;
                private String sLikeDate;
                private String sIsLike;
                private Object sLikeCount;
                private Object sImgNameList;
                private String sMemberImgName;
                private int commentSum;
                private Object lsccr;
                private Object pagination;

                public String getSId() {
                    return sId;
                }

                public void setSId(String sId) {
                    this.sId = sId;
                }

                public String getSType() {
                    return sType;
                }

                public void setSType(String sType) {
                    this.sType = sType;
                }

                public Object getSActivityId() {
                    return sActivityId;
                }

                public void setSActivityId(Object sActivityId) {
                    this.sActivityId = sActivityId;
                }

                public Object getSCircleId() {
                    return sCircleId;
                }

                public void setSCircleId(Object sCircleId) {
                    this.sCircleId = sCircleId;
                }

                public Object getSCoolId() {
                    return sCoolId;
                }

                public void setSCoolId(Object sCoolId) {
                    this.sCoolId = sCoolId;
                }

                public Object getSShareId() {
                    return sShareId;
                }

                public void setSShareId(Object sShareId) {
                    this.sShareId = sShareId;
                }

                public String getSVideoAlbumId() {
                    return sVideoAlbumId;
                }

                public void setSVideoAlbumId(String sVideoAlbumId) {
                    this.sVideoAlbumId = sVideoAlbumId;
                }

                public String getSUserId() {
                    return sUserId;
                }

                public void setSUserId(String sUserId) {
                    this.sUserId = sUserId;
                }

                public String getSUserCode() {
                    return sUserCode;
                }

                public void setSUserCode(String sUserCode) {
                    this.sUserCode = sUserCode;
                }

                public String getSCommentDate() {
                    return sCommentDate;
                }

                public void setSCommentDate(String sCommentDate) {
                    this.sCommentDate = sCommentDate;
                }

                public Object getSCommentNumber() {
                    return sCommentNumber;
                }

                public void setSCommentNumber(Object sCommentNumber) {
                    this.sCommentNumber = sCommentNumber;
                }

                public String getSCommentTitle() {
                    return sCommentTitle;
                }

                public void setSCommentTitle(String sCommentTitle) {
                    this.sCommentTitle = sCommentTitle;
                }

                public String getSCommentContent() {
                    return sCommentContent;
                }

                public void setSCommentContent(String sCommentContent) {
                    this.sCommentContent = sCommentContent;
                }

                public String getSLikeDate() {
                    return sLikeDate;
                }

                public void setSLikeDate(String sLikeDate) {
                    this.sLikeDate = sLikeDate;
                }

                public String getSIsLike() {
                    return sIsLike;
                }

                public void setSIsLike(String sIsLike) {
                    this.sIsLike = sIsLike;
                }

                public Object getSLikeCount() {
                    return sLikeCount;
                }

                public void setSLikeCount(Object sLikeCount) {
                    this.sLikeCount = sLikeCount;
                }

                public Object getSImgNameList() {
                    return sImgNameList;
                }

                public void setSImgNameList(Object sImgNameList) {
                    this.sImgNameList = sImgNameList;
                }

                public String getSMemberImgName() {
                    return sMemberImgName;
                }

                public void setSMemberImgName(String sMemberImgName) {
                    this.sMemberImgName = sMemberImgName;
                }

                public int getCommentSum() {
                    return commentSum;
                }

                public void setCommentSum(int commentSum) {
                    this.commentSum = commentSum;
                }

                public Object getLsccr() {
                    return lsccr;
                }

                public void setLsccr(Object lsccr) {
                    this.lsccr = lsccr;
                }

                public Object getPagination() {
                    return pagination;
                }

                public void setPagination(Object pagination) {
                    this.pagination = pagination;
                }
            }

            public static class NewestCommentListBean {
                private String sId;
                private String sType;
                private Object sActivityId;
                private Object sCircleId;
                private Object sCoolId;
                private Object sShareId;
                private String sVideoAlbumId;
                private String sUserId;
                private String sUserCode;
                private String sCommentDate;
                private Object sCommentNumber;
                private String sCommentTitle;
                private String sCommentContent;
                private String sLikeDate;
                private String sIsLike;
                private Object sLikeCount;
                private Object sImgNameList;
                private String sMemberImgName;
                private int commentSum;
                private Object lsccr;
                private Object pagination;

                public String getSId() {
                    return sId;
                }

                public void setSId(String sId) {
                    this.sId = sId;
                }

                public String getSType() {
                    return sType;
                }

                public void setSType(String sType) {
                    this.sType = sType;
                }

                public Object getSActivityId() {
                    return sActivityId;
                }

                public void setSActivityId(Object sActivityId) {
                    this.sActivityId = sActivityId;
                }

                public Object getSCircleId() {
                    return sCircleId;
                }

                public void setSCircleId(Object sCircleId) {
                    this.sCircleId = sCircleId;
                }

                public Object getSCoolId() {
                    return sCoolId;
                }

                public void setSCoolId(Object sCoolId) {
                    this.sCoolId = sCoolId;
                }

                public Object getSShareId() {
                    return sShareId;
                }

                public void setSShareId(Object sShareId) {
                    this.sShareId = sShareId;
                }

                public String getSVideoAlbumId() {
                    return sVideoAlbumId;
                }

                public void setSVideoAlbumId(String sVideoAlbumId) {
                    this.sVideoAlbumId = sVideoAlbumId;
                }

                public String getSUserId() {
                    return sUserId;
                }

                public void setSUserId(String sUserId) {
                    this.sUserId = sUserId;
                }

                public String getSUserCode() {
                    return sUserCode;
                }

                public void setSUserCode(String sUserCode) {
                    this.sUserCode = sUserCode;
                }

                public String getSCommentDate() {
                    return sCommentDate;
                }

                public void setSCommentDate(String sCommentDate) {
                    this.sCommentDate = sCommentDate;
                }

                public Object getSCommentNumber() {
                    return sCommentNumber;
                }

                public void setSCommentNumber(Object sCommentNumber) {
                    this.sCommentNumber = sCommentNumber;
                }

                public String getSCommentTitle() {
                    return sCommentTitle;
                }

                public void setSCommentTitle(String sCommentTitle) {
                    this.sCommentTitle = sCommentTitle;
                }

                public String getSCommentContent() {
                    return sCommentContent;
                }

                public void setSCommentContent(String sCommentContent) {
                    this.sCommentContent = sCommentContent;
                }

                public String getSLikeDate() {
                    return sLikeDate;
                }

                public void setSLikeDate(String sLikeDate) {
                    this.sLikeDate = sLikeDate;
                }

                public String getSIsLike() {
                    return sIsLike;
                }

                public void setSIsLike(String sIsLike) {
                    this.sIsLike = sIsLike;
                }

                public Object getSLikeCount() {
                    return sLikeCount;
                }

                public void setSLikeCount(Object sLikeCount) {
                    this.sLikeCount = sLikeCount;
                }

                public Object getSImgNameList() {
                    return sImgNameList;
                }

                public void setSImgNameList(Object sImgNameList) {
                    this.sImgNameList = sImgNameList;
                }

                public String getSMemberImgName() {
                    return sMemberImgName;
                }

                public void setSMemberImgName(String sMemberImgName) {
                    this.sMemberImgName = sMemberImgName;
                }

                public int getCommentSum() {
                    return commentSum;
                }

                public void setCommentSum(int commentSum) {
                    this.commentSum = commentSum;
                }

                public Object getLsccr() {
                    return lsccr;
                }

                public void setLsccr(Object lsccr) {
                    this.lsccr = lsccr;
                }

                public Object getPagination() {
                    return pagination;
                }

                public void setPagination(Object pagination) {
                    this.pagination = pagination;
                }
            }

            public static class CommentListBean {
                private String sId;
                private String sType;
                private Object sActivityId;
                private Object sCircleId;
                private Object sCoolId;
                private Object sShareId;
                private String sVideoAlbumId;
                private String sUserId;
                private String sUserCode;
                private String sCommentDate;
                private Object sCommentNumber;
                private String sCommentTitle;
                private String sCommentContent;
                private String sLikeDate;
                private String sIsLike;
                private Object sLikeCount;
                private Object sImgNameList;
                private String sMemberImgName;
                private int commentSum;
                private Object lsccr;
                private Object pagination;

                public String getSId() {
                    return sId;
                }

                public void setSId(String sId) {
                    this.sId = sId;
                }

                public String getSType() {
                    return sType;
                }

                public void setSType(String sType) {
                    this.sType = sType;
                }

                public Object getSActivityId() {
                    return sActivityId;
                }

                public void setSActivityId(Object sActivityId) {
                    this.sActivityId = sActivityId;
                }

                public Object getSCircleId() {
                    return sCircleId;
                }

                public void setSCircleId(Object sCircleId) {
                    this.sCircleId = sCircleId;
                }

                public Object getSCoolId() {
                    return sCoolId;
                }

                public void setSCoolId(Object sCoolId) {
                    this.sCoolId = sCoolId;
                }

                public Object getSShareId() {
                    return sShareId;
                }

                public void setSShareId(Object sShareId) {
                    this.sShareId = sShareId;
                }

                public String getSVideoAlbumId() {
                    return sVideoAlbumId;
                }

                public void setSVideoAlbumId(String sVideoAlbumId) {
                    this.sVideoAlbumId = sVideoAlbumId;
                }

                public String getSUserId() {
                    return sUserId;
                }

                public void setSUserId(String sUserId) {
                    this.sUserId = sUserId;
                }

                public String getSUserCode() {
                    return sUserCode;
                }

                public void setSUserCode(String sUserCode) {
                    this.sUserCode = sUserCode;
                }

                public String getSCommentDate() {
                    return sCommentDate;
                }

                public void setSCommentDate(String sCommentDate) {
                    this.sCommentDate = sCommentDate;
                }

                public Object getSCommentNumber() {
                    return sCommentNumber;
                }

                public void setSCommentNumber(Object sCommentNumber) {
                    this.sCommentNumber = sCommentNumber;
                }

                public String getSCommentTitle() {
                    return sCommentTitle;
                }

                public void setSCommentTitle(String sCommentTitle) {
                    this.sCommentTitle = sCommentTitle;
                }

                public String getSCommentContent() {
                    return sCommentContent;
                }

                public void setSCommentContent(String sCommentContent) {
                    this.sCommentContent = sCommentContent;
                }

                public String getSLikeDate() {
                    return sLikeDate;
                }

                public void setSLikeDate(String sLikeDate) {
                    this.sLikeDate = sLikeDate;
                }

                public String getSIsLike() {
                    return sIsLike;
                }

                public void setSIsLike(String sIsLike) {
                    this.sIsLike = sIsLike;
                }

                public Object getSLikeCount() {
                    return sLikeCount;
                }

                public void setSLikeCount(Object sLikeCount) {
                    this.sLikeCount = sLikeCount;
                }

                public Object getSImgNameList() {
                    return sImgNameList;
                }

                public void setSImgNameList(Object sImgNameList) {
                    this.sImgNameList = sImgNameList;
                }

                public String getSMemberImgName() {
                    return sMemberImgName;
                }

                public void setSMemberImgName(String sMemberImgName) {
                    this.sMemberImgName = sMemberImgName;
                }

                public int getCommentSum() {
                    return commentSum;
                }

                public void setCommentSum(int commentSum) {
                    this.commentSum = commentSum;
                }

                public Object getLsccr() {
                    return lsccr;
                }

                public void setLsccr(Object lsccr) {
                    this.lsccr = lsccr;
                }

                public Object getPagination() {
                    return pagination;
                }

                public void setPagination(Object pagination) {
                    this.pagination = pagination;
                }
            }
        }
    }
}
