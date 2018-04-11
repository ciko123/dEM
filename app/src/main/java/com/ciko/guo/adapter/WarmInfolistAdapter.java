package com.ciko.guo.adapter;

import android.content.Context;

import com.ciko.guo.R;
import com.ciko.guo.base.adapter.CommonAdapter;
import com.ciko.guo.base.adapter.ViewHolder;
import com.ciko.guo.bean.WarmInfo;

/**
 * 创建时间: 2018/4/5 下午9:53
 * 类描述:
 *
 * @author Ciko
 */
public class WarmInfolistAdapter extends CommonAdapter<WarmInfo> {

    public WarmInfolistAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    protected void convert(ViewHolder viewHolder, WarmInfo item, int position) {
        viewHolder.setText(R.id.tvNameProgectWarmInfo, "项目名称：" + item.getProjectName());
        viewHolder.setText(R.id.tvNameDeviceWarmInfo, "设备名称：：" + item.getDeviceName());
        viewHolder.setText(R.id.tvContentWarmInfo,  item.getContent());
    }


}
