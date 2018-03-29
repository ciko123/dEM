package com.ciko.guo.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import rx.subjects.PublishSubject;

/**
 * 创建时间: 2018/3/19 上午1:16
 * 类描述:
 *
 * @author 木棉
 */
public abstract class BaseActivity extends Activity {

    public final PublishSubject<ActivityLifeCycleEvent> lifecycleSubject = PublishSubject.create();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        lifecycleSubject.onNext(ActivityLifeCycleEvent.CREATE);
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        initView();
        setListener();
        initData();
    }

    @Override
    protected void onPause() {
        lifecycleSubject.onNext(ActivityLifeCycleEvent.PAUSE);
        super.onPause();
    }

    @Override
    protected void onStop() {
        lifecycleSubject.onNext(ActivityLifeCycleEvent.STOP);
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        lifecycleSubject.onNext(ActivityLifeCycleEvent.DESTROY);
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
