package com.smartcity.presenterImpl;

import android.os.CountDownTimer;
import android.text.TextUtils;

import com.smartcity.config.Constant;
import com.smartcity.config.ResCode;
import com.smartcity.http.model.BaseModel;
import com.smartcity.model.RegistModel;
import com.smartcity.model.modelImpl.RegistModelImpl;
import com.smartcity.presenter.RegistPresenter;
import com.smartcity.view.IRegistViews;

/**
 * 注册PresenterImpl
 *
 * @version V2.0
 * @FileName: RegistPresenterImpl.java
 * @author: fengliang
 * @date: 2016-05-20 15:44
 */
public class RegistPresenterImpl implements RegistPresenter {
    private static final String TAG = "RegistPresenterImpl";
    private IRegistViews views;
    private RegistModel registModel;
    private MyCount myCount;

    public RegistPresenterImpl(IRegistViews views) {
        this.views = views;
        registModel = new RegistModelImpl();
        myCount = new MyCount(60000, 1000);
    }

    @Override
    public void getNewCode(String phone) {
        if (TextUtils.isEmpty(phone)) {
            views.showMessage("手机号不能为空!");
            return;
        }
        if (!phone.matches(Constant.MATCHES_PHONE)) {
            views.showMessage("手机号格式不对!");
            return;
        }
        if (!registModel.isNetState()) {
            views.showMessage("请检查网络连接!");
            return;
        }
        //设置按钮不可点击
        // 显示提示时间
        views.setTvClickable(false);
        myCount.start();
        registModel.getNewCode(phone, new RegistModelImpl.RegistNewCodeCallback() {
            @Override
            public void success(String code) {
                views.hideLoading();
            }

            @Override
            public void error(String msg) {
                views.hideLoading();
                views.showMessage(msg);
            }

            @Override
            public void errorEmpty() {
                views.hideLoading();
                views.showMessage("获取验证码失败");
            }

        });
    }

    @Override
    public void regist(String usercode, String pwd, String comPwd, String captcha) {
        if (TextUtils.isEmpty(usercode) || TextUtils.isEmpty(pwd) || TextUtils.isEmpty(comPwd) || TextUtils.isEmpty(captcha)) {
            views.showMessage("info is not empty!");
            return;
        }
        if (!usercode.matches(Constant.MATCHES_PHONE)) {
            views.showMessage("手机号格式不对!");
            return;
        }
        if (!pwd.equals(comPwd)) {
            views.showMessage("两次密码不一致!");
            return;
        }
        if (6 > pwd.length()) {
            views.showMessage("密码必须六位以上!");
            return;
        }
        if (pwd.matches("^\\d+$")) {
            views.showMessage("密码不能是纯数字!");
            return;
        }
        if (!registModel.isNetState()) {
            views.showMessage("请检查网络连接!");
            return;
        }
        views.showLoading("正在注册中..");

        registModel.regist(usercode, pwd, captcha, new RegistModelImpl.RegistCallBack<BaseModel>() {

            @Override
            public void registSuccess(BaseModel baseBeans) {
                views.hideLoading();
                views.showMessage(baseBeans.getMsg());
                switch (baseBeans.getCode()) {
                    case ResCode.STATUS_SUCCESS_CODE:
                        //可以处理跳转
                        //    ToastTool.showShort(UIUtils.getContext(), "regist success");
                        break;
                    case ResCode.STATUS_FAILURE_CODE:

                        break;
                }

            }

            @Override
            public void registError(String msg) {
                views.hideLoading();
                views.showMessage(msg);
            }
        });
    }

    private class MyCount extends CountDownTimer {

        public MyCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            views.setTvHint("(" + (millisUntilFinished / 1000) + "s)" + "后重新发送");
        }

        @Override
        public void onFinish() {
            views.setTvHint("获取验证码");
            views.setTvClickable(true);
        }
    }

}
