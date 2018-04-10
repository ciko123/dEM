package com.ciko.guo.activity;

import android.widget.ListView;

import com.ciko.guo.R;
import com.ciko.guo.adapter.WarmInfolistAdapter;
import com.ciko.guo.base.TitleActivity;
import com.ciko.guo.bean.Message;
import com.ciko.guo.bean.Page;
import com.ciko.guo.http.business.config.ApiServiceImp;
import com.ciko.guo.http.business.viewIInterface.IQryMsgListView;

/**
 * 创建时间: 2018/3/19 上午3:14
 * 类描述:
 *
 * @author 木棉
 */
public class WarmInfoActivity extends TitleActivity implements IQryMsgListView{

    private ListView lvWarmInfo;

    private WarmInfolistAdapter adapter;

    @Override
    protected int getContentLayoutResId() {
        return R.layout.layout_warm_info;
    }

    @Override
    protected String getTitleName() {
        return "报警信息";
    }

    @Override
    protected void initView() {
        super.initView();

        lvWarmInfo = findView(R.id.lvWarmInfo);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {
        adapter = new WarmInfolistAdapter(getContext(), R.layout.item_warm_info);
        lvWarmInfo.setAdapter(adapter);

//        ApiServiceImp.qryMsgList(this,);

    }


    @Override
    public void postIQryMsgListResult(Page<Message> data) {

    }

    @Override
    public void postFail() {

    }

}
