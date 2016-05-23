package com.smartcity.presenterImpl;

import android.text.TextUtils;

import com.smartcity.application.MyApplication;
import com.smartcity.dao.ChinaCityDao;
import com.smartcity.dao.impl.ChinaCityDaoImpl;
import com.smartcity.http.model.AddressList;
import com.smartcity.model.AddressListModel;
import com.smartcity.model.modelImpl.AddressListModelImpl;
import com.smartcity.presenter.BasePresenter;
import com.smartcity.utils.LogTool;
import com.smartcity.view.IAddAddressView;
import com.smartcity.view.IAddressView;

/**
 * Created by Yancy on 2016/5/16.
 */
public class AddressPresenter implements BasePresenter, AddressListModelImpl.GetAllAddressListener<AddressList>, AddressListModelImpl.UpdateOrAddAddressListener {

    private IAddAddressView addAddressView;
    private IAddressView iAddressView;
    private AddressListModel model;
    private ChinaCityDao chinaCityDao;

    public AddressPresenter(IAddressView iAddressView) {
        this.iAddressView = iAddressView;
        initModel();
        loadMoreList();
    }

    public AddressPresenter(IAddAddressView addAddressView) {
        initModel();
        this.addAddressView = addAddressView;
        chinaCityDao = new ChinaCityDaoImpl();
    }

    private void initModel() {
        model = new AddressListModelImpl();
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

    public void loadMoreList() {
        String id = MyApplication.getId();
        String apikey = MyApplication.getApikey();
        if (TextUtils.isEmpty(id) || TextUtils.isEmpty(apikey)) {
            iAddressView.startLogin();
            return;
        }
        if (!model.isNetState()) {
            iAddressView.showToast("请检查网络连接!");
            return;
        }
        model.getAllAddress(1, apikey, this);
    }

    @Override
    public void getAllSuccess(AddressList addressList) {
        if (null != addressList.getData()) {
            if (addressList.getData().size() <= 0) {
                iAddressView.showToast("oh no,新建地址吧!");
            } else {
                iAddressView.setData(addressList);
            }
        }
    }

    @Override
    public void getAllListError(String msg) {
        if (TextUtils.isEmpty(msg)) {
            iAddressView.showToast("请先登录");
            iAddressView.startLogin();
        } else {
            iAddressView.showToast(msg);
        }
    }

    public void addOrUpDataAddress(String userNmae, String phone, int isDefault, String detailAddress, String provinceCity) {

        String id = MyApplication.getId();
        String apikey = MyApplication.getApikey();
        if (TextUtils.isEmpty(id) || TextUtils.isEmpty(apikey)) {
            addAddressView.startLogin();
            return;
        }

        if (TextUtils.isEmpty(userNmae)) {
            addAddressView.showToast("用户名不能为空!");
            return;
        }
        if (TextUtils.isEmpty(phone)) {
            addAddressView.showToast("手机号不能为空!");
            return;
        }
        if (TextUtils.isEmpty(detailAddress)) {
            addAddressView.showToast("地址不能为空!");
            return;
        }
        if (TextUtils.isEmpty(provinceCity) || "请选择...".equals(provinceCity)) {
            addAddressView.showToast("请选择城市");
            return;
        }
        if (!model.isNetState()) {
            addAddressView.showToast("请检查网络连接!");
            return;
        }
        String[] strings = provinceCity.split(" ");

        String provinceId = chinaCityDao.provinceId(strings[0]);
        String cityId = chinaCityDao.cityId(strings[1]);
        String areaId = chinaCityDao.areaId(strings[2])[0];

        LogTool.e("test", "provinceId = " + provinceId);
        LogTool.e("test", "cityId = " + cityId);
        LogTool.e("test", "areaId = " + areaId);

        AddressList.LifeAddressModel lifeAddressModel = new AddressList.LifeAddressModel();
        lifeAddressModel.setName(userNmae);
        lifeAddressModel.setPhone(phone);
        lifeAddressModel.setIsDefault(isDefault);
        lifeAddressModel.setAddress(detailAddress);
        lifeAddressModel.setCreateTime(System.currentTimeMillis() + "");
        lifeAddressModel.setId(Integer.parseInt(id));
        lifeAddressModel.setCustomerId(Integer.parseInt(id));
        lifeAddressModel.setAreaId(areaId);
        lifeAddressModel.setProvinceId(provinceId);
        lifeAddressModel.setCityId(cityId);
        addAddressView.showLoading("正在添加中..");
        model.addAddress(lifeAddressModel, apikey, this);
    }

    @Override
    public void updateOrAddAddressSuccess(Object o) {
        LogTool.e("test", o.toString());
        addAddressView.hideLoading();

    }

    @Override
    public void updateOrAddAddressError(String msg) {
        LogTool.e("test", TextUtils.isEmpty(msg) ? "null" : msg);
        addAddressView.hideLoading();
    }
}
