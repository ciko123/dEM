package com.ciko.guo.activity;

import android.view.View;

import com.ciko.guo.R;
import com.ciko.guo.base.TitleActivity;

/**
 * 创建时间: 2018/3/20 下午2:59
 * 类描述:
 *
 * @author 木棉
 */
public class ChatOnlineActivity extends TitleActivity implements View.OnClickListener {

    private View viewNewChatChatOnline;

    @Override
    protected void initView() {
        super.initView();

        viewNewChatChatOnline = findView(R.id.viewNewChatChatOnline);
    }

    @Override
    protected void setListener() {
        viewNewChatChatOnline.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getContentLayoutResId() {
        return R.layout.layout_chat_online;
    }

    @Override
    protected String getTitleName() {
        return "在线咨询";
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.viewNewChatChatOnline:
                intent2Activity(NewChatActivity.class);
                break;
        }
    }
}
