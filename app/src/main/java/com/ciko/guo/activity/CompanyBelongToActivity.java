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
 * 类描述: 设置所属于企业
 *
 * @author 木棉
 */
public class CompanyBelongToActivity extends TitleActivity implements TitleActivity.OnCliekTitleRightOperateListener, IEditAccountInfoView {

    private EditText etCompanyNameUserEdit;

    @Override
    protected int getContentLayoutResId() {
        return R.layout.layout_company_belong_to;
    }

    @Override
    protected String getTitleName() {
        return "设置所属于企业";
    }

    @Override
    protected void initView() {
        super.initView();
        etCompanyNameUserEdit = findView(R.id.etCompanyNameUserEdit);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {

        etCompanyNameUserEdit.setText(UserCache.getIns().getUser().getCompanyName());

        setTitleRightOperateName("确定", this);
    }

    @Override
    public void OnCliekTitleRightOperate() {

        String companyNameEdit = etCompanyNameUserEdit.getText().toString();
        String companyName = UserCache.getIns().getUser().getCompanyName();

        if (EmptyUtil.isEmpty(companyNameEdit)) {
            ToastUtil.show("公司名字不能为空");
            return;
        }

        if (companyName.equals(companyNameEdit)) {
            ToastUtil.show("修改的公司名字不能和原来相同");
            return;
        }


        ApiServiceImp.editAccountInfo(this, null, null, null, null, null, null, null, null, null);
    }

    @Override
    public void postEditAccountInfResult() {
        String companyNameEdit = etCompanyNameUserEdit.getText().toString();
        UserCache.getIns().getUser().setCompanyName(companyNameEdit);
        ToastUtil.show("修改公司名成功");
        finish();
    }
}
