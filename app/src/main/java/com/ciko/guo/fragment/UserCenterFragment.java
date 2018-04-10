package com.ciko.guo.fragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ciko.guo.R;
import com.ciko.guo.UserCache;
import com.ciko.guo.activity.CompanyAddressActivity;
import com.ciko.guo.activity.CompanyBelongToActivity;
import com.ciko.guo.activity.CompanyTaxFileNumberActivity;
import com.ciko.guo.activity.CompanyWebsiteActivity;
import com.ciko.guo.activity.EmailActivity;
import com.ciko.guo.activity.LoginActivity;
import com.ciko.guo.activity.MobilePhoneActivity;
import com.ciko.guo.activity.PhoneActivity;
import com.ciko.guo.activity.UserNameActivity;
import com.ciko.guo.activity.UserPswActivity;
import com.ciko.guo.base.BaseFragment;
import com.ciko.guo.bean.UserLogin;
import com.ciko.guo.dialog.SelectSexDialog;
import com.ciko.guo.http.business.config.ApiServiceImp;
import com.ciko.guo.http.business.viewIInterface.IEditAccountInfoView;
import com.ciko.guo.utils.ToastUtil;
import com.imnjh.imagepicker.SImagePicker;
import com.imnjh.imagepicker.activity.PhotoPickerActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建时间: 2018/3/19 上午2:33
 * 类描述:
 *
 * @author 木棉
 */
public class UserCenterFragment extends BaseFragment implements View.OnClickListener, IEditAccountInfoView {

    public static final int REQUEST_CODE_AVATAR = 100;

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
    private View viewCompanyWebSiteUser;

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

    private String sex;

    private SelectSexDialog selectSexDialog;

    private List<Uri> mSelected;

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
        viewCompanyWebSiteUser = findView(R.id.viewCompanyWebSiteUser);

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
        viewCompayTaxFileNumberUser.setOnClickListener(this);
        viewCompanyWebSiteUser.setOnClickListener(this);
        viewLoginOutUser.setOnClickListener(this);
    }

    @Override
    protected void initData() {

        UserLogin userLogin = UserCache.getIns().getUser();

        Glide.with(getContext()).load(userLogin.getHeadImg()).into(ivIconUser);

        tvNameUser.setText(userLogin.getName());
        tvCompayUser.setText(userLogin.getCompanyName());
        tvCompayTaxFileNumberUser.setText(userLogin.getInvoiceNumber());
        tvMobilePhoneUser.setText(userLogin.getCellPhone());
        tvPhoneUser.setText(userLogin.getLandLine());
        tvEmailUser.setText(userLogin.getEmail());
        tvWebSiteUser.setText(userLogin.getCompanyUrl());
        tvCompayAdressUser.setText(userLogin.getAddress());

        if (userLogin.getSex() != null) {
            tvSexUser.setText(userLogin.getSex().equals("1") ? "男" : "女");
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.viewPswUser:
                intent2Activity(UserPswActivity.class);
                break;
            case R.id.viewSexUser:
                selectSexDialog = new SelectSexDialog(getContext());
                selectSexDialog.setListener(new SelectSexDialog.OnSelectSexDialogListener() {
                    @Override
                    public void onSelectSexDialog(String sex) {
                        UserCenterFragment.this.sex = sex;
                        ApiServiceImp.editAccountInfo(UserCenterFragment.this, null, null, null, null, null, null, sex, null, null);
                    }
                });
                selectSexDialog.show();
                break;
            case R.id.viewIconUser:
//                SelectPicWayDialog selectPicWayDialog = new SelectPicWayDialog(getContext());
//                selectPicWayDialog.show();
                break;
            case R.id.viewNameUser:
                intent2Activity(UserNameActivity.class);
                break;
            case R.id.viewCompayUser:
                intent2Activity(CompanyBelongToActivity.class);
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
            case R.id.viewCompayTaxFileNumberUser:
                intent2Activity(CompanyTaxFileNumberActivity.class);
                break;
            case R.id.viewCompanyWebSiteUser:
                intent2Activity(CompanyWebsiteActivity.class);
                break;
            case R.id.viewLoginOutUser:
                UserCache.getIns().clear();
                intent2ActivityWithFinish(LoginActivity.class);
                break;
        }
    }

    @Override
    public void postEditAccountInfResult() {
        ToastUtil.show("修改性别成功");

        selectSexDialog.dismiss();

        UserCache.getIns().getUser().setSex(sex);
        initData();
    }

}
