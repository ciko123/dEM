package com.ciko.guo.activity;

import android.view.View;
import android.widget.Button;

import com.ciko.guo.R;
import com.ciko.guo.base.BaseActivity;

/**
 * 创建时间: 2018/3/19 上午1:16
 * 类描述:
 *
 * @author 木棉
 */
public class RegisterSuccessActivity extends BaseActivity implements View.OnClickListener {

    private Button btnIntent2Login;

    @Override
    protected int getLayoutResId() {
        return R.layout.layout_register_success;
    }

    @Override
    protected void initView() {
        btnIntent2Login = (Button) findViewById(R.id.btnIntent2Login);
    }

    @Override
    protected void setListener() {
        btnIntent2Login.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnIntent2Login:
                finish();
                break;
        }
    }
}
