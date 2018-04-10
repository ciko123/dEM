package com.ciko.guo.fragment;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.ciko.guo.R;
import com.ciko.guo.activity.AddDriverActivity;
import com.ciko.guo.adapter.DeviceListAdapter;
import com.ciko.guo.base.BaseFragment;
import com.ciko.guo.bean.Device;
import com.ciko.guo.bean.Page;
import com.ciko.guo.http.business.config.ApiServiceImp;
import com.ciko.guo.http.business.viewIInterface.IDriverListView;
import com.ciko.guo.utils.EmptyUtil;
import com.xw.repo.XEditText;

/**
 * 创建时间: 2018/3/19 上午2:32
 * 类描述:
 *
 * @author 木棉
 */
public class MyDriversFragment extends BaseFragment implements IDriverListView, View.OnClickListener {

    private View viewAddDriverMyDevice;

    private TextView rectSearchMyDevice;

    private XEditText etCodeMyDevice;

    private ListView lvDeviceListMyDevice;

    private DeviceListAdapter deviceListAdapter;


    @Override
    protected int getLayoutResId() {
        return R.layout.layout_page_my_drivers;
    }

    @Override
    protected void initView() {
        viewAddDriverMyDevice = findView(R.id.viewAddDriverMyDevice);
        lvDeviceListMyDevice = findView(R.id.lvDeviceListMyDevice);
        rectSearchMyDevice = findView(R.id.rectSearchMyDevice);
        etCodeMyDevice = findView(R.id.etCodeMyDevice);
    }

    @Override
    protected void setListener() {
        viewAddDriverMyDevice.setOnClickListener(this);
        rectSearchMyDevice.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        deviceListAdapter = new DeviceListAdapter(getContext(), R.layout.item_device);
        lvDeviceListMyDevice.setAdapter(deviceListAdapter);

        ApiServiceImp.qryDeviceList(this, "y", 1, 1000, null);
    }

    @Override
    public void postQreDriveListResult(Page<Device> data) {

        deviceListAdapter.reLoadData(data.getPageList());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.viewAddDriverMyDevice:
                intent2Activity(AddDriverActivity.class);
                break;
            case R.id.rectSearchMyDevice:

                String key = etCodeMyDevice.getText().toString();

                if (EmptyUtil.isEmpty(key)) {
                    ApiServiceImp.qryDeviceList(this, "y", 1, 1000, null);
                } else {
                    ApiServiceImp.qryDeviceList(this, "y", 1, 1000, key);
                }

                break;
        }
    }

    @Override
    public void postFail() {
    }

}
