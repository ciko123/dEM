package com.ciko.guo.activity;

import com.ciko.guo.R;
import com.ciko.guo.base.TitleActivity;

/**
 * 创建时间: 2018/3/19 上午3:23
 * 类描述: 设置公司税号
 *
 * @author 木棉
 */
public class CompanyTaxFileNumberActivity extends TitleActivity implements TitleActivity.OnCliekTitleRightOperateListener{

    @Override
    protected int getContentLayoutResId() {
        return R.layout.layout_company_tax_file_number;
    }

    @Override
    protected String getTitleName() {
        return "设置公司税号";
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {
        setTitleRightOperateName("确定", this);
    }

    @Override
    public void OnCliekTitleRightOperate() {

    }
}
