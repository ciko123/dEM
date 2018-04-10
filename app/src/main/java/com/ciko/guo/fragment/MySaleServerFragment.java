package com.ciko.guo.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ciko.guo.R;
import com.ciko.guo.activity.ChatDetailActivity;
import com.ciko.guo.activity.ChatOnlineActivity;
import com.ciko.guo.activity.CodeSearchActivity;
import com.ciko.guo.activity.ServerGetActivity;
import com.ciko.guo.activity.ServerTipActivity;
import com.ciko.guo.adapter.MessageListAdapter;
import com.ciko.guo.base.BaseFragment;
import com.ciko.guo.bean.Message;
import com.ciko.guo.bean.Page;
import com.ciko.guo.http.business.config.ApiServiceImp;
import com.ciko.guo.http.business.viewIInterface.IQryMsgListView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

/**
 * 创建时间: 2018/3/19 上午2:33
 * 类描述:
 *
 * @author 木棉
 */
public class MySaleServerFragment extends BaseFragment implements View.OnClickListener, IQryMsgListView, OnRefreshListener, AdapterView.OnItemClickListener {

    private View viewServerGetServers;
    private View viewServerTipServers;
    private View viewChatOnlineServers;
    private View viewCodeSearchServers;

    private View tvServerGetServer;

    private ListView lvMessageListSaleServer;
    private SmartRefreshLayout rlMessageListSaleServer;

    private MessageListAdapter messageListAdapter;

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

        lvMessageListSaleServer = findView(R.id.lvMessageListSaleServer);
        rlMessageListSaleServer = findView(R.id.rlMessageListSaleServer);
    }

    @Override
    protected void setListener() {
        viewServerGetServers.setOnClickListener(this);
        viewServerTipServers.setOnClickListener(this);
        viewChatOnlineServers.setOnClickListener(this);
        viewCodeSearchServers.setOnClickListener(this);
        tvServerGetServer.setOnClickListener(this);

        lvMessageListSaleServer.setOnItemClickListener(this);
    }

    @Override
    protected void initData() {

        messageListAdapter = new MessageListAdapter(getContext(), R.layout.item_message);

        lvMessageListSaleServer.setAdapter(messageListAdapter);

        rlMessageListSaleServer.setOnRefreshListener(this);


        ApiServiceImp.qryMsgList(this, 3, null, null, 1, 1000);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.viewServerGetServers:
                intent2Activity(ServerGetActivity.class);
                break;
            case R.id.viewServerTipServers:
                intent2Activity(ServerTipActivity.class);
                break;
            case R.id.viewChatOnlineServers:
                intent2Activity(ChatOnlineActivity.class);
                break;
            case R.id.viewCodeSearchServers:
                intent2Activity(CodeSearchActivity.class);
                break;
            case R.id.tvServerGetServer:
                intent2Activity(ServerGetActivity.class);
                break;
        }

    }

    @Override
    public void postIQryMsgListResult(Page<Message> messagePage) {
        rlMessageListSaleServer.finishRefresh();
        messageListAdapter.reLoadData(messagePage.getPageList());
    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        ApiServiceImp.qryMsgList(this, 3, null, null, 1, 1000);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Message message = messageListAdapter.getItem(position);
        Intent intent = new Intent(getActivity(), ChatDetailActivity.class);
        intent.putExtra("message", message);
        getActivity().startActivity(intent);
    }

    @Override
    public void postFail() {
        rlMessageListSaleServer.finishRefresh();
    }

}
