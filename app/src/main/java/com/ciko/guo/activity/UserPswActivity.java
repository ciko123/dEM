package com.ciko.guo.activity;

import com.ciko.guo.R;
import com.ciko.guo.base.BaseActivity;
import com.ciko.guo.base.TitleActivity;

/**
 * 创建时间: 2018/3/19 上午3:23
 * 类描述: 设置用户密码
 *
 * @author 木棉
 */
public class UserPswActivity extends TitleActivity implements TitleActivity.OnCliekTitleRightOperateListener{

    @Override
    protected int getContentLayoutResId() {
        return R.layout.layout_user_psw;
    }

    @Override
    protected String getTitleName() {
        return "设置用户密码";
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
