package com.ciko.guo.activity;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ciko.guo.R;
import com.ciko.guo.base.TitleActivity;
import com.ciko.guo.bean.DeviceDetial;
import com.ciko.guo.http.business.config.ApiServiceImp;
import com.ciko.guo.http.business.viewIInterface.IDeviceDetial;

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
    private TextView tvOutWaterTemperatureDeviceDetail;
    private TextView tvInWaterTemperatureDeviceDetail;
    private TextView tvInWaterGageDeviceDetail;
    private TextView tvOutWaterGageDeviceDetail;
    private TextView tvInFlueTemperatureDeviceDetail;

    private ImageView ivPicDeviceDetail;

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
        tvOutWaterTemperatureDeviceDetail = findView(R.id.tvOutWaterTemperatureDeviceDetail);
        tvInWaterTemperatureDeviceDetail = findView(R.id.tvInWaterTemperatureDeviceDetail);
        tvInWaterGageDeviceDetail = findView(R.id.tvInWaterGageDeviceDetail);
        tvOutWaterGageDeviceDetail = findView(R.id.tvOutWaterGageDeviceDetail);
        tvInFlueTemperatureDeviceDetail = findView(R.id.tvInFlueTemperatureDeviceDetail);

        ivPicDeviceDetail = findView(R.id.ivPicDeviceDetail);

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

        ApiServiceImp.getDeviceInfo(this, deviceId);


    }

    @Override
    public void postGetDeviceInfooResult(DeviceDetial data) {

        Glide.with(getContext()).load(data.getPicUrl()).into(ivPicDeviceDetail);

        tvNameDeviceDetail.setText("设备名称：" + data.getName());
        tvNumDeviceDetail.setText("设备编号：" + data.getSerialNumber());
        tvRunTimeDeviceDetail.setText("运行时间：" + data.getRuntime());

        setStatusView(data.getState());
    }

    private void setStatusView(int status) {
        switch (status) {
            case 0:
                tvStatusDeviceDetail.setText("状态：未知");
                break;
            case 1:
                tvStatusDeviceDetail.setText("状态：已经连接");
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
