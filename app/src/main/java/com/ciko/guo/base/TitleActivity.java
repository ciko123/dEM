package com.ciko.guo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;

import com.ciko.guo.R;

/**
 * 创建时间: 2018/3/19 下午12:08
 * 类描述:
 *
 * @author 木棉
 */
public abstract class TitleActivity extends BaseActivity {

    private View viewBackTitleActivity;

    private FrameLayout frameLayout;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        viewBackTitleActivity = findView(R.id.viewBackTitleActivity);

        frameLayout = findView(R.id.rootViewTitleActivity);
        frameLayout.addView(getLayoutInflater().inflate(getContentLayoutResId(), null));

        viewBackTitleActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.layout_title_activity;
    }

    abstract protected int getContentLayoutResId();

    abstract protected String getTitleName();

}
