package com.ciko.guo.activity;

import android.widget.ListView;

import com.ciko.guo.R;
import com.ciko.guo.adapter.ServiceTipListAdapter;
import com.ciko.guo.base.TitleActivity;
import com.ciko.guo.bean.Message;
import com.ciko.guo.bean.Page;
import com.ciko.guo.http.business.config.ApiServiceImp;
import com.ciko.guo.http.business.viewIInterface.IQryMsgListView;

/**
 * 创建时间: 2018/3/19 上午3:22
 * 类描述:
 *
 * @author 木棉
 */
public class ServerTipActivity extends TitleActivity implements IQryMsgListView {

    private ListView lvServiceTip;

    private ServiceTipListAdapter serviceTipListAdapter;

    @Override
    protected int getContentLayoutResId() {
        return R.layout.layout_server_tip;
    }

    @Override
    protected String getTitleName() {
        return "服务提醒";
    }

    @Override
    protected void initView() {
        super.initView();
        lvServiceTip = (ListView) findViewById(R.id.lvServiceTip);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {

        serviceTipListAdapter = new ServiceTipListAdapter(getContext(), R.layout.item_service_tip);
        lvServiceTip.setAdapter(serviceTipListAdapter);

        ApiServiceImp.qryMsgList(this, 1, null, null, 1, 1000);

    }

    @Override
    public void postIQryMsgListResult(Page<Message> data) {
        serviceTipListAdapter.reLoadData(data.getPageList());
    }

    @Override
    public void postFail() {

    }

}
