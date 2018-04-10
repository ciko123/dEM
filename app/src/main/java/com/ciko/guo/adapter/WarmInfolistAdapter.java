package com.ciko.guo.adapter;

import android.content.Context;

import com.ciko.guo.base.adapter.CommonAdapter;
import com.ciko.guo.base.adapter.ViewHolder;
import com.ciko.guo.bean.Message;

/**
 * 创建时间: 2018/4/5 下午9:53
 * 类描述:
 *
 * @author Ciko
 */
public class WarmInfolistAdapter extends CommonAdapter<Message>{

    public WarmInfolistAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    protected void convert(ViewHolder viewHolder, Message item, int position) {

    }

}
