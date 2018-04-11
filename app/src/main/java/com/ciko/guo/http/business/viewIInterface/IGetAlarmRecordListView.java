package com.ciko.guo.http.business.viewIInterface;

import com.ciko.guo.bean.WarmInfo;

import java.util.List;

/**
 * 创建时间: 2018/4/11 下午6:33
 * 类描述:
 *
 * @author Ciko
 */
public interface IGetAlarmRecordListView {

    void postAlarmRecordListResult(List<WarmInfo> warmInfoList);

}
