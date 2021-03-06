package com.smartcity.http.service;

import com.smartcity.http.Constant;
import com.smartcity.http.model.BannerInfo;
import com.smartcity.http.model.BaseModel;
import com.smartcity.http.model.CouponModel;
import com.smartcity.http.model.GoodsDetailInfo;
import com.smartcity.http.model.HopShopAndBanner;
import com.smartcity.http.model.LifeBannerAndHotModel;
import com.smartcity.http.model.LifeClassifyModel;
import com.smartcity.http.model.LifeGoodsModel;

import com.smartcity.http.model.LifeShopModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2016/5/19.
 */
public interface LifeIndexService {

    //轮播图和
    String GET_BANNER_CMD_VALUE = "shop/listShopByLabel";
    //附近
    String GET_NEAR_SHOP_CMD_VALUE = "shop/listShopByCategory";
    //分类
    String GET_CLASSIFY_CMD_VALUE = "shop/categoryList";

    //店铺首页
    String GET_SHOP_HONE_CMD_VALUE = "shop/getShopByID";
    //店铺优惠券
    String GET_SHOP_COUPON_CMD_VALUE = "shop/getCouponList";
    //店铺商品
    String GET_SHOP_GOODS_CMD_VALUE = "shop/getThisShopAllGoods";

    // 收藏店铺货商品
    String ADD_FAV_SHOP_OR_GOOD_CMD_VALUE = "shop/addFav";

    // 首页合并接口
    String GET_BANNER_AND_HOT_AND_CLASSIFY_CMD_VALUE = "shop/mallHomeInfo";

    // 商品详情
    String GET_GOODS_DETAILS_CMD_VALUE = "shop/goodsDetail";

    // 店铺列表  品牌
    String GET_SHOP_LIST_BANNER_CMD_VALUE = "shop/getBrandList";

    // 收藏店铺货商品
    String GET_BANNER_AND_HOT_CMD_VALUE = "shop/mallHomeInfo";

    //生活 轮播图和热门商品
    @FormUrlEncoded
    @POST(Constant.REST)
    Call<HopShopAndBanner> getBannnerOrHotShop(@Header(Constant.API_KEY) String apikey, @Field(Constant.CMD)String cmd,@Field(Constant.KEY_VERSION)
    String version, @Field(Constant.KEY_DATA) String data);

    //首页分类
    @FormUrlEncoded
    @POST(Constant.REST)
    Call<LifeClassifyModel> getLifeClassify(@Header(Constant.API_KEY) String apikey,@Field(Constant.CMD)String cmd, @Field(Constant.KEY_VERSION)
    String version, @Field(Constant.KEY_DATA) String data);

    //首页附近
    @FormUrlEncoded
    @POST(Constant.REST)
    Call<HopShopAndBanner> getLifeNear(@Header(Constant.API_KEY) String apikey,@Field(Constant.CMD)String cmd, @Field(Constant.KEY_VERSION)
    String version, @Field(Constant.KEY_DATA) String data);

    //店铺首页
    @FormUrlEncoded
    @POST(Constant.REST)
    Call<LifeShopModel> getShopHome(@Header(Constant.API_KEY) String apikey,@Field(Constant.CMD)String cmd, @Field(Constant.KEY_VERSION)
    String version, @Field(Constant.KEY_DATA) String data);

    //店铺优惠券
    @FormUrlEncoded
    @POST(Constant.REST)
    Call<CouponModel> getCouponList(@Header(Constant.API_KEY) String apikey,@Field(Constant.CMD)String cmd,
                                    @Field(Constant.KEY_VERSION)
                                    String version, @Field(Constant.KEY_DATA) String data);

    //店铺商品
    @FormUrlEncoded
    @POST(Constant.REST)
    Call<LifeGoodsModel> getGoodsList(@Header(Constant.API_KEY) String apikey, @Field(Constant.CMD)String cmd,@Field(Constant.KEY_VERSION)
    String version, @Field(Constant.KEY_DATA) String data);

    //收藏店铺或者商品
    @FormUrlEncoded
    @POST(Constant.REST)
    Call<BaseModel> addFovShopOrGood(@Header(Constant.API_KEY) String apikey,@Field(Constant.CMD)String cmd,
                                     @Field(Constant.KEY_VERSION)
                                     String version, @Field(Constant.KEY_DATA) String data);

    //获取生活首页banner和热门
    @FormUrlEncoded
    @POST(Constant.REST)
    Call<LifeBannerAndHotModel> getBannerAndHotAndClassifyList(@Header(Constant.API_KEY) String apikey, @Field(Constant.CMD)String cmd,@Field(Constant.KEY_VERSION)
    String version, @Field(Constant.KEY_DATA) String data);

    //获取店铺列表
    @FormUrlEncoded
    @POST(Constant.REST)
    Call<HopShopAndBanner> getShopList(@Header(Constant.API_KEY) String apikey, @Field(Constant.CMD)String cmd,@Field(Constant.KEY_VERSION)
    String version, @Field(Constant.KEY_DATA) String data);

    //获取商品详情
    @FormUrlEncoded
    @POST(Constant.REST)
    Call<GoodsDetailInfo> getGoodsDetails(@Header(Constant.API_KEY) String apikey, @Field(Constant.CMD)String cmd,@Field(Constant.KEY_VERSION) String version, @Field(Constant.KEY_DATA) String data);

    @FormUrlEncoded
    //获取店铺 品牌
    @POST(Constant.REST)
    Call<BannerInfo> getShopBanner(@Header(Constant.API_KEY) String apikey,@Field(Constant.CMD)String cmd, @Field(Constant.KEY_VERSION) String version, @Field(Constant.KEY_DATA) String data);

    Call<LifeBannerAndHotModel> getBannerAndHotList(@Header(Constant.API_KEY) String apikey,
                                                    @Field(Constant.CMD) String cmd, @Field(Constant.KEY_VERSION)
                                                    String version, @Field(Constant.KEY_DATA) String data);
}
