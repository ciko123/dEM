package com.ciko.guo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.ciko.guo.R;
import com.ciko.guo.adapter.AddDeviceListAdapter;
import com.ciko.guo.adapter.DeviceListAdapter;
import com.ciko.guo.base.TitleActivity;
import com.ciko.guo.bean.Device;
import com.ciko.guo.bean.Page;
import com.ciko.guo.http.business.config.ApiServiceImp;
import com.ciko.guo.http.business.viewIInterface.IDriverListView;
import com.ciko.guo.http.business.viewIInterface.IEditDeviceView;
import com.hwangjr.rxbus.RxBus;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.hwangjr.rxbus.thread.EventThread;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

/**
 * 创建时间: 2018/3/19 上午3:16
 * 类描述:
 *
 * @author 木棉
 */
public class AddDriverActivity extends TitleActivity implements OnRefreshListener, IDriverListView ,IEditDeviceView{

    private ListView lvDeviceListAddDevice;

    private SmartRefreshLayout rlDeviceListAddDevice;

    private AddDeviceListAdapter addDeviceListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RxBus.get().register(this);
    }

    @Override
    protected int getContentLayoutResId() {
        return R.layout.layout_add_driver;
    }

    @Override
    protected void initView() {
        super.initView();

        lvDeviceListAddDevice = findView(R.id.lvDeviceListAddDevice);
        rlDeviceListAddDevice = findView(R.id.rlDeviceListAddDevice);
    }

    @Override
    protected String getTitleName() {
        return "添加设备";
    }

    @Override
    protected void setListener() {
        rlDeviceListAddDevice.setOnRefreshListener(this);
    }

    @Override
    protected void initData() {

        addDeviceListAdapter = new AddDeviceListAdapter(getContext(), R.layout.item_add_device);
        lvDeviceListAddDevice.setAdapter(addDeviceListAdapter);

        ApiServiceImp.qryDeviceList(this, "", 1, 1000, null);
    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        ApiServiceImp.qryDeviceList(this, "", 1, 1000, null);
    }

    @Override
    public void postQreDriveListResult(Page<Device> data) {

        rlDeviceListAddDevice.finishRefresh();

        addDeviceListAdapter.reLoadData(data.getPageList());
    }

    @Override
    public void postFail() {
        rlDeviceListAddDevice.finishRefresh();
    }

    @Subscribe(
            thread = EventThread.MAIN_THREAD,
            tags = {
                    @Tag(AddDeviceListAdapter.EVENT_CLICK_DEVICE_SELECT)
            }
    )
    public void onClickDeviceDetail(Device device) {
        String isAppShow = device.getIsAppShow();
        ApiServiceImp.editDevice(this, device.getId(), isAppShow.equals("y") ? "n" : "y");
    }

    @Override
    public void postIEditDeviceResult() {
        ApiServiceImp.qryDeviceList(this, "", 1, 1000, null);
    }

}
