package com.ciko.guo.activity;

import android.widget.EditText;

import com.ciko.guo.R;
import com.ciko.guo.UserCache;
import com.ciko.guo.base.TitleActivity;
import com.ciko.guo.http.business.config.ApiServiceImp;
import com.ciko.guo.http.business.viewIInterface.IEditAccountInfoView;
import com.ciko.guo.utils.EmptyUtil;
import com.ciko.guo.utils.ToastUtil;

/**
 * 创建时间: 2018/3/19 上午3:23
 * 类描述: 设置座机号
 *
 * @author 木棉
 */
public class PhoneActivity extends TitleActivity implements TitleActivity.OnCliekTitleRightOperateListener, IEditAccountInfoView {

    private EditText etPhoneUserEdit;

    @Override
    protected int getContentLayoutResId() {
        return R.layout.layout_phone;
    }

    @Override
    protected String getTitleName() {
        return "设置座机号";
    }

    @Override
    protected void initView() {
        super.initView();

        etPhoneUserEdit = findView(R.id.etPhoneUserEdit);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {

        etPhoneUserEdit.setText(UserCache.getIns().getUser().getLandLine());

        setTitleRightOperateName("确定", this);
    }

    @Override
    public void OnCliekTitleRightOperate() {
        String phone = etPhoneUserEdit.getText().toString();

        if (EmptyUtil.isEmpty(phone)) {
            ToastUtil.show("座机号码不能修改为空");
            return;
        }

        if (phone.equals(UserCache.getIns().getUser().getLandLine())) {
            ToastUtil.show("修改的座机号码不能和原来相同");
            return;
        }

        ApiServiceImp.editAccountInfo(this, null, null, null, null, phone, null, null, null, null);
    }

    @Override
    public void postEditAccountInfResult() {
        ToastUtil.show("修改座机号号码成功");
        String phone = etPhoneUserEdit.getText().toString();
        UserCache.getIns().getUser().setLandLine(phone);
        finish();
    }
}
