package com.ciko.guo.http.business.config;

import com.ciko.guo.UserCache;
import com.ciko.guo.bean.Device;
import com.ciko.guo.bean.DeviceDetial;
import com.ciko.guo.bean.HttpResult;
import com.ciko.guo.bean.Message;
import com.ciko.guo.bean.Page;
import com.ciko.guo.bean.User;
import com.ciko.guo.bean.UserLogin;
import com.ciko.guo.http.business.viewIInterface.IAccountInfo;
import com.ciko.guo.http.business.viewIInterface.IAddMsgInfoView;
import com.ciko.guo.http.business.viewIInterface.IDeviceDetial;
import com.ciko.guo.http.business.viewIInterface.IDriverListView;
import com.ciko.guo.http.business.viewIInterface.IEditAccountInfoView;
import com.ciko.guo.http.business.viewIInterface.IEditDeviceView;
import com.ciko.guo.http.business.viewIInterface.ILoginView;
import com.ciko.guo.http.business.viewIInterface.IQryMsgListView;
import com.ciko.guo.http.core.HttpClient;
import com.ciko.guo.http.core.ResponseBodyCallBack;
import com.ciko.guo.utils.MD5Util;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 创建时间: 2018/3/29 下午4:51
 * 类描述:
 *
 * @author Ciko
 */
public class ApiServiceImp {

    /**
     * 登录
     */
    public static void login(final ILoginView view, String phone, String psw) {

        HttpClient.getIns()
                .service(ApiService.class)
                .login(phone, MD5Util.encode(psw))
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())//最后在主线程中执行
                .subscribe(new ResponseBodyCallBack<UserLogin>() {
                    @Override
                    protected void success(HttpResult<UserLogin> result) {
                        UserCache.init(result.getReturnObject());
                        view.postUserLoginResult();
                    }
                });

    }

    /**
     * 查询用户信息
     */
    public static void qryAccountInfo(final IAccountInfo view) {

        HttpClient.getIns()
                .service(ApiService.class)
                .qryAccountInfo()
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())//最后在主线程中执行
                .subscribe(new ResponseBodyCallBack<User>() {
                    @Override
                    protected void success(HttpResult<User> result) {
                        view.postQryAccountInfoResult(result.getReturnObject());
                    }
                });

    }

    /**
     * 查询设备列表
     */
    public static void qryDeviceList(final IDriverListView view, String isAppShow, Integer yema, Integer length, String name) {

        HttpClient.getIns()
                .service(ApiService.class)
                .qryDeviceList(1, isAppShow, yema, length, name)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())//最后在主线程中执行
                .subscribe(new ResponseBodyCallBack<Page<Device>>() {
                    @Override
                    protected void success(HttpResult<Page<Device>> result) {
                        view.postQreDriveListResult(result.getReturnObject());
                    }
                });
    }

    /**
     * 编辑用户信息
     */
    public static void editAccountInfo(final IEditAccountInfoView view, String cellPhone, String account, String address, String email, String landLine, String invoiceNumber, String sex) {

        UserLogin user = UserCache.getIns().getUser();

        HttpClient.getIns()
                .service(ApiService.class)
                .editAccountInfo(user.getId(), user.getPassword(), user.getCellPhone(), user.getAccount(), user.getAddress(), user.getEmail(), user.getLandLine(), user.getInvoiceNumber(), user.getSex())
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())//最后在主线程中执行
                .subscribe(new ResponseBodyCallBack<String>() {
                    @Override
                    protected void success(HttpResult<String> result) {
                        view.postEditAccountInfResult();
                    }
                });

    }

    /**
     * 添加消息
     */
    public static void addMsgInfo(final IAddMsgInfoView view, String question, String title, Integer type, String name) {

        HttpClient.getIns()
                .service(ApiService.class)
                .addMsgInfo(UserCache.getIns().getUserId(), question, title, type, name)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())//最后在主线程中执行
                .subscribe(new ResponseBodyCallBack<String>() {
                    @Override
                    protected void success(HttpResult<String> result) {
                        view.postAddMsgInfoResult();
                    }
                });

    }

    /**
     * 查询消息列表
     */
    public static void qryMsgList(final IQryMsgListView view, String title, String status, int yema, int length) {

        HttpClient.getIns()
                .service(ApiService.class)
                .qryMsgList(UserCache.getIns().getUserId(), title, status, yema, length)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())//最后在主线程中执行
                .subscribe(new ResponseBodyCallBack<Page<Message>>() {
                    @Override
                    protected void success(HttpResult<Page<Message>> result) {
                        view.postIQryMsgListResult(result.getReturnObject());
                    }
                });


    }

    /**
     * 编辑设备
     */
    public static void editDevice(final IEditDeviceView view, Integer id, String isAppShow) {

        HttpClient.getIns()
                .service(ApiService.class)
                .editDevice(id, isAppShow)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())//最后在主线程中执行
                .subscribe(new ResponseBodyCallBack<String>() {
                    @Override
                    protected void success(HttpResult<String> result) {
                        view.postIEditDeviceResult();
                    }
                });

    }

    /**
     * 设备详情
     */
    public static void getDeviceInfo(final IDeviceDetial view, Integer id) {

        HttpClient.getIns()
                .service(ApiService.class)
                .getDeviceInfo(id)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())//最后在主线程中执行
                .subscribe(new ResponseBodyCallBack<DeviceDetial>() {
                    @Override
                    protected void success(HttpResult<DeviceDetial> result) {
                        view.postGetDeviceInfooResult(result.getReturnObject());
                    }
                });

    }

}
