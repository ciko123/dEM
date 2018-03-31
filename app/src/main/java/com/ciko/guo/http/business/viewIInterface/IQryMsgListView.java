package com.ciko.guo.http.business.viewIInterface;

import com.ciko.guo.bean.Message;

import java.util.List;

/**
 * 创建时间: 2018/3/31 下午11:09
 * 类描述:
 *
 * @author Ciko
 */
public interface IQryMsgListView {

    void postIQryMsgListResult(List<Message> userLogin);

}
