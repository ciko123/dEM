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
 * 类描述: 设置公司税号
 *
 * @author 木棉
 */
public class CompanyTaxFileNumberActivity extends TitleActivity implements TitleActivity.OnCliekTitleRightOperateListener, IEditAccountInfoView {

    private EditText etCompanyTaxFileNumberUserEdit;

    @Override
    protected int getContentLayoutResId() {
        return R.layout.layout_company_tax_file_number;
    }

    @Override
    protected String getTitleName() {
        return "设置公司税号";
    }

    @Override
    protected void initView() {
        super.initView();
        etCompanyTaxFileNumberUserEdit = findView(R.id.etCompanyTaxFileNumberUserEdit);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {

        etCompanyTaxFileNumberUserEdit.setText(UserCache.getIns().getUser().getInvoiceNumber());

        setTitleRightOperateName("确定", this);
    }

    @Override
    public void OnCliekTitleRightOperate() {

        String companyTaxFileNumber = etCompanyTaxFileNumberUserEdit.getText().toString();


        ApiServiceImp.editAccountInfo(this, null, null, null, null, null, companyTaxFileNumber, null, null, null);
    }

    @Override
    public void postEditAccountInfResult() {
        String companyTaxFileNumber = etCompanyTaxFileNumberUserEdit.getText().toString();
        UserCache.getIns().getUser().setCompanyName(companyTaxFileNumber);
        ToastUtil.show("修改公司税号成功");
        finish();
    }
}
