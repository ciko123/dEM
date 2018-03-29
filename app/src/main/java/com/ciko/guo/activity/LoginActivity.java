package com.ciko.guo.activity;

import android.view.View;
import android.widget.Button;

import com.ciko.guo.R;
import com.ciko.guo.base.BaseActivity;
import com.ciko.guo.bean.UserLogin;
import com.ciko.guo.http.ApiServiceImp;
import com.ciko.guo.http.viewIInterface.ILoginView;

public class LoginActivity extends BaseActivity implements View.OnClickListener, ILoginView {

    private Button btnLogin;
    private Button btnRegister;

    @Override
    protected int getLayoutResId() {
        return R.layout.layout_login;
    }

    @Override
    protected void initView() {
        btnLogin = findView(R.id.btnLogin);
        btnRegister = findView(R.id.btnRegister);
    }

    @Override
    protected void setListener() {
        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                ApiServiceImp.login(this, "15869166322", "123456");
                intent2ActivityWithFinish(HomeActivity.class);
                break;
            case R.id.btnRegister:

                break;
        }
    }

    @Override
    public void loginResult(UserLogin userLogin) {
        intent2ActivityWithFinish(HomeActivity.class);
    }

}
