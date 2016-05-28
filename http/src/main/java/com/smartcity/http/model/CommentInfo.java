package com.smartcity.http.model;

import java.io.Serializable;

/**
 * 在此写类用途
 *
 * @version V2.0
 * @FileName: CommentInfo.java
 * @author: fengliang
 * @date: 2016-05-13 10:56
 */
public class CommentInfo implements Serializable {


    /**
     * sId : 9c1d056f10854a958da93349abf60111
     * sType : 2
     * sActivityId : null
     * sCircleId : null
     * sCoolId : 36
     * sShareId : null
     * sVideoAlbumId : null
     * sUserId : 60
     * sUserCode : admin
     * sCommentDate : 2016-05-28 15:50:33
     * sCommentNumber : null
     * sCommentTitle : NB
     * sCommentContent : åååååååååååååååååååå
     * sLikeDate : 2016-05-28 15:50:33
     * sIsLike : 1
     * sLikeCount : null
     * sImgNameList : null
     * sMemberImgName : null
     * commentSum : 0
     * lsccr : null
     * sCurrUserId : null
     * pagination : null
     */

    private String sId;
    private String sType;
    private Object sActivityId;
    private Object sCircleId;
    private String sCoolId;
    private Object sShareId;
    private Object sVideoAlbumId;
    private String sUserId;
    private String sUserCode;
    private String sCommentDate;
    private Object sCommentNumber;
    private String sCommentTitle;
    private String sCommentContent;
    private String sLikeDate;
    private String sIsLike;
    private int sLikeCount;
    private Object sImgNameList;
    private Object sMemberImgName;
    private int commentSum;
    private Object lsccr;
    private Object sCurrUserId;
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

    public String getSCoolId() {
        return sCoolId;
    }

    public void setSCoolId(String sCoolId) {
        this.sCoolId = sCoolId;
    }

    public Object getSShareId() {
        return sShareId;
    }

    public void setSShareId(Object sShareId) {
        this.sShareId = sShareId;
    }

    public Object getSVideoAlbumId() {
        return sVideoAlbumId;
    }

    public void setSVideoAlbumId(Object sVideoAlbumId) {
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

    public int getsLikeCount() {
        return sLikeCount;
    }

    public void setsLikeCount(int sLikeCount) {
        this.sLikeCount = sLikeCount;
    }

    public Object getSImgNameList() {
        return sImgNameList;
    }

    public void setSImgNameList(Object sImgNameList) {
        this.sImgNameList = sImgNameList;
    }

    public Object getSMemberImgName() {
        return sMemberImgName;
    }

    public void setSMemberImgName(Object sMemberImgName) {
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

    public Object getSCurrUserId() {
        return sCurrUserId;
    }

    public void setSCurrUserId(Object sCurrUserId) {
        this.sCurrUserId = sCurrUserId;
    }

    public Object getPagination() {
        return pagination;
    }

    public void setPagination(Object pagination) {
        this.pagination = pagination;
    }
}
