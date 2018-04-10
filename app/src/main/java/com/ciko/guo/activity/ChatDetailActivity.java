package com.ciko.guo.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ciko.guo.R;
import com.ciko.guo.UserCache;
import com.ciko.guo.base.TitleActivity;
import com.ciko.guo.bean.Message;
import com.ciko.guo.utils.EmptyUtil;
import com.ciko.guo.utils.TimeUtil;

/**
 * 创建时间: 2018/4/5 下午2:55
 * 类描述:
 *
 * @author Ciko
 */
public class ChatDetailActivity extends TitleActivity {

    private Message message;

    private View rectReplyChatDetail;

    private TextView tvQuestionTitleChatDetail;
    private TextView tvQuestionContextChatDetail;
    private TextView tvReplyContextChatDetail;
    private TextView tvQuestionTimeChatDetail;

    private ImageView ivUserIconChatDetail;

    @Override
    protected int getContentLayoutResId() {
        return R.layout.layout_chat_detail;
    }

    @Override
    protected String getTitleName() {
        return "消息查看";
    }

    @Override
    protected void initView() {
        super.initView();

        rectReplyChatDetail = findView(R.id.rectReplyChatDetail);

        tvQuestionTitleChatDetail = findView(R.id.tvQuestionTitleChatDetail);
        tvQuestionContextChatDetail = findView(R.id.tvQuestionContextChatDetail);
        tvReplyContextChatDetail = findView(R.id.tvReplyContextChatDetail);
        tvQuestionTimeChatDetail = findView(R.id.tvQuestionTimeChatDetail);

        ivUserIconChatDetail = findView(R.id.ivUserIconChatDetail);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {
        message = (Message) getIntent().getSerializableExtra("message");

        Glide.with(getContext()).load(UserCache.getIns().getUser().getHeadImg()).into(ivUserIconChatDetail);

        tvQuestionTitleChatDetail.setText(message.getTitle());
        tvQuestionContextChatDetail.setText(message.getQuestion());
        tvQuestionTimeChatDetail.setText(TimeUtil.millis2String(message.getCreateTime()));

        if (EmptyUtil.isEmpty(message.getReply())) {
            rectReplyChatDetail.setVisibility(View.GONE);
        } else {
            tvReplyContextChatDetail.setText(message.getReply());
        }

    }

}
