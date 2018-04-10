package com.ciko.guo.http.business.config;

import com.ciko.guo.UserCache;
import com.ciko.guo.bean.Device;
import com.ciko.guo.bean.DeviceDetial;
import com.ciko.guo.bean.HttpResult;
import com.ciko.guo.bean.Message;
import com.ciko.guo.bean.Order;
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
import com.ciko.guo.http.business.viewIInterface.IModPasswordView;
import com.ciko.guo.http.business.viewIInterface.IQryMsgListView;
import com.ciko.guo.http.business.viewIInterface.IQryOrderObjectView;
import com.ciko.guo.http.business.viewIInterface.IRegisterView;
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
     * 注册
     */
    public static void register(final IRegisterView view, String companyName, String name, String phone, String psw) {

        HttpClient.getIns()
                .service(ApiService.class)
                .addUser(companyName, name, phone, MD5Util.encode(psw))
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())//最后在主线程中执行
                .subscribe(new ResponseBodyCallBack<String>() {
                    @Override
                    protected void success(HttpResult<String> result) {
                        view.postAddUserResult();
                    }
                });

    }

    /**
     * 修改密码
     */
    public static void modPassword(final IModPasswordView view, String oldPassword, String newPassword) {

        HttpClient.getIns()
                .service(ApiService.class)
                .modPassword(MD5Util.encode(oldPassword), MD5Util.encode(newPassword), MD5Util.encode(newPassword))
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())//最后在主线程中执行
                .subscribe(new ResponseBodyCallBack<String>() {
                    @Override
                    protected void success(HttpResult<String> result) {
                        view.postModPasswordResult();
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

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        view.postFail();
                    }
                });
    }

    /**
     * 编辑用户信息
     */
    public static void editAccountInfo(final IEditAccountInfoView view, String cellPhone, String account, String address, String email, String landLine, String invoiceNumber, String sex, String companyUrl, String headImg) {

        UserLogin userTemp = UserCache.getIns().getUserTemp();

        if (cellPhone != null) {
            userTemp.setCellPhone(cellPhone);
        }

        if (account != null) {
            userTemp.setAccount(account);
        }

        if (address != null) {
            userTemp.setAddress(address);
        }

        if (email != null) {
            userTemp.setEmail(email);
        }

        if (landLine != null) {
            userTemp.setLandLine(landLine);
        }

        if (invoiceNumber != null) {
            userTemp.setInvoiceNumber(invoiceNumber);
        }

        if (sex != null) {
            userTemp.setSex(sex);
        }

        if (companyUrl != null) {
            userTemp.setCompanyUrl(companyUrl);
        }

        if (headImg != null) {
            userTemp.setHeadImg(headImg);
        }

        HttpClient.getIns()
                .service(ApiService.class)
                .editAccountInfo(userTemp.getId(), userTemp.getPassword(), userTemp.getCellPhone(), userTemp.getAccount(), userTemp.getAddress(), userTemp.getEmail(), userTemp.getLandLine(), userTemp.getInvoiceNumber(), userTemp.getSex(), userTemp.getCompanyUrl(), userTemp.getHeadImg())
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
    public static void qryMsgList(final IQryMsgListView view, Integer msgType, String title, String status, int yema, int length) {

        HttpClient.getIns()
                .service(ApiService.class)
                .qryMsgList(UserCache.getIns().getUserId(), msgType, title, status, yema, length)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())//最后在主线程中执行
                .subscribe(new ResponseBodyCallBack<Page<Message>>() {
                    @Override
                    protected void success(HttpResult<Page<Message>> result) {
                        view.postIQryMsgListResult(result.getReturnObject());
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        view.postFail();
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

    /**
     * 工单查询
     */
    public static void qryOrderObject(final IQryOrderObjectView view, String orderNo) {

        HttpClient.getIns()
                .service(ApiService.class)
                .qryOrderObject(orderNo)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())//最后在主线程中执行
                .subscribe(new ResponseBodyCallBack<Order>() {
                    @Override
                    protected void success(HttpResult<Order> result) {
                        view.postQryOrderObjectResult(result.getReturnObject());
                    }
                });

    }


}
