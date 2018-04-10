package com.ciko.guo.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.ciko.guo.R;
import com.ciko.guo.UserCache;
import com.ciko.guo.base.BaseActivity;
import com.ciko.guo.http.business.config.ApiServiceImp;
import com.ciko.guo.http.business.viewIInterface.ILoginView;
import com.ciko.guo.http.business.viewIInterface.IRegisterView;
import com.ciko.guo.utils.EmptyUtil;
import com.ciko.guo.utils.ToastUtil;

public class LoginActivity extends BaseActivity implements View.OnClickListener, ILoginView, IRegisterView {


    private TextView tvRegisterLogin;
    private TextView tvloginLogin;


    private EditText etPhoneLogin;
    private EditText etPswLogin;
    private EditText etUserNameRegister;
    private EditText etPhoneRegister;
    private EditText etPswRegister;
    private EditText etRePswRegister;
    private EditText etCompanyNameRegister;

    private Button btnRegister;
    private Button btnLogin;

    private FrameLayout rectLogin;
    private FrameLayout rectRegister;

    @Override
    protected int getLayoutResId() {
        return R.layout.layout_login;
    }

    @Override
    protected void initView() {
        etUserNameRegister = findView(R.id.etUserNameRegister);
        etPhoneRegister = findView(R.id.etPhoneRegister);
        etPswRegister = findView(R.id.etPswRegister);
        etRePswRegister = findView(R.id.etRePswRegister);
        etPhoneLogin = findView(R.id.etPhoneLogin);
        etPswLogin = findView(R.id.etPswLogin);
        etCompanyNameRegister = findView(R.id.etCompanyNameRegister);
        btnLogin = findView(R.id.btnLogin);
        btnRegister = findView(R.id.btnRegister);
        tvRegisterLogin = findView(R.id.tvRegisterLogin);
        tvloginLogin = findView(R.id.tvloginLogin);
        rectRegister = findView(R.id.rectRegister);
        rectLogin = findView(R.id.rectLogin);
    }

    @Override
    protected void setListener() {
        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
        tvRegisterLogin.setOnClickListener(this);
        tvloginLogin.setOnClickListener(this);
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

                if (checkInputLoginContext(phoneLogin, pswLogin)) {
                    ApiServiceImp.login(this, phoneLogin, pswLogin);
                }

                break;
            case R.id.btnRegister:

                String companyName = etCompanyNameRegister.getText().toString();
                String name = etUserNameRegister.getText().toString();
                String phone = etPhoneRegister.getText().toString();
                String psw = etPswRegister.getText().toString();
                String rePsw = etRePswRegister.getText().toString();

                if (checkInputRegisterContext(companyName, name, phone, psw, rePsw)) {
                    ApiServiceImp.register(this,companyName,  name, phone, psw);
                }

                break;
            case R.id.tvRegisterLogin:
                rectRegister.setVisibility(View.VISIBLE);
                rectLogin.setVisibility(View.GONE);
                break;
            case R.id.tvloginLogin:
                rectRegister.setVisibility(View.GONE);
                rectLogin.setVisibility(View.VISIBLE);
                break;
        }
    }

    /**
     * 校验注册输入内容
     */
    private boolean checkInputRegisterContext(String companyName, String name, String phone, String psw, String rePsw) {

        if (EmptyUtil.isEmpty(companyName)) {
            ToastUtil.show("公司名字不能为空");
            return false;
        }

        if (EmptyUtil.isEmpty(name)) {
            ToastUtil.show("名字不能为空");
            return false;
        }

        if (EmptyUtil.isEmpty(phone)) {
            ToastUtil.show("账号不能为空");
            return false;
        }

        if (EmptyUtil.isEmpty(psw)) {
            ToastUtil.show("密码不能为空");
            return false;
        }

        if (EmptyUtil.isEmpty(rePsw)) {
            ToastUtil.show("请再输入一次密码");
            return false;
        }

        if (!psw.equals(rePsw)) {
            ToastUtil.show("两次输入的密码不一致");
            return false;
        }

        return true;

    }

    /**
     * 校验登录输入内容
     */
    private boolean checkInputLoginContext(String phoneLogin, String pswLogin) {

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

        return true;

    }

    @Override
    public void postUserLoginResult() {
        String pswLogin = etPswLogin.getText().toString();
        UserCache.getIns().getUser().setPassword(pswLogin);
        intent2ActivityWithFinish(HomeActivity.class);
    }

    @Override
    public void postAddUserResult() {
        rectRegister.setVisibility(View.GONE);
        rectLogin.setVisibility(View.VISIBLE);

        etUserNameRegister.setText("");
        etPhoneRegister.setText("");
        etPswRegister.setText("");
        etRePswRegister.setText("");

        intent2Activity(RegisterSuccessActivity.class);
    }
}
