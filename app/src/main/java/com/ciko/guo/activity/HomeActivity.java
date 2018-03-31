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
import com.ciko.guo.utils.FragmentUtil;

/**
 * 创建时间: 2018/3/19 上午1:30
 * 类描述: 主页
 *
 * @author 木棉
 */
public class HomeActivity extends BaseActivity implements View.OnClickListener {

    private FragmentUtil fragmentUtil;

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


//        //获取豆瓣电影TOP 100
//        Observable ob = Api.getDefault().getTopMovie(0, 100);
//        HttpUtil.getInstance().toSubscribe(ob, new ProgressSubscriber<List<Subject>>(this) {
//            @Override
//            protected void _onError(String message) {
//                Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            protected void _onNext(List<Subject> list) {
//                if (EmptyUtil.isNotEmpty(list)) {
//                    for (Subject subject : list) {
//                        System.out.println(subject.toString());
//                    }
//                }
//            }
//
//        }, "cacheKey", ActivityLifeCycleEvent.PAUSE, lifecycleSubject, false, false);

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(Url.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        BlogService service = retrofit.create(BlogService.class);
//
//        Call<ResponseBody> call = service.getTopMovie(0, 100);
//        // 用法和OkHttp的call如出一辙,
//        // 不同的是如果是Android系统回调方法执行在主线程
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                try {
//                    System.out.println(response.body().string());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });

    }

    private void initFragment() {
        homeFragment = new HomeFragment();
        myDriversFragment = new MyDriversFragment();
        mySaleServerFragment = new MySaleServerFragment();
        userCenterFragment = new UserCenterFragment();

        fragmentUtil = new FragmentUtil(getContext(), R.id.flContainer);
        fragmentUtil.add(homeFragment);
        fragmentUtil.add(myDriversFragment);
        fragmentUtil.add(mySaleServerFragment);
        fragmentUtil.add(userCenterFragment);

        fragmentUtil.show(HomeFragment.class);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.viewHomeTag:
                switchTagPage(1);
                fragmentUtil.show(HomeFragment.class);
                break;
            case R.id.viewDriversTag:
                switchTagPage(2);
                fragmentUtil.show(MyDriversFragment.class);
                break;
            case R.id.viewSaleServerTag:
                switchTagPage(3);
                fragmentUtil.show(MySaleServerFragment.class);
                break;
            case R.id.viewUserCenterTag:
                switchTagPage(4);
                fragmentUtil.show(UserCenterFragment.class);
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
