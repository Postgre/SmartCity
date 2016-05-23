package com.smartcity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.netease.nim.uikit.LoginSyncDataStatusObserver;
import com.netease.nim.uikit.common.ui.dialog.DialogMaker;
import com.netease.nimlib.sdk.AbortableFuture;
import com.netease.nimlib.sdk.Observer;
import com.netease.nimlib.sdk.auth.LoginInfo;
import com.smartcity.R;
import com.smartcity.activity.money.MoneyActivity;
import com.smartcity.application.MyApplication;
import com.smartcity.base.BaseActivity;
import com.smartcity.config.Constant;
import com.smartcity.fragment.chw.ChwFragment;
import com.smartcity.fragment.circle.CircleFragment;
import com.smartcity.fragment.life.LifeFragment;
import com.smartcity.fragment.my.MyFragment;
import com.smartcity.utils.SharedPreferencesUtil;
import com.smartcity.utils.ToastTool;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements AMapLocationListener {
    private static final String TAG = MainActivity.class.getName();
    private static final int CHW = 1;
    private static final int CIRCLE = 2;
    private static final int LIFE = 3;
    private static final int MY = 4;

    @Bind(R.id.mainToolBar)
    RadioGroup mainToolBar;
    @Bind(R.id.chwRadioButton)
    RadioButton chwRadioButton;
    @Bind(R.id.circleRadioButton)
    RadioButton circleRadioButton;
    @Bind(R.id.lifeRadioButton)
    RadioButton lifeRadioButton;
    @Bind(R.id.myRadioButton)
    RadioButton myRadioButton;
    @Bind(R.id.moneyLayout)
    RelativeLayout moneyLayout;

    private ChwFragment chwFragment = null;
    private CircleFragment circleFragment = null;
    private LifeFragment lifeFragment = null;
    private MyFragment myFragment = null;

    private AbortableFuture<LoginInfo> loginRequest;

    private AMapLocationClient locationClient = null;
    private AMapLocationClientOption locationOption = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    public void init() {
        initLocation();
        //同步云信用户数据
        initYxUserData();
    }

    private void initYxUserData() {
        // 等待同步数据完成
        boolean syncCompleted = LoginSyncDataStatusObserver.getInstance().observeSyncDataCompletedEvent(new Observer<Void>() {
            @Override
            public void onEvent(Void v) {
                DialogMaker.dismissProgressDialog();
            }
        });

        Log.i("yx", "sync completed = " + syncCompleted);
        if (!syncCompleted) {
            DialogMaker.showProgressDialog(MainActivity.this, getString(R.string.prepare_data)).setCanceledOnTouchOutside(false);
        }

    }

    private void initLocation() {
        locationClient = new AMapLocationClient(this.getApplicationContext());
        locationOption = new AMapLocationClientOption();
        // 设置定位模式为高精度模式
        locationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置定位次数   一次  仅支持 高精度定位
        locationOption.setOnceLocation(true);
        //设置定位参数
        locationClient.setLocationOption(locationOption);
        // 设置定位监听
        locationClient.setLocationListener(this);
        //开始定位
        locationClient.startLocation();
    }

    @OnClick(R.id.moneyLayout)
    public void onClick() {
        Intent intent = new Intent(MainActivity.this, MoneyActivity.class);
        startActivity(intent);
    }

    private void initView() {
        mainToolBar.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.chwRadioButton:
                        switchTab(CHW);
                        break;
                    case R.id.circleRadioButton:
                        switchTab(CIRCLE);
                        break;
                    case R.id.lifeRadioButton:
                        switchTab(LIFE);
                        break;
                    case R.id.myRadioButton:
                        switchTab(MY);
                        break;
                }
            }
        });
        switchTab(CHW);
    }

    private void switchTab(int index) {
        switch (index) {
            case CHW:
                chwRadioButton.setChecked(true);
                break;
            case CIRCLE:
                circleRadioButton.setChecked(true);
                break;
            case LIFE:
                lifeRadioButton.setChecked(true);
                break;
            case MY:
                myRadioButton.setChecked(true);
                break;
        }
        setTabSelection(index);
    }

    private void setTabSelection(int index) {
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        hideFragments(transaction);
        switch (index) {
            case CHW:
                if (chwFragment != null) {
                    transaction.show(chwFragment);
                } else {
                    chwFragment = new ChwFragment();
                    transaction.add(R.id.container, chwFragment);
                }
                break;
            case CIRCLE:
                if (circleFragment != null) {
                    transaction.show(circleFragment);
                } else {
                    circleFragment = new CircleFragment();
                    transaction.add(R.id.container, circleFragment);
                }
                break;
            case LIFE:
                if (lifeFragment != null) {
                    transaction.show(lifeFragment);
                } else {
                    lifeFragment = new LifeFragment();
                    transaction.add(R.id.container, lifeFragment);
                }
                break;
            case MY:
                if (myFragment != null) {
                    transaction.show(myFragment);
                } else {
                    myFragment = new MyFragment();
                    transaction.add(R.id.container, myFragment);
                }
                break;

            default:
                break;
        }
        transaction.commitAllowingStateLoss();
    }

    private void hideFragments(FragmentTransaction ft) {
        if (chwFragment != null) {
            ft.hide(chwFragment);
        }
        if (circleFragment != null) {
            ft.hide(circleFragment);
        }
        if (lifeFragment != null) {
            ft.hide(lifeFragment);
        }
        if (myFragment != null) {
            ft.hide(myFragment);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onLocationChanged(AMapLocation loc) {
        if (null != loc) {
            String address = loc.getAddress();
            String code = loc.getAdCode();
            int code1 = loc.getErrorCode();
            double longitude = loc.getLongitude();
            double latitude = loc.getLatitude();
            String district = loc.getDistrict();
            SharedPreferencesUtil spUtils = MyApplication.getSpUtils();
            spUtils.put(Constant.CITY, loc.getCity());
            spUtils.put(Constant.CITY_CODE, loc.getCityCode());
            spUtils.put(Constant.LATITUDE, latitude + "");
            spUtils.put(Constant.LONGITUDE, longitude + "");
            spUtils.put(Constant.DISTRICT, district);
            ToastTool.showShort(this, "code1 = " + code1 + " code =" + code + " longitude =" + longitude + " latitude =" + latitude + " address = " + address);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != locationClient) {
            /**
             * 在Activity的onDestroy中一定要执行AMapLocationClient的onDestroy
             *
             *
             * 如果AMapLocationClient是在当前Activity实例化的，
             * 取消监听
             */
            locationClient.unRegisterLocationListener(this);
            locationClient.onDestroy();
            locationClient = null;
            locationOption = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (null != locationClient) {
            //停止定位
            locationClient.stopLocation();
        }
    }
}
