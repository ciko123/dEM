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
 * 类描述: 设置邮箱
 *
 * @author 木棉
 */
public class EmailActivity extends TitleActivity implements TitleActivity.OnCliekTitleRightOperateListener, IEditAccountInfoView {

    private EditText etEmailUserEdit;

    @Override
    protected int getContentLayoutResId() {
        return R.layout.layout_email;
    }

    @Override
    protected String getTitleName() {
        return "设置邮箱";
    }

    @Override
    protected void initView() {
        super.initView();
        etEmailUserEdit = findView(R.id.etEmailUserEdit);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {
        etEmailUserEdit.setText(UserCache.getIns().getUser().getEmail());

        setTitleRightOperateName("确定", this);
    }

    @Override
    public void OnCliekTitleRightOperate() {
        String emailEdit = etEmailUserEdit.getText().toString();
        String email = UserCache.getIns().getUser().getEmail();

        if (EmptyUtil.isEmpty(emailEdit)) {
            ToastUtil.show("邮箱不能为空");
            return;
        }

        if (email.equals(emailEdit)) {
            ToastUtil.show("修改的邮箱不能和原来相同");
            return;
        }

        ApiServiceImp.editAccountInfo(this, null, null, null, emailEdit, null, null, null, null, null);
    }

    @Override
    public void postEditAccountInfResult() {
        String emailEdit = etEmailUserEdit.getText().toString();
        UserCache.getIns().getUser().setEmail(emailEdit);
        ToastUtil.show("修改邮箱成功");
        finish();
    }

}
