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
 * 类描述:
 *
 * @author 木棉
 */
public class UserNameActivity extends TitleActivity implements TitleActivity.OnCliekTitleRightOperateListener, IEditAccountInfoView {

    private EditText etNameUserEdit;

    @Override
    protected int getContentLayoutResId() {
        return R.layout.layout_user_name;
    }

    @Override
    protected String getTitleName() {
        return "设置名字";
    }

    @Override
    protected void initView() {
        super.initView();

        etNameUserEdit = findView(R.id.etNameUserEdit);

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {

        etNameUserEdit.setText(UserCache.getIns().getUser().getName());

        setTitleRightOperateName("确定", this);
    }

    @Override
    public void OnCliekTitleRightOperate() {
        String nameEdit = etNameUserEdit.getText().toString();
        String name = UserCache.getIns().getUser().getName();

        if (EmptyUtil.isEmpty(nameEdit)) {
            ToastUtil.show("名字不能为空");
            return;
        }

        if (name.equals(nameEdit)) {
            ToastUtil.show("修改的名字不能和原来相同");
            return;
        }

        ApiServiceImp.editAccountInfo(this, null, nameEdit, null, null, null, null, null, null, null);

    }

    @Override
    public void postEditAccountInfResult() {
        String nameEdit = etNameUserEdit.getText().toString();
        UserCache.getIns().getUser().setName(nameEdit);
        ToastUtil.show("修改名字成功");
        finish();
    }
}
