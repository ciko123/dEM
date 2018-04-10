package com.ciko.guo.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * 创建时间: 2018/3/19 上午1:16
 * 类描述:
 *
 * @author 木棉
 */
public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        initView();
        setListener();
        initData();
    }

    abstract protected int getLayoutResId();

    abstract protected void initView();

    abstract protected void setListener();

    abstract protected void initData();

    public Activity getContext() {
        return this;
    }


    public <T extends View> T findView(int id) {
        return (T) findViewById(id);
    }

    protected void intent2Activity(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }

    protected void intent2ActivityWithFinish(Class<?> cls) {
        intent2Activity(cls);
        finish();
    }

}
