package com.smartcity.activity.life;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartcity.R;
import com.smartcity.activity.LoginActivity;
import com.smartcity.dao.ChinaCityDao;
import com.smartcity.dao.impl.ChinaCityDaoImpl;
import com.smartcity.fragment.life.ChoseProvinceFragment;
import com.smartcity.http.model.ProvinceModel;
import com.smartcity.presenterImpl.AddressPresenter;
import com.smartcity.utils.LogTool;
import com.smartcity.utils.ThreadUtil;
import com.smartcity.view.IAddAddressView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;

public class LifeAddRessActivity extends LifeBaseActivity implements ChoseProvinceFragment.OnChoseProvinceLIstener ,IAddAddressView {
    private ChinaCityDao dao;
    private ArrayList<ProvinceModel> provinceList;
    private ChoseProvinceFragment choseProvinceFragment;


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
    private String provinceCIty ;
    private AddressPresenter addressPresenter;

    @Override
    protected void initViews() {
        dao = new ChinaCityDaoImpl();
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
        return 0;
    }

    @Override
    public void startLogin() {
        startActivity(new Intent(this, LoginActivity.class));
    }

    @Override
    protected View getCenterView() {
        return null;
    }

    @Override
    protected View getRightView() {
        TextView tvRight = new TextView(this);
        tvRight.setTextColor(getResources().getColor(R.color.black1));
        tvRight.setTextSize(getResources().getDimension(R.dimen.ts_10));
        tvRight.setText("完成");
        tvRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addressPresenter.addOrUpDataAddress(getUserName(),getPhoneNumber(),isDefault?0:1,getDetailAddress(),provinceCIty);
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
        if(null != provinceList)
        {

            if(!choseProvinceFragment.isVisible())
            {
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
    public void  setIsDefaultAdress(View view)
    {
        isDefault = !isDefault;
        LogTool.e("test",String.valueOf(isDefault));
        tvLocation.setClickable(isDefault);
        ivLocation.setClickable(isDefault);
    }
}
