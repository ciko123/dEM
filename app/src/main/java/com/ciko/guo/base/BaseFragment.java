package com.ciko.guo.base;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 创建时间: 2018/3/19 上午1:46
 * 类描述:
 *
 * @author 木棉
 */
public abstract class BaseFragment extends Fragment {

    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(getLayoutResId(), null);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        initView();
        setListener();
        initData();
    }

    public <T extends View> T findView(int id) {
        return (T) rootView.findViewById(id);
    }

    abstract protected int getLayoutResId();

    abstract protected void initView();

    abstract protected void setListener();

    abstract protected void initData();

    public Activity getContext() {
        return getActivity();
    }

    protected void intent2Activity(Class<?> cls) {
        Intent intent = new Intent(getActivity(), cls);
        startActivity(intent);
    }

    protected void intent2ActivityWithFinish(Class<?> cls) {
        intent2Activity(cls);
        getActivity().finish();
    }


}
