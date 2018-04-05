package com.ciko.guo.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ciko.guo.R;
import com.ciko.guo.UserCache;
import com.ciko.guo.base.TitleActivity;
import com.ciko.guo.http.business.config.ApiServiceImp;
import com.ciko.guo.http.business.viewIInterface.IAddMsgInfoView;
import com.ciko.guo.utils.EmptyUtil;
import com.ciko.guo.utils.ToastUtil;
import com.xw.repo.XEditText;

/**
 * 创建时间: 2018/3/19 上午3:20
 * 类描述: 新咨询
 *
 * @author 木棉
 */
public class NewChatActivity extends TitleActivity implements IAddMsgInfoView {

    private XEditText etTitleNewChat;
    private EditText etContextNewChat;
    private Button btnSubmitNewChat;

    @Override
    protected int getContentLayoutResId() {
        return R.layout.layout_new_question;
    }

    @Override
    protected String getTitleName() {
        return "新咨询";
    }

    @Override
    protected void initView() {
        super.initView();
        etTitleNewChat = findView(R.id.etTitleNewChat);
        etContextNewChat = findView(R.id.etContextNewChat);
        btnSubmitNewChat = findView(R.id.btnSubmitNewChat);
    }

    @Override
    protected void setListener() {
        btnSubmitNewChat.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);

        switch (v.getId()) {
            case R.id.btnSubmitNewChat:

                String title = etTitleNewChat.getText().toString();
                String question = etContextNewChat.getText().toString();

                if (checkInputContext(title, question)) {
                    ApiServiceImp.addMsgInfo(this, question, title, 3, UserCache.getIns().getUser().getName());
                }

                break;
        }

    }

    private boolean checkInputContext(String title, String question) {

        if (EmptyUtil.isEmpty(title)) {
            ToastUtil.show("标题不能为空");
            return false;
        }

        if (EmptyUtil.isEmpty(question)) {
            ToastUtil.show("问题描述不能为空");
            return false;
        }

        return true;

    }

    @Override
    public void postAddMsgInfoResult() {
        ToastUtil.show("提交咨询成功");
        finish();
    }

}
