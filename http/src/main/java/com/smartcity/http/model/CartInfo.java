package com.smartcity.http.model;

import java.util.List;

/**
 * Created by Administrator on 2016/5/18.
 */
public class CartInfo extends BaseModel{

    /**
     * shopId : 1
     * shopName : 测试1
     * goodsList : [{"id":26,"customerId":1,"goodsId":6,"goodsName":"商品一","number":3,"stockId":null,"shareCusId":null,"goodsImageUrl":"http://img14.360buyimg.com/n1/jfs/t2470/30/755323007/84160/debf1d71/562898c4N3e135baf.jpg"},{"id":28,"customerId":1,"goodsId":1,"goodsName":"商品一","number":1,"stockId":null,"shareCusId":null,"goodsImageUrl":"http://img14.360buyimg.com/n1/jfs/t2470/30/755323007/84160/debf1d71/562898c4N3e135baf.jpg"}]
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private boolean choosed;

        @Override
        public String toString() {
            return "DataBean{" +
                    "shopId=" + shopId +
                    ", shopName='" + shopName + '\'' +
                    ", goodsList=" + goodsList +
                    '}';
        }

        private int shopId;
        private String shopName;
        /**
         * id : 26
         * customerId : 1
         * goodsId : 6
         * goodsName : 商品一
         * number : 3
         * stockId : null
         * shareCusId : null
         * goodsImageUrl : http://img14.360buyimg.com/n1/jfs/t2470/30/755323007/84160/debf1d71/562898c4N3e135baf.jpg
         */

        private List<GoodsListBean> goodsList;

        public int getShopId() {
            return shopId;
        }

        public void setShopId(int shopId) {
            this.shopId = shopId;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public List<GoodsListBean> getGoodsList() {
            return goodsList;
        }

        public void setGoodsList(List<GoodsListBean> goodsList) {
            this.goodsList = goodsList;
        }

        public void setChoosed(boolean choosed) {
            this.choosed = choosed;
        }

        public boolean isChoosed() {
            return choosed;
        }

        public static class GoodsListBean {
            private boolean choosed;
            private int id;
            private int customerId;
            private int goodsId;
            private String goodsName;
            private int number;
            private Object stockId;
            private Object shareCusId;
            private String goodsImageUrl;
            private int count;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getCustomerId() {
                return customerId;
            }

            public void setCustomerId(int customerId) {
                this.customerId = customerId;
            }

            public int getGoodsId() {
                return goodsId;
            }

            public void setGoodsId(int goodsId) {
                this.goodsId = goodsId;
            }

            public String getGoodsName() {
                return goodsName;
            }

            public void setGoodsName(String goodsName) {
                this.goodsName = goodsName;
            }

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
                this.number = number;
            }

            public Object getStockId() {
                return stockId;
            }

            public void setStockId(Object stockId) {
                this.stockId = stockId;
            }

            public Object getShareCusId() {
                return shareCusId;
            }

            public void setShareCusId(Object shareCusId) {
                this.shareCusId = shareCusId;
            }

            public String getGoodsImageUrl() {
                return goodsImageUrl;
            }

            public void setGoodsImageUrl(String goodsImageUrl) {
                this.goodsImageUrl = goodsImageUrl;
            }

            public boolean isChoosed() {
                return choosed;
            }

            public void setChoosed(boolean choosed) {
                this.choosed = choosed;
            }

            @Override
            public String toString() {
                return "GoodsListBean{" +
                        "id=" + id +
                        ", customerId=" + customerId +
                        ", goodsId=" + goodsId +
                        ", goodsName='" + goodsName + '\'' +
                        ", number=" + number +
                        ", stockId=" + stockId +
                        ", shareCusId=" + shareCusId +
                        ", goodsImageUrl='" + goodsImageUrl + '\'' +
                        '}';
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }
        }

    }

    @Override
    public String toString() {
        return "CartInfo{" +
                "data=" + data +
                '}';
    }
}
