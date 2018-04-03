package com.ciko.guo.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ListView;

import com.ciko.guo.R;
import com.ciko.guo.activity.AddDriverActivity;
import com.ciko.guo.activity.ChatOnlineActivity;
import com.ciko.guo.activity.CodeSearchActivity;
import com.ciko.guo.activity.DeviceDetailActivity;
import com.ciko.guo.activity.ServerTipActivity;
import com.ciko.guo.activity.WarmInfoActivity;
import com.ciko.guo.adapter.DeviceListAdapter;
import com.ciko.guo.base.BaseFragment;
import com.ciko.guo.bean.Device;
import com.ciko.guo.bean.Page;
import com.ciko.guo.http.business.config.ApiServiceImp;
import com.ciko.guo.http.business.viewIInterface.IDriverListView;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.hwangjr.rxbus.thread.EventThread;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

/**
 * 创建时间: 2018/3/19 上午1:46
 * 类描述:
 *
 * @author 木棉
 */
public class HomeFragment extends BaseFragment implements View.OnClickListener, IDriverListView, OnRefreshListener, OnLoadMoreListener {

    private View viewWarnInfoHome;
    private View viewServicTipHome;
    private View viewChatOnlineHome;
    private View viewCodeSearchHome;

    private View viewAddDriverHome;

    private ListView lvDeviceListHome;

    private SmartRefreshLayout rlDeviceListHome;

    private DeviceListAdapter deviceListAdapter;

    @Override
    protected int getLayoutResId() {
        return R.layout.layout_page_home;
    }

    @Override
    protected void initView() {
        viewWarnInfoHome = findView(R.id.viewWarnInfoHome);
        viewServicTipHome = findView(R.id.viewServicTipHome);
        viewChatOnlineHome = findView(R.id.viewChatOnlineHome);
        viewCodeSearchHome = findView(R.id.viewCodeSearchHome);
        viewAddDriverHome = findView(R.id.viewAddDriverHome);

        lvDeviceListHome = findView(R.id.lvDeviceListHome);
        rlDeviceListHome = findView(R.id.rlDeviceListHome);

    }

    @Override
    protected void setListener() {
        viewWarnInfoHome.setOnClickListener(this);
        viewServicTipHome.setOnClickListener(this);
        viewChatOnlineHome.setOnClickListener(this);
        viewCodeSearchHome.setOnClickListener(this);
        viewAddDriverHome.setOnClickListener(this);
    }

    @Override
    protected void initData() {

        deviceListAdapter = new DeviceListAdapter(getContext(), R.layout.item_device);

        lvDeviceListHome.setAdapter(deviceListAdapter);

        rlDeviceListHome.setOnRefreshListener(this);
        rlDeviceListHome.setOnLoadMoreListener(this);


        ApiServiceImp.qryDeviceList(this, "y", 1, 1000, null);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.viewWarnInfoHome:
                intent2Activity(WarmInfoActivity.class);
                break;
            case R.id.viewServicTipHome:
                intent2Activity(ServerTipActivity.class);
                break;
            case R.id.viewChatOnlineHome:
                intent2Activity(ChatOnlineActivity.class);
                break;
            case R.id.viewCodeSearchHome:
                intent2Activity(CodeSearchActivity.class);
                break;
            case R.id.viewAddDriverHome:
                intent2Activity(AddDriverActivity.class);
                break;
        }
    }

    @Override
    public void postQreDriveListResult(Page<Device> devicePage) {

        rlDeviceListHome.finishRefresh();

        List<Device> deviceList = devicePage.getPageList();
        deviceListAdapter.reLoadData(deviceList);
    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        ApiServiceImp.qryDeviceList(this, "y", 1, 1000, null);
    }

    @Override
    public void onLoadMore(RefreshLayout refreshLayout) {
        rlDeviceListHome.finishLoadMore(1000);
    }

    @Subscribe(
            thread = EventThread.MAIN_THREAD,
            tags = {
                    @Tag(DeviceListAdapter.EVENT_CLICK_DEVICE_DETAIL)
            }
    )
    public void onClickDeviceDetail(Device device) {
        Intent intent = new Intent(getContext(), DeviceDetailActivity.class);
        intent.putExtra("deviceId", device.getId());
        getActivity().startActivity(intent);
    }

}
