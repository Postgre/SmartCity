package com.smartcity.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.netease.nim.uikit.cache.DataCacheManager;
import com.netease.nim.uikit.common.ui.dialog.DialogMaker;
import com.netease.nimlib.sdk.AbortableFuture;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.auth.AuthService;
import com.netease.nimlib.sdk.auth.LoginInfo;
import com.smartcity.R;
import com.smartcity.base.BaseActivity;
import com.smartcity.http.model.UserInfo;
import com.smartcity.presenter.LoginPresenter;
import com.smartcity.presenterImpl.LoginPresenterImpl;
import com.smartcity.utils.LogTool;
import com.smartcity.utils.SpUtils;
import com.smartcity.utils.UserPreferences;
import com.smartcity.view.ILoginView;

import butterknife.Bind;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements ILoginView {
    private static final String TAG = LoginActivity.class.getName();
    @Bind(R.id.loginButton)
    Button loginBtn;

    @Bind(R.id.userEditText)
    EditText etUsername;

    @Bind(R.id.pwdEditText)
    EditText etPwd;

    private LoginPresenter loginPresenter;
    private AbortableFuture<LoginInfo> loginRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginPresenter = new LoginPresenterImpl(this);
    }

    @Override
    public void init() {

    }

    @OnClick(R.id.loginButton)
    public void onClick() {
        loginPresenter.login(getUserName(), getPassword());
    }

    @Override
    public void showProgress() {
        LogTool.d(TAG, "1111111111111");
    }

    @Override
    public void hideProgress() {
        LogTool.d(TAG, "222222222222");
    }


    @Override
    public void showHintMsg(String msg) {
        Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginInfo(UserInfo userInfo) {
        Toast.makeText(LoginActivity.this, userInfo.getMsg(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailMsg(String msg) {
        Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getUserName() {
        return etUsername.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return etPwd.getText().toString().trim();
    }

    @Override
    public void setResult() {
        setResult(RESULT_OK);
    }

    @Override
    public void finishActivity() {
        finish();
    }

    @Override
    public void loginToYunxin(String loginName, String password) {
        //登录云信
        LoginInfo info = new LoginInfo(loginName, password);
        Log.d("info11", password);
        loginToYx(info);
    }

    private void loginToYx(LoginInfo info) {
        DialogMaker.showProgressDialog(this, null, "登录中···", true, new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                if (loginRequest != null) {
                    loginRequest.abort();
                    onLoginDone();
                }
            }
        }).setCanceledOnTouchOutside(false);

        loginRequest = NIMClient.getService(AuthService.class).login(info);
        loginRequest.setCallback(new RequestCallback() {
            @Override
            public void onSuccess(Object o) {
                com.netease.nim.uikit.common.util.log.LogUtil.i("yxlogin", "login success");

                SpUtils.saveIsLoginYx(true);//登录云信成功，保存登录状态

                onLoginDone();
                // 初始化消息提醒
                NIMClient.toggleNotification(UserPreferences.getNotificationToggle());

                // 初始化免打扰
                NIMClient.updateStatusBarNotificationConfig(UserPreferences.getStatusConfig());

                // 构建缓存
                DataCacheManager.buildDataCacheAsync();

            }

            @Override
            public void onFailed(int code) {
                onLoginDone();
                if (code == 302 || code == 404) {
                    Toast.makeText(LoginActivity.this, "云信帐号或密码错误", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "登录失败: " + code, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onException(Throwable throwable) {
                onLoginDone();
            }
        });
    }

    private void onLoginDone() {
        loginRequest = null;
        DialogMaker.dismissProgressDialog();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @OnClick(R.id.playerRegisterButton)
    public void regist() {
        startActivity(new Intent(this, RegisterActivity.class));
    }
}
