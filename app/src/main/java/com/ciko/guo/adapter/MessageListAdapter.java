package com.ciko.guo.adapter;

import android.content.Context;

import com.ciko.guo.R;
import com.ciko.guo.base.adapter.CommonAdapter;
import com.ciko.guo.base.adapter.ViewHolder;
import com.ciko.guo.bean.Message;

/**
 * 创建时间: 2018/4/2 上午9:30
 * 类描述:
 *
 * @author Ciko
 */
public class MessageListAdapter extends CommonAdapter<Message> {

    public MessageListAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    protected void convert(ViewHolder viewHolder, Message item, int position) {
        viewHolder.setText(R.id.tvTitleMessage, item.getTitle());

        switch (item.getStatus()) {
            case 1:
                viewHolder.setText(R.id.tvStatusMessage, "未回复");
                viewHolder.setTextColorRes(R.id.tvStatusMessage, R.color.message_no_reply);
                break;
            case 2:
                viewHolder.setText(R.id.tvStatusMessage, "已回复");
                viewHolder.setTextColorRes(R.id.tvStatusMessage, R.color.message_had_reply);
                break;
        }

    }
}
