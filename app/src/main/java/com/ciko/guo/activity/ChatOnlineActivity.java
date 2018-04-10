package com.ciko.guo.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ciko.guo.R;
import com.ciko.guo.adapter.MessageListAdapter;
import com.ciko.guo.base.TitleActivity;
import com.ciko.guo.bean.Message;
import com.ciko.guo.bean.Page;
import com.ciko.guo.http.business.config.ApiServiceImp;
import com.ciko.guo.http.business.viewIInterface.IQryMsgListView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

/**
 * 创建时间: 2018/3/20 下午2:59
 * 类描述:
 *
 * @author 木棉
 */
public class ChatOnlineActivity extends TitleActivity implements View.OnClickListener, OnRefreshListener, IQryMsgListView, AdapterView.OnItemClickListener {

    private View viewNewChatChatOnline;

    private ListView lvMessageListChaetOnline;

    private SmartRefreshLayout rlMessageListChaetOnline;

    private MessageListAdapter messageListAdapter;

    @Override
    protected void initView() {
        super.initView();

        viewNewChatChatOnline = findView(R.id.viewNewChatChatOnline);
        lvMessageListChaetOnline = findView(R.id.lvMessageListChaetOnline);
        rlMessageListChaetOnline = findView(R.id.rlMessageListChaetOnline);

    }

    @Override
    protected void setListener() {
        viewNewChatChatOnline.setOnClickListener(this);
        lvMessageListChaetOnline.setOnItemClickListener(this);
    }

    @Override
    protected void initData() {
        messageListAdapter = new MessageListAdapter(getContext(), R.layout.item_message);
        lvMessageListChaetOnline.setAdapter(messageListAdapter);
        rlMessageListChaetOnline.setOnRefreshListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ApiServiceImp.qryMsgList(this, 3,null, null, 1, 1000);
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


    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        ApiServiceImp.qryMsgList(this, 3,null, null, 1, 1000);
    }

    @Override
    public void postIQryMsgListResult(Page<Message> data) {
        rlMessageListChaetOnline.finishRefresh();
        messageListAdapter.reLoadData(data.getPageList());
    }

    @Override
    public void postFail() {
        rlMessageListChaetOnline.finishRefresh();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Message message = messageListAdapter.getItem(position);
        Intent intent = new Intent(getContext(), ChatDetailActivity.class);
        intent.putExtra("message", message);
        startActivity(intent);
    }
}
