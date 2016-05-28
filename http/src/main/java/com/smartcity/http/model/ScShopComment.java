
package com.smartcity.http.model;

import java.util.List;

/** 
 * @ClassName: ScShopComment 
 * @Description: 店铺评论
 * @author yancy
 * @date 2016年4月12日 下午7:12:30  
 */
public class ScShopComment extends BaseModel {


	private List<ScShopCommentList> data;



	public static class ScShopCommentList
	{
		private String id;// 主键
		private String type;//评论类型，0-商品，1-店铺
		private String shopId;//评论的店铺ID
		private String goodsId;//评论的商品ID
		private String userId;// 用户id
		private String userCode;// 用户名
		private String commentDate;// 评论时间
		private Double score;// 评论分数
		private Double scoreDesc;// 描述评论分数
		private Double scoreService;// 服务评论分数
		private Double scoreDelivery;// 物流评论分数
		private String commentTitle;// 评论标题
		private String commentContent;// 内容
		private List<String> imgNameList; // 评论图片名称
		private String memberImgName;// 用户图像
		private String orederNo;//订单编号   主要是用来添加评论
//	private long commentSum;// 这一商品的评论总数


		public void setOrederNo(String orederNo) {
			this.orederNo = orederNo;
		}

		public String getOrederNo() {
			return orederNo;
		}

		public String getId() {
			return id;
		}

		public String getType() {
			return type;
		}

		public String getShopId() {
			return shopId;
		}

		public String getGoodsId() {
			return goodsId;
		}

		public String getUserId() {
			return userId;
		}

		public String getUserCode() {
			return userCode;
		}

		public String getCommentDate() {
			return commentDate;
		}

		public Double getScore() {
			return score;
		}

		public Double getScoreDesc() {
			return scoreDesc;
		}

		public Double getScoreService() {
			return scoreService;
		}

		public Double getScoreDelivery() {
			return scoreDelivery;
		}

		public String getCommentTitle() {
			return commentTitle;
		}

		public String getCommentContent() {
			return commentContent;
		}

		public List<String> getImgNameList() {
			return imgNameList;
		}

		public String getMemberImgName() {
			return memberImgName;
		}

		public void setId(String id) {
			this.id = id;
		}

		public void setType(String type) {
			this.type = type;
		}

		public void setShopId(String shopId) {
			this.shopId = shopId;
		}

		public void setGoodsId(String goodsId) {
			this.goodsId = goodsId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public void setUserCode(String userCode) {
			this.userCode = userCode;
		}

		public void setCommentDate(String commentDate) {
			this.commentDate = commentDate;
		}

		public void setScore(Double score) {
			this.score = score;
		}

		public void setScoreDesc(Double scoreDesc) {
			this.scoreDesc = scoreDesc;
		}

		public void setScoreService(Double scoreService) {
			this.scoreService = scoreService;
		}

		public void setScoreDelivery(Double scoreDelivery) {
			this.scoreDelivery = scoreDelivery;
		}

		public void setCommentTitle(String commentTitle) {
			this.commentTitle = commentTitle;
		}

		public void setCommentContent(String commentContent) {
			this.commentContent = commentContent;
		}

		public void setImgNameList(List<String> imgNameList) {
			this.imgNameList = imgNameList;
		}

		public void setMemberImgName(String memberImgName) {
			this.memberImgName = memberImgName;
		}

		@Override
		public String toString() {
			return "ScShopCommentList{" +
					"id='" + id + '\'' +
					", type='" + type + '\'' +
					", shopId='" + shopId + '\'' +
					", goodsId='" + goodsId + '\'' +
					", userId='" + userId + '\'' +
					", userCode='" + userCode + '\'' +
					", commentDate='" + commentDate + '\'' +
					", score=" + score +
					", scoreDesc=" + scoreDesc +
					", scoreService=" + scoreService +
					", scoreDelivery=" + scoreDelivery +
					", commentTitle='" + commentTitle + '\'' +
					", commentContent='" + commentContent + '\'' +
					", imgNameList=" + imgNameList +
					", memberImgName='" + memberImgName + '\'' +
					'}';
		}
	}

	public List<ScShopCommentList> getData() {
		return data;
	}

	public void setData(List<ScShopCommentList> data) {
		this.data = data;
	}
}
