package com.ciko.guo.fragment;

import android.view.View;
import android.widget.ListView;

import com.ciko.guo.R;
import com.ciko.guo.activity.AddDriverActivity;
import com.ciko.guo.adapter.DeviceListAdapter;
import com.ciko.guo.base.BaseFragment;
import com.ciko.guo.bean.Device;
import com.ciko.guo.bean.Page;
import com.ciko.guo.http.business.config.ApiServiceImp;
import com.ciko.guo.http.business.viewIInterface.IDriverListView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

/**
 * 创建时间: 2018/3/19 上午2:32
 * 类描述:
 *
 * @author 木棉
 */
public class MyDriversFragment extends BaseFragment implements OnRefreshListener, IDriverListView, View.OnClickListener {

    private View viewAddDriverMyDevice;

    private ListView lvDeviceListMyDevice;
    private SmartRefreshLayout rlDeviceListMyDevice;

    private DeviceListAdapter deviceListAdapter;

    @Override
    protected int getLayoutResId() {
        return R.layout.layout_page_my_drivers;
    }

    @Override
    protected void initView() {
        viewAddDriverMyDevice = findView(R.id.viewAddDriverMyDevice);
        lvDeviceListMyDevice = findView(R.id.lvDeviceListMyDevice);
        rlDeviceListMyDevice = findView(R.id.rlDeviceListMyDevice);
    }

    @Override
    protected void setListener() {
        viewAddDriverMyDevice.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        deviceListAdapter = new DeviceListAdapter(getContext(), R.layout.item_message);
        lvDeviceListMyDevice.setAdapter(deviceListAdapter);

        rlDeviceListMyDevice.setOnRefreshListener(this);

        ApiServiceImp.qryDeviceList(this, "y", null, null, null);
    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        ApiServiceImp.qryDeviceList(this, "y", null, null, null);
    }

    @Override
    public void postQreDriveListResult(Page<Device> data) {
        rlDeviceListMyDevice.finishRefresh();

        deviceListAdapter.reLoadData(data.getPageList());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.viewAddDriverMyDevice:
                intent2Activity(AddDriverActivity.class);
                break;
        }
    }
}
