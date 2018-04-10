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
 * 类描述: 设置公司网址
 *
 * @author 木棉
 */
public class CompanyWebsiteActivity extends TitleActivity implements TitleActivity.OnCliekTitleRightOperateListener, IEditAccountInfoView {

    private EditText etCompanyWebSiteUserEdit;

    @Override
    protected int getContentLayoutResId() {
        return R.layout.layout_company_website;
    }

    @Override
    protected String getTitleName() {
        return "设置公司网址";
    }

    @Override
    protected void initView() {
        super.initView();

        etCompanyWebSiteUserEdit = findView(R.id.etCompanyWebSiteUserEdit);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {

        etCompanyWebSiteUserEdit.setText(UserCache.getIns().getUser().getCompanyUrl());

        setTitleRightOperateName("确定", this);


    }

    @Override
    public void OnCliekTitleRightOperate() {

        String website = etCompanyWebSiteUserEdit.getText().toString();

        ApiServiceImp.editAccountInfo(this, null, null, null, null, null, null, null, website, null);
    }

    @Override
    public void postEditAccountInfResult() {
        ToastUtil.show("修改网址成功");
        String website = etCompanyWebSiteUserEdit.getText().toString();
        UserCache.getIns().getUser().setCompanyUrl(website);
        finish();
    }

}
