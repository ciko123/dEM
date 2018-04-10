package com.ciko.guo.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ciko.guo.R;
import com.ciko.guo.base.adapter.CommonAdapter;
import com.ciko.guo.base.adapter.ViewHolder;
import com.ciko.guo.bean.Device;
import com.ciko.guo.utils.ResourceUtil;
import com.hwangjr.rxbus.RxBus;

/**
 * 创建时间: 2018/4/2 上午8:40
 * 类描述:
 *
 * @author Ciko
 */
public class AddDeviceListAdapter extends CommonAdapter<Device> {

    public static final String EVENT_CLICK_DEVICE_DETAIL = "EVENT_CLICK_DEVICE_DETAIL";
    public static final String EVENT_CLICK_DEVICE_SELECT = "EVENT_CLICK_DEVICE_SELECT";


    public AddDeviceListAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    protected void convert(ViewHolder viewHolder, final Device item, int position) {

        Glide.with(getContext()).load(item.getPicUrl()).into((ImageView) viewHolder.getView(R.id.ivPicAddDevice));

        viewHolder.setText(R.id.tvNameAddDevice, "设备名称：" + item.getName());
        viewHolder.setText(R.id.tvNumAddDevice, "设备编号：" + item.getSerialNumber());

        switch (item.getIsAppShow()) {
            case "y":
                viewHolder.setImageResource(R.id.ivStatusDeviceAddDevice, R.drawable.ic_check_selected);
                break;
            case "n":
                viewHolder.setImageResource(R.id.ivStatusDeviceAddDevice, R.drawable.ic_check_normal);
                break;
        }

        viewHolder.getView(R.id.viewDetailAddDevice).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RxBus.get().post(EVENT_CLICK_DEVICE_DETAIL, item);
            }
        });

        viewHolder.getView(R.id.ivStatusDeviceAddDevice).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RxBus.get().post(EVENT_CLICK_DEVICE_SELECT, item);
            }
        });



        setStatusView(viewHolder, item.getStatus());

    }

    //  state":1,//状态0：未知，1：已经连接，2：超时，3：已断开
    public void setStatusView(ViewHolder viewHolder, int status) {

        TextView tvStatusDevice = viewHolder.getView(R.id.tvStatusAddDevice);
        CardView cardViewDevice = viewHolder.getView(R.id.cardViewAddDevice);

        switch (status) {
            case 0:
                tvStatusDevice.setText("未知");
                tvStatusDevice.setTextColor(ResourceUtil.getColor(R.color.device_status_warm));
                cardViewDevice.setCardBackgroundColor(ResourceUtil.getColor(R.color.device_status_warm));
                break;
            case 1:
                tvStatusDevice.setText("已经连接");
                tvStatusDevice.setTextColor(ResourceUtil.getColor(R.color.device_status_normal));
                cardViewDevice.setCardBackgroundColor(ResourceUtil.getColor(R.color.device_status_normal));
                break;
            case 2:
                tvStatusDevice.setText("超时");
                tvStatusDevice.setTextColor(ResourceUtil.getColor(R.color.device_status_warm));
                cardViewDevice.setCardBackgroundColor(ResourceUtil.getColor(R.color.device_status_warm));
                break;
            case 3:
                tvStatusDevice.setText("已断开");
                tvStatusDevice.setTextColor(ResourceUtil.getColor(R.color.device_status_pause));
                cardViewDevice.setCardBackgroundColor(ResourceUtil.getColor(R.color.device_status_pause));
                break;
        }

    }

}
