package com.ciko.guo.activity;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ciko.guo.R;
import com.ciko.guo.base.BaseActivity;
import com.ciko.guo.fragment.HomeFragment;
import com.ciko.guo.fragment.MyDriversFragment;
import com.ciko.guo.fragment.MySaleServerFragment;
import com.ciko.guo.fragment.UserCenterFragment;
import com.ciko.guo.utils.FragmentUtils;

/**
 * 创建时间: 2018/3/19 上午1:30
 * 类描述: 主页
 *
 * @author 木棉
 */
public class HomeActivity extends BaseActivity implements View.OnClickListener {

    private FragmentUtils fragmentUtils;

    private HomeFragment homeFragment;
    private MyDriversFragment myDriversFragment;
    private MySaleServerFragment mySaleServerFragment;
    private UserCenterFragment userCenterFragment;

    private View viewHomeTag;
    private View viewDriversTag;
    private View viewSaleServerTag;
    private View viewUserCenterTag;

    private TextView tvHomeTag;
    private TextView tvDriversTag;
    private TextView tvSaleServerTag;
    private TextView tvUserCenterTag;

    private ImageView ivHomeIcon;
    private ImageView ivDriversIcon;
    private ImageView ivSaleServerIcon;
    private ImageView ivUserCenterIcon;

    @Override
    protected int getLayoutResId() {
        return R.layout.layout_home;
    }

    @Override
    protected void initView() {
        viewHomeTag = findView(R.id.viewHomeTag);
        viewDriversTag = findView(R.id.viewDriversTag);
        viewSaleServerTag = findView(R.id.viewSaleServerTag);
        viewUserCenterTag = findView(R.id.viewUserCenterTag);

        tvHomeTag = findView(R.id.tvHomeTag);
        tvDriversTag = findView(R.id.tvDriversTag);
        tvSaleServerTag = findView(R.id.tvSaleServerTag);
        tvUserCenterTag = findView(R.id.tvUserCenterTag);

        ivHomeIcon = findView(R.id.ivHomeIcon);
        ivDriversIcon = findView(R.id.ivDriversIcon);
        ivSaleServerIcon = findView(R.id.ivSaleServerIcon);
        ivUserCenterIcon = findView(R.id.ivUserCenterIcon);
    }

    @Override
    protected void setListener() {
        viewHomeTag.setOnClickListener(this);
        viewDriversTag.setOnClickListener(this);
        viewSaleServerTag.setOnClickListener(this);
        viewUserCenterTag.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        initFragment();
    }

    private void initFragment() {
        homeFragment = new HomeFragment();
        myDriversFragment = new MyDriversFragment();
        mySaleServerFragment = new MySaleServerFragment();
        userCenterFragment = new UserCenterFragment();

        fragmentUtils = new FragmentUtils(getContext(), R.id.flContainer);
        fragmentUtils.add(homeFragment);
        fragmentUtils.add(myDriversFragment);
        fragmentUtils.add(mySaleServerFragment);
        fragmentUtils.add(userCenterFragment);

        fragmentUtils.show(HomeFragment.class);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.viewHomeTag:
                switchTagPage(1);
                fragmentUtils.show(HomeFragment.class);
                break;
            case R.id.viewDriversTag:
                switchTagPage(2);
                fragmentUtils.show(MyDriversFragment.class);
                break;
            case R.id.viewSaleServerTag:
                switchTagPage(3);
                fragmentUtils.show(MySaleServerFragment.class);
                break;
            case R.id.viewUserCenterTag:
                switchTagPage(4);
                fragmentUtils.show(UserCenterFragment.class);
                break;
        }
    }

    private void switchTagPage(int tag) {

        tvHomeTag.setTextColor(Color.parseColor("#999999"));
        tvDriversTag.setTextColor(Color.parseColor("#999999"));
        tvSaleServerTag.setTextColor(Color.parseColor("#999999"));
        tvUserCenterTag.setTextColor(Color.parseColor("#999999"));

        ivHomeIcon.setImageResource(R.drawable.ic_home_pressed);
        ivDriversIcon.setImageResource(R.drawable.ic_drivers);
        ivSaleServerIcon.setImageResource(R.drawable.ic_sale_server);
        ivUserCenterIcon.setImageResource(R.drawable.ic_user_center);

        switch (tag) {
            case 1:
                tvHomeTag.setTextColor(getContext().getResources().getColor(R.color.theme));
                ivHomeIcon.setImageResource(R.drawable.ic_home_pressed);
                break;
            case 2:
                tvDriversTag.setTextColor(getContext().getResources().getColor(R.color.theme));
                ivDriversIcon.setImageResource(R.drawable.ic_drivers_pressed);
                break;
            case 3:
                tvSaleServerTag.setTextColor(getContext().getResources().getColor(R.color.theme));
                ivSaleServerIcon.setImageResource(R.drawable.ic_sale_server_pressed);
                break;
            case 4:
                tvUserCenterTag.setTextColor(getContext().getResources().getColor(R.color.theme));
                ivUserCenterIcon.setImageResource(R.drawable.ic_user_center_pressed);
                break;
        }

    }

    @Override
    public void onBackPressed() {
        // Do Nothing
    }

}
