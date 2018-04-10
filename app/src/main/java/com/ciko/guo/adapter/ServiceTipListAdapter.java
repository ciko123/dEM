package com.ciko.guo.adapter;

import android.content.Context;

import com.ciko.guo.R;
import com.ciko.guo.base.adapter.CommonAdapter;
import com.ciko.guo.base.adapter.ViewHolder;
import com.ciko.guo.bean.Message;

/**
 * 创建时间: 2018/4/10 上午11:50
 * 类描述:
 *
 * @author Ciko
 */
public class ServiceTipListAdapter extends CommonAdapter<Message> {

    public ServiceTipListAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    protected void convert(ViewHolder viewHolder, Message item, int position) {
        viewHolder.setText(R.id.tvTitleServiceTip, item.getTitle());
        viewHolder.setText(R.id.tvContentServiceTip, item.getQuestion());
    }

}
