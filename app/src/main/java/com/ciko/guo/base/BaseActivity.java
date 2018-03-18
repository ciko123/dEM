package com.ciko.guo.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * 创建时间: 2018/3/19 上午1:16
 * 类描述:
 *
 * @author 木棉
 */
public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        findView();
        setListener();
        initData();
    }

    abstract protected int getLayoutResId();

    abstract protected void findView();

    abstract protected void setListener();

    abstract protected void initData();

    protected Activity getContext() {
        return this;
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
