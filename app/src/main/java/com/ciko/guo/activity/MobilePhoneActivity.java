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
 * 类描述: 设置手机号
 *
 * @author 木棉
 */
public class MobilePhoneActivity extends TitleActivity implements TitleActivity.OnCliekTitleRightOperateListener, IEditAccountInfoView {

    private EditText etMobilePhoneeUserEdit;

    @Override
    protected int getContentLayoutResId() {
        return R.layout.layout_mobile_phone;
    }

    @Override
    protected String getTitleName() {
        return "设置手机号";
    }

    @Override
    protected void initView() {
        super.initView();
        etMobilePhoneeUserEdit = findView(R.id.etMobilePhoneeUserEdit);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {

        etMobilePhoneeUserEdit.setText(UserCache.getIns().getUser().getCellPhone());

        setTitleRightOperateName("确定", this);


    }

    @Override
    public void OnCliekTitleRightOperate() {

        String mobilePhone = etMobilePhoneeUserEdit.getText().toString();

        if (EmptyUtil.isEmpty(mobilePhone)) {
            ToastUtil.show("手机号不能修改为空");
            return;
        }

        if (mobilePhone.equals(UserCache.getIns().getUser().getCellPhone())) {
            ToastUtil.show("修改的手机号码不能和原来相同");
            return;
        }

        ApiServiceImp.editAccountInfo(this, mobilePhone, null, null, null, null, null, null, null, null);
    }

    @Override
    public void postEditAccountInfResult() {
        ToastUtil.show("修改手机号码成功");
        String mobilePhone = etMobilePhoneeUserEdit.getText().toString();
        UserCache.getIns().getUser().setCellPhone(mobilePhone);
        finish();
    }
}
