package com.ciko.guo.http.business.viewIInterface;

import com.ciko.guo.bean.Page;
import com.ciko.guo.bean.Device;

/**
 * 创建时间: 2018/3/29 下午1:14
 * 类描述:
 *
 * @author Ciko
 */
public interface IDriverListView {

    void postQreDriveListResult(Page<Device> devicePage);

}
