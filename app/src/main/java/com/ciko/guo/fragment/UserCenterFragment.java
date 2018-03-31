package com.ciko.guo.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ciko.guo.R;
import com.ciko.guo.UserCache;
import com.ciko.guo.activity.CompanyAddressActivity;
import com.ciko.guo.activity.EmailActivity;
import com.ciko.guo.activity.MobilePhoneActivity;
import com.ciko.guo.activity.PhoneActivity;
import com.ciko.guo.activity.UserNameActivity;
import com.ciko.guo.activity.UserPswActivity;
import com.ciko.guo.base.BaseFragment;
import com.ciko.guo.bean.UserLogin;

/**
 * 创建时间: 2018/3/19 上午2:33
 * 类描述:
 *
 * @author 木棉
 */
public class UserCenterFragment extends BaseFragment implements View.OnClickListener {

    private View viewPswUser;
    private View viewSexUser;
    private View viewIconUser;
    private View viewNameUser;
    private View viewCompayUser;
    private View viewCompayTaxFileNumberUser;
    private View viewEmailUser;
    private View viewMobilePhoneUser;
    private View viewPhoneUser;
    private View viewCompayAdressUser;

    private TextView tvNameUser;
    private TextView tvSexUser;
    private TextView tvCompayUser;
    private TextView tvCompayTaxFileNumberUser;
    private TextView tvMobilePhoneUser;
    private TextView tvPhoneUser;
    private TextView tvEmailUser;
    private TextView tvWebSiteUser;
    private TextView tvCompayAdressUser;
    private TextView viewLoginOutUser;

    private ImageView ivIconUser;


    @Override
    protected int getLayoutResId() {
        return R.layout.layout_page_user_center;
    }

    @Override
    protected void initView() {
        viewPswUser = findView(R.id.viewPswUser);
        viewSexUser = findView(R.id.viewSexUser);
        viewIconUser = findView(R.id.viewIconUser);
        viewNameUser = findView(R.id.viewNameUser);
        viewCompayUser = findView(R.id.viewCompayUser);
        viewCompayTaxFileNumberUser = findView(R.id.viewCompayTaxFileNumberUser);
        viewEmailUser = findView(R.id.viewEmailUser);
        viewMobilePhoneUser = findView(R.id.viewMobilePhoneUser);
        viewPhoneUser = findView(R.id.viewPhoneUser);
        viewCompayAdressUser = findView(R.id.viewCompayAdressUser);

        tvNameUser = findView(R.id.tvNameUser);
        tvSexUser = findView(R.id.tvSexUser);
        tvCompayUser = findView(R.id.tvCompayUser);
        tvCompayTaxFileNumberUser = findView(R.id.tvCompayTaxFileNumberUser);
        tvMobilePhoneUser = findView(R.id.tvMobilePhoneUser);
        tvPhoneUser = findView(R.id.tvPhoneUser);
        tvEmailUser = findView(R.id.tvEmailUser);
        tvWebSiteUser = findView(R.id.tvWebSiteUser);
        tvCompayAdressUser = findView(R.id.tvCompayAdressUser);
        viewLoginOutUser = findView(R.id.viewLoginOutUser);

        ivIconUser = findView(R.id.ivIconUser);
    }

    @Override
    protected void setListener() {
        viewPswUser.setOnClickListener(this);
        viewSexUser.setOnClickListener(this);
        viewIconUser.setOnClickListener(this);
        viewNameUser.setOnClickListener(this);
        viewCompayUser.setOnClickListener(this);
        viewEmailUser.setOnClickListener(this);
        viewMobilePhoneUser.setOnClickListener(this);
        viewPhoneUser.setOnClickListener(this);
        viewCompayAdressUser.setOnClickListener(this);
    }

    @Override
    protected void initData() {

        UserLogin userLogin = UserCache.getIns().getUser();

        tvNameUser.setText(userLogin.getName());
        tvSexUser.setText(userLogin.getSex());
        tvCompayUser.setText(userLogin.getCompanyName());
        tvCompayTaxFileNumberUser.setText(userLogin.getInvoiceNumber());
        tvMobilePhoneUser.setText(userLogin.getCellPhone());
        tvPhoneUser.setText(userLogin.getLandLine());
        tvEmailUser.setText(userLogin.getEmail());
//        tvWebSiteUser.setText(userLogin.getDealerId());
        tvCompayAdressUser.setText(userLogin.getAddress());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.viewPswUser:
                intent2Activity(UserPswActivity.class);
                break;
            case R.id.viewSexUser:

                break;
            case R.id.viewIconUser:

                break;
            case R.id.viewNameUser:
                intent2Activity(UserNameActivity.class);
                break;
            case R.id.viewCompayUser:

                break;
            case R.id.viewEmailUser:
                intent2Activity(EmailActivity.class);
                break;
            case R.id.viewMobilePhoneUser:
                intent2Activity(MobilePhoneActivity.class);
                break;
            case R.id.viewPhoneUser:
                intent2Activity(PhoneActivity.class);
                break;
            case R.id.viewCompayAdressUser:
                intent2Activity(CompanyAddressActivity.class);
                break;
        }
    }

}
