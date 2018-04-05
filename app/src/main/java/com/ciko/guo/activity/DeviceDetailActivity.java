package com.ciko.guo.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ciko.guo.R;
import com.ciko.guo.base.TitleActivity;
import com.ciko.guo.bean.DeviceDetial;
import com.ciko.guo.http.business.config.ApiServiceImp;
import com.ciko.guo.http.business.viewIInterface.IDeviceDetial;
import com.ciko.guo.utils.EmptyUtil;

import java.util.ArrayList;
import java.util.Map;

/**
 * 创建时间: 2018/3/19 上午3:15
 * 类描述:
 *
 * @author 木棉
 */
public class DeviceDetailActivity extends TitleActivity implements IDeviceDetial {

    private TextView tvNameDeviceDetail;
    private TextView tvNumDeviceDetail;
    private TextView tvStatusDeviceDetail;
    private TextView tvRunTimeDeviceDetail;

    private ImageView ivPicDeviceDetail;

    private LinearLayout llMoreInfoDeviceDetail;

    private int deviceId;

    @Override
    protected int getContentLayoutResId() {
        return R.layout.layout_driver_detail;
    }

    @Override
    protected void initView() {
        super.initView();

        tvNameDeviceDetail = findView(R.id.tvNameDeviceDetail);
        tvNumDeviceDetail = findView(R.id.tvNumDeviceDetail);
        tvStatusDeviceDetail = findView(R.id.tvStatusDeviceDetail);
        tvRunTimeDeviceDetail = findView(R.id.tvRunTimeDeviceDetail);

        ivPicDeviceDetail = findView(R.id.ivPicDeviceDetail);

        llMoreInfoDeviceDetail = findView(R.id.llMoreInfoDeviceDetail);

    }

    @Override
    protected String getTitleName() {
        return "设备详情";
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {
        deviceId = (int) getIntent().getSerializableExtra("deviceId");

        ApiServiceImp.getDeviceInfo(this, 4);


    }

    @Override
    public void postGetDeviceInfooResult(DeviceDetial data) {

        Glide.with(getContext()).load(data.getPicUrl()).into(ivPicDeviceDetail);

        tvNameDeviceDetail.setText("设备名称：" + data.getName());
        tvNumDeviceDetail.setText("设备编号：" + data.getSerialNumber());
        tvRunTimeDeviceDetail.setText("运行时间：" + data.getRuntime());

        setStatusView(data.getState());

        loadModeDetailInfo(data.getData());

    }

    public void loadModeDetailInfo(Map<String, String> data) {

        if (EmptyUtil.isNotEmpty(data)) {
            ArrayList<String> detailInfoList = new ArrayList<>();
            for (String s : data.values()) {
                detailInfoList.add(s);
            }

            for (int h = 0; h < detailInfoList.size() / 2 + detailInfoList.size() % 2; h++) {
                View view = LayoutInflater.from(getContext()).inflate(R.layout.item_device_detail_info, null);
                TextView tvLeftInfoDeviceDetail = (TextView) view.findViewById(R.id.tvLeftInfoDeviceDetail);
                TextView tvRightInfoDeviceDetail = (TextView) view.findViewById(R.id.tvRightInfoDeviceDetail);

                String[] keyValue0 = detailInfoList.get(h * 2).split("_");
                tvLeftInfoDeviceDetail.setText(keyValue0[0] + "：" + keyValue0[1]);

                if (detailInfoList.size() > h * 2 + 1) {
                    String[] keyValue1 = detailInfoList.get(h * 2 + 1).split("_");
                    tvRightInfoDeviceDetail.setText(keyValue1[0] + "：" + keyValue1[1]);
                }

                llMoreInfoDeviceDetail.addView(view);

            }
        }

    }


    /**
     * 设置不同状态显示的样式
     */
    private void setStatusView(int status) {
        switch (status) {
            case 0:
                tvStatusDeviceDetail.setText("状态：未知");
                break;
            case 1:
                tvStatusDeviceDetail.setText("状态：已连接");
                break;
            case 2:
                tvStatusDeviceDetail.setText("状态：超时");
                break;
            case 3:
                tvStatusDeviceDetail.setText("状态：已断开");
                break;
        }
    }


}
