package com.smartcity.presenterImpl;

import android.text.TextUtils;

import com.smartcity.application.MyApplication;
import com.smartcity.config.Constant;
import com.smartcity.dao.UserDao;
import com.smartcity.http.model.UserInfo;
import com.smartcity.model.LoginModel;
import com.smartcity.model.modelImpl.LoginModelImpl;
import com.smartcity.presenter.LoginPresenter;
import com.smartcity.utils.LogTool;
import com.smartcity.utils.SharedPreferencesUtil;
import com.smartcity.view.ILoginView;

/**
 * 在此写类用途
 *
 * @version V2.0
 * @FileName: LoginPresenterImpl.java
 * @author: fengliang
 * @date: 2016-04-30 11:41
 */
public class LoginPresenterImpl implements LoginPresenter, LoginModelImpl.LoginCallBack {
    private static final String TAG = "LoginPresenterImpl";
    private ILoginView loginView;
    private LoginModel loginModel;
    private final UserDao userDao;
    private String username;

    public LoginPresenterImpl(ILoginView loginView) {
        this.loginView = loginView;
        loginModel = new LoginModelImpl();
        userDao = new UserDao(MyApplication.getApplication());
    }

    @Override
    public void login(String userName, String pwd) {
        if (TextUtils.isEmpty(userName)) {
            loginView.showHintMsg("手机号不能为空!");
            return;
        }
        if (TextUtils.isEmpty(pwd)) {
            loginView.showHintMsg("密码不能为空!");
            return;
        }
        if (!userName.matches(Constant.MATCHES_PHONE)) {
            loginView.showHintMsg("手机号格式不对!");
            return;
        }
        if (!loginModel.isNetState()) {
            loginView.showHintMsg("请检查网络连接!");
            return;
        }
        loginView.showProgress();
        loginModel.login(userName, pwd, this);
    }

    @Override
    public void onSuccess(UserInfo userInfo) {
        LogTool.d(TAG, "userInfo:" + userInfo);
        loginView.hideProgress();
        loginView.showLoginInfo(userInfo);
        //登录成功  缓存数据
        UserInfo.DataBean.ScSysUserBean sysUser = userInfo.getData().getScSysUser();
        SharedPreferencesUtil spUtils = MyApplication.getSpUtils();
        if (null != sysUser) {
            userDao.saveUser(sysUser);
            username = sysUser.getUsername();
            String usercode = sysUser.getUsercode();
            String password = sysUser.getPassword();
            spUtils.put(Constant.LOGINNAME, usercode);
            spUtils.put(Constant.PWD, password);
            spUtils.put(Constant.API_KEY, userInfo.getData().getApikey());
            spUtils.put(Constant.ID, String.valueOf(sysUser.getId()));
            loginView.loginToYunxin(usercode, password);
        }
        loginView.setResult();
        loginView.finishActivity();

    }

    @Override
    public void onFailure(String msg) {
        loginView.hideProgress();
        loginView.showFailMsg(msg);
    }

}
