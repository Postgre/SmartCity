package com.smartcity.http.model;

import java.util.List;

/** 
 * @ClassName: ShopCartVo 
 * @Description: 购物车
 * @author Yancy
 * @date 2016年5月14日 下午3:11:02  
 */
public class ScShopCartVo {
	private static final long serialVersionUID = 5661922855819882479L;

	private boolean choosed;

	private boolean isEdite;

	private int shopId;
	private String shopName;
	private List<ScShopCartGoodsDetail> goodsList;

	public int getShopId() {
		return shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public List<ScShopCartGoodsDetail> getGoodsList() {
		return goodsList;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public void setGoodsList(List<ScShopCartGoodsDetail> goodsList) {
		this.goodsList = goodsList;
	}


	public boolean isChoosed() {
		return choosed;
	}

	public boolean isEdite() {
		return isEdite;
	}

	public void setChoosed(boolean choosed) {
		this.choosed = choosed;
	}

	public void setEdite(boolean edite) {
		isEdite = edite;
	}

	@Override
	public String toString() {
		return "ScShopCartVo{" +
				"shopId=" + shopId +
				", shopName='" + shopName + '\'' +
				", goodsList=" + goodsList +
				'}';
	}
}


