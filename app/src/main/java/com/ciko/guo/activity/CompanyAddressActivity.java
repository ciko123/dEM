package com.ciko.guo.activity;

import android.widget.EditText;

import com.ciko.guo.R;
import com.ciko.guo.UserCache;
import com.ciko.guo.base.TitleActivity;
import com.ciko.guo.http.business.config.ApiServiceImp;
import com.ciko.guo.http.business.viewIInterface.IEditAccountInfoView;
import com.ciko.guo.utils.ToastUtil;

/**
 * 创建时间: 2018/3/19 上午3:23
 * 类描述: 设置公司地址
 *
 * @author 木棉
 */
public class CompanyAddressActivity extends TitleActivity implements TitleActivity.OnCliekTitleRightOperateListener, IEditAccountInfoView {

    private EditText etCompanyAddressUserEdit;

    @Override
    protected int getContentLayoutResId() {
        return R.layout.layout_company_address;
    }

    @Override
    protected String getTitleName() {
        return "设置公司地址";
    }

    @Override
    protected void initView() {
        super.initView();
        etCompanyAddressUserEdit = findView(R.id.etCompanyAddressUserEdit);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {
        etCompanyAddressUserEdit.setText(UserCache.getIns().getUser().getAddress());
        setTitleRightOperateName("确定", this);
    }

    @Override
    public void OnCliekTitleRightOperate() {
        String companyAddress = etCompanyAddressUserEdit.getText().toString();
        ApiServiceImp.editAccountInfo(this, null, null, companyAddress, null, null, null, null, null, null);
    }

    @Override
    public void postEditAccountInfResult() {
        String companyAddress = etCompanyAddressUserEdit.getText().toString();
        UserCache.getIns().getUser().setCompanyName(companyAddress);
        ToastUtil.show("修改公司地址成功");
        finish();
    }

}
