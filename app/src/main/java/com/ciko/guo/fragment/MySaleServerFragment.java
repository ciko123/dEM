package com.ciko.guo.fragment;

import android.view.View;

import com.ciko.guo.R;
import com.ciko.guo.activity.ChatOnlineActivity;
import com.ciko.guo.base.BaseFragment;

/**
 * 创建时间: 2018/3/19 上午2:33
 * 类描述:
 *
 * @author 木棉
 */
public class MySaleServerFragment extends BaseFragment implements View.OnClickListener {

    private View viewServerGetServers;
    private View viewServerTipServers;
    private View viewChatOnlineServers;
    private View viewCodeSearchServers;

    private View tvServerGetServer;

    @Override
    protected int getLayoutResId() {
        return R.layout.layout_page_my_sale_server;
    }

    @Override
    protected void initView() {
        viewServerGetServers = findView(R.id.viewServerGetServers);
        viewServerTipServers = findView(R.id.viewServerTipServers);
        viewChatOnlineServers = findView(R.id.viewChatOnlineServers);
        viewCodeSearchServers = findView(R.id.viewCodeSearchServers);
        tvServerGetServer = findView(R.id.tvServerGetServer);
    }

    @Override
    protected void setListener() {
        viewServerGetServers.setOnClickListener(this);
        viewServerTipServers.setOnClickListener(this);
        viewChatOnlineServers.setOnClickListener(this);
        viewCodeSearchServers.setOnClickListener(this);
        tvServerGetServer.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.viewServerGetServers:

                break;
            case R.id.viewServerTipServers:

                break;
            case R.id.viewChatOnlineServers:
                intent2Activity(ChatOnlineActivity.class);
                break;
            case R.id.viewCodeSearchServers:

                break;
            case R.id.tvServerGetServer:

                break;
        }

    }
}
