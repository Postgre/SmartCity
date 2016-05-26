package com.smartcity.presenterImpl;

import android.text.TextUtils;
import android.widget.PopupWindow;

import com.smartcity.application.MyApplication;
import com.smartcity.dao.ChinaCityDao;
import com.smartcity.dao.impl.ChinaCityDaoImpl;
import com.smartcity.http.model.BannerInfo;
import com.smartcity.http.model.ShopParameterInfo;
import com.smartcity.model.ShopListModel;
import com.smartcity.model.modelImpl.ShopListModelImpl;
import com.smartcity.presenter.BasePresenter;
import com.smartcity.utils.LogTool;
import com.smartcity.utils.SharedPreferencesUtil;

/**
 * Created by Yancy on 2016/5/23.
 *
 * 根据分类id获取店铺列表
 *      默认 距离
 *
 *      点击功能:
 *          选择地区
 *          根据品牌
 *          根据销量 默认  高
 *
 *          初始化
 *              请求默认数据 和 品牌数据
 *
 *
 *
 */
public class ShopListPresenter implements BasePresenter, ShopListModelImpl.BannerListListener<BannerInfo>,ShopListModelImpl.ShopListListener {

    private final ChinaCityDao chinaCityDao;
    private ShopListModel shopListModel;
    private final String apikey;
    private final String id;

    private int classifyId;

    private boolean isRefsh = false;

    private boolean isLoadMore = false;

    private static final int PAGE_SIZE =15;
    private PopupWindow popupWindow;

    public ShopListPresenter(int classifyId) {
        this.classifyId  =classifyId;
        shopListModel = new ShopListModelImpl();
        chinaCityDao = new ChinaCityDaoImpl();
        apikey = MyApplication.getApikey();
        id = MyApplication.getId();

        init();
        initPopWindow();
    }

    private void initPopWindow() {
        popupWindow = new PopupWindow();
    }

    private void init() {
        //1.根据分类  拉取默认数据


        //2.获取品牌分类数据

    }

    @Override
    public void start() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void stop() {

    }


    public void getShopListByClassifyId(String cityName,String areaName,String brandId,String monthSellCntSort) {
        if(TextUtils.isEmpty(cityName))
        {
            return;
        }
        if(TextUtils.isEmpty(areaName))
        {
            return;
        }
        String cityId = chinaCityDao.cityId(cityName);
        String areaId = chinaCityDao.areaId(areaName)[0];

        SharedPreferencesUtil spUtils = MyApplication.getSpUtils();
        ShopParameterInfo shopParInfo = new ShopParameterInfo();
        shopParInfo.setCategoryId(classifyId);
      //  shopParInfo.setAreaId(areaId);
     //   shopParInfo.setCityId(cityId);

        //TODO: 后期换掉
        shopParInfo.setCityId("420100");
        shopParInfo.setAreaId("420106");
        shopParInfo.setBrandId(brandId);

      //  shopParInfo.setLatitude(spUtils.getString(Constant.LATITUDE,"30"));
       // shopParInfo.setLongitude(spUtils.getString(Constant.LONGITUDE,"120"));
        shopParInfo.setLatitude("30");
        shopParInfo.setLongitude("120");
        shopParInfo.setMonthSellCntSort(monthSellCntSort);
        shopListModel.getShopList(apikey,shopParInfo,this);
    }

    public void getShopListBannerInfo() {
        shopListModel.getBannerList(apikey, this);
    }

    @Override
    public void loadBannerInfoListSuccess(BannerInfo bannerInfo) {
        LogTool.e("bannerInfo", bannerInfo.toString());

    }

    @Override
    public void loadBannerInfoListError(String msg) {
        LogTool.e("test", TextUtils.isEmpty(msg)?"get banner info error":msg);
    }

    @Override
    public void loadShopListSuccess(Object o) {
        LogTool.e("test2", o.toString());
    }

    @Override
    public void loadShopListError(String msg) {
        LogTool.e("test", TextUtils.isEmpty(msg)?"get shoplist info error":msg);
    }

    public void  refsh()
    {

    }

    public void  loadMore()
    {

    }


}
