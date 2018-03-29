package com.ciko.guo.fragment;

import android.view.View;

import com.ciko.guo.R;
import com.ciko.guo.activity.AddDriverActivity;
import com.ciko.guo.activity.HomeActivity;
import com.ciko.guo.activity.WarmInfoActivity;
import com.ciko.guo.base.BaseFragment;
import com.ciko.guo.bean.Device;
import com.ciko.guo.http.business.viewIInterface.IDriverListView;
import com.ciko.guo.http.core.ApiServiceImp;

import java.util.List;

/**
 * 创建时间: 2018/3/19 上午1:46
 * 类描述:
 *
 * @author 木棉
 */
public class HomeFragment extends BaseFragment implements View.OnClickListener, IDriverListView {

    private View viewWarnInfoHome;
    private View viewServicTipHome;
    private View viewChatOnlineHome;
    private View viewCodeSearchHome;

    private View viewAddDriverHome;

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
        ApiServiceImp.getDriveList((HomeActivity)getActivity(), this, 1, 1000, null);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.viewWarnInfoHome:
                intent2Activity(WarmInfoActivity.class);
                break;
            case R.id.viewServicTipHome:

                break;
            case R.id.viewChatOnlineHome:

                break;
            case R.id.viewCodeSearchHome:

                break;
            case R.id.viewAddDriverHome:
                intent2Activity(AddDriverActivity.class);
                break;

        }
    }

    @Override
    public void postQreDriveListResult(List<Device> deviceList) {

    }
}
