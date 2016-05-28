package com.smartcity.http.model;

public class ScShopCartGoodsDetail  {
	private static final long serialVersionUID = 2167743510440605212L;

	private int id;

    private int customerId;

    private int goodsId;

    private String goodsName;
    
    private Double goodsPrice;

    private int number;

    private int stockId;
    
    private String stockName;
    
    private Double stockPrice;

    private int shareCusId;//分享者ID
    
    private String goodsImageUrl;//商品展示图
	private boolean choosed;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public Double getGoodsPrice() {
		return goodsPrice;
	}

	public int getNumber() {
		return number;
	}

	public int getStockId() {
		return stockId;
	}

	public String getStockName() {
		return stockName;
	}

	public Double getStockPrice() {
		return stockPrice;
	}

	public int getShareCusId() {
		return shareCusId;
	}

	public String getGoodsImageUrl() {
		return goodsImageUrl;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public void setStockPrice(Double stockPrice) {
		this.stockPrice = stockPrice;
	}

	public void setShareCusId(int shareCusId) {
		this.shareCusId = shareCusId;
	}

	public void setGoodsImageUrl(String goodsImageUrl) {
		this.goodsImageUrl = goodsImageUrl;
	}

	@Override
	public String toString() {
		return "ScShopCartGoodsDetail{" +
				"id=" + id +
				", customerId=" + customerId +
				", goodsId=" + goodsId +
				", goodsName='" + goodsName + '\'' +
				", goodsPrice=" + goodsPrice +
				", number=" + number +
				", stockId=" + stockId +
				", stockName='" + stockName + '\'' +
				", stockPrice=" + stockPrice +
				", shareCusId=" + shareCusId +
				", goodsImageUrl='" + goodsImageUrl + '\'' +
				'}';
	}

	public boolean isChoosed() {
		return choosed;
	}

	public void setChoosed(boolean choosed) {
		this.choosed = choosed;
	}
}