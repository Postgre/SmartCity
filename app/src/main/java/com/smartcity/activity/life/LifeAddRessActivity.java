package com.smartcity.activity.life;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.smartcity.R;
import com.smartcity.activity.LoginActivity;
import com.smartcity.dao.ChinaCityDao;
import com.smartcity.dao.impl.ChinaCityDaoImpl;
import com.smartcity.fragment.life.ChoseProvinceFragment;
import com.smartcity.http.model.AddressList;
import com.smartcity.http.model.ProvinceModel;
import com.smartcity.presenterImpl.AddressPresenter;
import com.smartcity.utils.ThreadUtil;
import com.smartcity.view.IAddAddressView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;

public class LifeAddRessActivity extends LifeBaseActivity implements ChoseProvinceFragment.OnChoseProvinceLIstener, IAddAddressView {
    public static final int RESULT_CODE = 0x003;
    private ChinaCityDao dao;
    private ArrayList<ProvinceModel> provinceList;
    private ChoseProvinceFragment choseProvinceFragment;


    private static final int DETAULT_LOCATION = 0;

    private boolean isDefault;

    @Bind(R.id.add_et_name)
    EditText etName;

    @Bind(R.id.add_et_phone)
    EditText etPhone;

    @Bind(R.id.add_et_detail_address)
    EditText etDetailAddress;

    @Bind(R.id.add_tv_prod)
    TextView tvProvinceCity;

    @Bind(R.id.add_tv_location)
    TextView tvLocation;

    @Bind(R.id.add_iv_location)
    ImageView ivLocation;

    private AddressPresenter addressPresenter;

    private int postion;

    private String provinceCIty;

    @Override
    protected void initViews() {

        dao = new ChinaCityDaoImpl();
        Intent intent = getIntent();
        if (null != intent) {
            int type = intent.getIntExtra(LifeAddressListActivity.PARAMS_TYPE, -1);
            postion = intent.getIntExtra(LifeAddressListActivity.POSTION, -1);
            if (LifeAddressListActivity.EDITE_MODE == type) {
                //来自编辑
            }

            AddressList.LifeAddressModel addressModel = (AddressList.LifeAddressModel) intent.getSerializableExtra(LifeAddressListActivity.PARAMS);

            if (null != addressModel) {
                setUserName(addressModel.getName());
                setPhoneNumber(addressModel.getPhone());
                setDetailAddress(addressModel.getAddress());
                setIsDefaultAddress(addressModel.getIsDefault());

                StringBuilder builder = new StringBuilder(dao.provinceName(addressModel.getProvinceId()) + " " + dao.cityName(addressModel.getCityId()) + " " + dao.areaName(addressModel.getAreaId()));
                provinceCIty = builder.toString();
                setProvinceCity(provinceCIty);
                isDefault = DETAULT_LOCATION == addressModel.getIsDefault();
            }

        }

        addressPresenter = new AddressPresenter(this);
        choseProvinceFragment = new ChoseProvinceFragment();
        choseProvinceFragment.setOnChoseProvinceLIstener(this);
        ThreadUtil.getInstance().getPool().execute(new Runnable() {
            @Override
            public void run() {
                provinceList = dao.getProvinceList();
            }
        });
    }

    @Override
    protected String getName() {
        return "新增地址";
    }

    @Override
    public String getUserName() {
        return etName.getText().toString().trim();
    }

    @Override
    public String getPhoneNumber() {
        return etPhone.getText().toString().trim();
    }

    @Override
    public String getProvinceCity() {
        return tvProvinceCity.getText().toString().trim();
    }

    @Override
    public String getDetailAddress() {
        return etDetailAddress.getText().toString().trim();
    }

    @Override
    public int isDefaultAddress() {
        return isDefault?DETAULT_LOCATION:1;
    }

    @Override
    public void startLogin() {
        startActivity(new Intent(this, LoginActivity.class));
    }

    @Override
    public void setUserName(String name) {
        etName.setText(TextUtils.isEmpty(name) ? "" : name);
    }

    @Override
    public void setPhoneNumber(String phone) {
        etPhone.setText(TextUtils.isEmpty(phone) ? "" : phone);
    }

    @Override
    public void setProvinceCity(String provinceCIty) {

        tvProvinceCity.setText(TextUtils.isEmpty(provinceCIty) ? "" : provinceCIty);
    }

    @Override
    public void setDetailAddress(String address) {
        etDetailAddress.setText(TextUtils.isEmpty(address) ? "" : address);
    }

    @Override
    public void setIsDefaultAddress(int isDefaultAddress) {
        tvLocation.setSelected(DETAULT_LOCATION == isDefaultAddress);
        ivLocation.setSelected(DETAULT_LOCATION == isDefaultAddress);
    }

    @Override
    public void setEditeResult(AddressList.LifeAddressModel lifeAddressModel) {
        Intent intent = new Intent();
        intent.putExtra(LifeAddressListActivity.PARAMS, lifeAddressModel);
        intent.putExtra(LifeAddressListActivity.POSTION, postion);
        setResult(RESULT_CODE, intent);
        finish();
    }


    @Override
    protected View getCenterView() {
        return null;
    }

    @Override
    protected View getRightView() {
        TextView tvRight = new TextView(this);
        tvRight.setTextColor(getResources().getColor(R.color.black1));
        tvRight.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        tvRight.setText("完成");
        tvRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addressPresenter.addOrUpDataAddress(getUserName(), getPhoneNumber(), 1, getDetailAddress(), provinceCIty);
            }
        });
        return tvRight;
    }

    @Override
    protected int getContentId() {
        return R.layout.activity_life_add_ress;
    }


    @OnClick(R.id.add_rl_chose_prov)
    public void choseProvice() {
        if (null != provinceList) {

            if (!choseProvinceFragment.isVisible()) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("list", provinceList);
                choseProvinceFragment.setArguments(bundle);
                choseProvinceFragment.show(getSupportFragmentManager(), "choseProvinceFragment");
            }
        }
    }

    @Override
    public void choseProvince(String result) {
        provinceCIty = result;
        tvProvinceCity.setText(result);
    }


    @OnClick(R.id.add_rl_is_default_address)
    public void changgeColorAndSrc()
    {
        tvLocation.setSelected(!tvLocation.isSelected());
        ivLocation.setSelected(!ivLocation.isSelected());
        isDefault = tvLocation.isSelected();
    }
}
