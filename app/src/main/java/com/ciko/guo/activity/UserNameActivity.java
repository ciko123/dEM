package com.ciko.guo.activity;

import com.ciko.guo.R;
import com.ciko.guo.base.TitleActivity;

/**
 * 创建时间: 2018/3/19 上午3:23
 * 类描述:
 *
 * @author 木棉
 */
public class UserNameActivity extends TitleActivity {

    @Override
    protected int getContentLayoutResId() {
        return R.layout.layout_user_name;
    }

    @Override
    protected String getTitleName() {
        return "设置名字";
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {

    }
}
