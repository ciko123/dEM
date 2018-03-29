package com.ciko.guo.http.business.viewIInterface;

import com.ciko.guo.bean.Device;

import java.util.List;

/**
 * 创建时间: 2018/3/29 下午1:14
 * 类描述:
 *
 * @author Ciko
 */
public interface IDriverListView {

    void postQreDriveListResult(List<Device> deviceList);

}
