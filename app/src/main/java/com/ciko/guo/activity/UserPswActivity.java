package com.ciko.guo.activity;

import android.view.View;
import android.widget.Button;

import com.ciko.guo.R;
import com.ciko.guo.base.TitleActivity;
import com.ciko.guo.http.business.config.ApiServiceImp;
import com.ciko.guo.http.business.viewIInterface.IModPasswordView;
import com.ciko.guo.utils.EmptyUtil;
import com.ciko.guo.utils.ToastUtil;
import com.xw.repo.XEditText;

/**
 * 创建时间: 2018/3/19 上午3:23
 * 类描述: 设置用户密码
 *
 * @author 木棉
 */
public class UserPswActivity extends TitleActivity implements TitleActivity.OnCliekTitleRightOperateListener, IModPasswordView {

    private XEditText etPswOldUserEdit;
    private XEditText etPswNewUserEdit;
    private XEditText etPswNewRepetitionUserEdit;

    private Button btnSaveNewPsw;

    @Override
    protected int getContentLayoutResId() {
        return R.layout.layout_user_psw;
    }

    @Override
    protected String getTitleName() {
        return "设置用户密码";
    }

    @Override
    protected void initView() {
        super.initView();

        etPswOldUserEdit = findView(R.id.etPswOldUserEdit);
        etPswNewUserEdit = findView(R.id.etPswNewUserEdit);
        etPswNewRepetitionUserEdit = findView(R.id.etPswNewRepetitionUserEdit);
        btnSaveNewPsw = findView(R.id.btnSaveNewPsw);

    }

    @Override
    protected void setListener() {
        btnSaveNewPsw.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        setTitleRightOperateName("确定", this);
    }

    @Override
    public void OnCliekTitleRightOperate() {

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);

        switch (v.getId()) {
            case R.id.btnSaveNewPsw:

                String oldPsw = etPswOldUserEdit.getText().toString();
                String newPsw = etPswNewUserEdit.getText().toString();
                String reNewPsw = etPswNewRepetitionUserEdit.getText().toString();

                if (checkInputContent(oldPsw, newPsw, reNewPsw)) {
                    ApiServiceImp.modPassword(this, oldPsw, newPsw);
                }

                break;
        }
    }

    private boolean checkInputContent(String oldPsw, String newPsw, String reNewPsw) {

        if (EmptyUtil.isEmpty(oldPsw)) {
            ToastUtil.show("请输入原来的密码");
            return false;
        }

        if (EmptyUtil.isEmpty(newPsw)) {
            ToastUtil.show("请输入新的密码");
            return false;
        }

        if (EmptyUtil.isEmpty(reNewPsw)) {
            ToastUtil.show("请再次输入新密码");
            return false;
        }

        if (!newPsw.equals(reNewPsw)) {
            ToastUtil.show("两次输入的新密码不一致");
            return false;
        }

        return true;
    }

    @Override
    public void postModPasswordResult() {
        ToastUtil.show("密码修改成功");
        finish();
    }
}
