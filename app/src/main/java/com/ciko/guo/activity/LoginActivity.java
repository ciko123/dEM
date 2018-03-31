package com.ciko.guo.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ciko.guo.R;
import com.ciko.guo.base.BaseActivity;
import com.ciko.guo.bean.UserLogin;
import com.ciko.guo.http.business.viewIInterface.ILoginView;
import com.ciko.guo.http.business.config.ApiServiceImp;
import com.ciko.guo.utils.EmptyUtil;
import com.ciko.guo.utils.ToastUtil;

public class LoginActivity extends BaseActivity implements View.OnClickListener, ILoginView {

    private final String TAG = getClass().getSimpleName();

    private Button btnLogin;
    private Button btnRegister;

    private EditText etPhoneLogin;
    private EditText etPswLogin;
    private EditText etCodeLogin;

    @Override
    protected int getLayoutResId() {
        return R.layout.layout_login;
    }

    @Override
    protected void initView() {
        etPhoneLogin = findView(R.id.etPhoneLogin);
        etPswLogin = findView(R.id.etPswLogin);
        etCodeLogin = findView(R.id.etCodeLogin);

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

                String phoneLogin = etPhoneLogin.getText().toString();
                String pswLogin = etPswLogin.getText().toString();
                String codeLogin = etCodeLogin.getText().toString();

                if (checkInputLoginContext(phoneLogin, pswLogin, codeLogin)) {
                    ApiServiceImp.login(this, phoneLogin, pswLogin, null);
                }

                break;
            case R.id.btnRegister:

                break;
        }
    }

    /**
     * 校验输入内容
     *
     * @param phoneLogin
     * @param pswLogin
     * @param codeLogin
     * @return
     */
    private boolean checkInputLoginContext(String phoneLogin, String pswLogin, String codeLogin) {

        if (EmptyUtil.isEmpty(phoneLogin)) {
            ToastUtil.show("请输入手机号码");
            return false;
        }

        if (EmptyUtil.isNotEmpty(phoneLogin) && phoneLogin.length() != 11) {
            ToastUtil.show("请输入11位手机号码");
            return false;
        }

        if (EmptyUtil.isEmpty(pswLogin)) {
            ToastUtil.show("请输入密码");
            return false;
        }

        if (EmptyUtil.isEmpty(codeLogin)) {
            ToastUtil.show("请输入验证码");
            return false;
        }

        return true;

    }

    @Override
    public void postUserLoginResult(UserLogin userLogin) {
        intent2ActivityWithFinish(HomeActivity.class);
    }

}
