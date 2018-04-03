package com.ciko.guo.base;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.ciko.guo.R;

/**
 * 创建时间: 2018/3/19 下午12:08
 * 类描述:
 *
 * @author 木棉
 */
public abstract class TitleActivity extends BaseActivity implements View.OnClickListener{

    private View viewBackTitleActivity;
    private View viewRightTitleActivity;

    private View contentView;

    private TextView tvTitleBar;
    private TextView tvOperateTitleRight;

    private FrameLayout frameLayout;

    private OnCliekTitleRightOperateListener listener;

    @Override
    protected void initView() {

        viewBackTitleActivity = findView(R.id.viewBackTitleActivity);
        viewRightTitleActivity = findView(R.id.viewRightTitleActivity);
        tvTitleBar = findView(R.id.tvTitleBar);
        tvOperateTitleRight = findView(R.id.tvOperateTitleRight);

        viewRightTitleActivity.setVisibility(View.GONE);

        frameLayout = findView(R.id.rootViewTitleActivity);

        contentView = getLayoutInflater().inflate(getContentLayoutResId(), null);
        tvTitleBar.setText(getTitleName());
        frameLayout.addView(contentView);

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

    public void setTitleRightOperateName(String operateName, OnCliekTitleRightOperateListener listener) {

        this.listener = listener;

        viewRightTitleActivity.setVisibility(View.VISIBLE);
        viewRightTitleActivity.setOnClickListener(this);
        tvOperateTitleRight.setText(operateName);

    }

    public interface OnCliekTitleRightOperateListener {
        void OnCliekTitleRightOperate();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.viewRightTitleActivity:
                listener.OnCliekTitleRightOperate();
                break;
        }
    }
}
