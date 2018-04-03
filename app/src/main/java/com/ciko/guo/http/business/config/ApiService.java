package com.ciko.guo.http.business.config;


import com.ciko.guo.bean.Device;
import com.ciko.guo.bean.DeviceDetial;
import com.ciko.guo.bean.HttpResult;
import com.ciko.guo.bean.Message;
import com.ciko.guo.bean.Page;
import com.ciko.guo.bean.User;
import com.ciko.guo.bean.UserLogin;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public interface ApiService {

    /**
     * 登录
     *
     * @param account  用户名
     * @param password 密码
     * @param code     验证码
     * @return
     */
    @FormUrlEncoded
    @POST(Url.USER_LOGIN)
    Observable<HttpResult<UserLogin>> login(@Field("account") String account, @Field("password") String password);

    /**
     * 查询个人信息
     */
    @FormUrlEncoded
    @POST(Url.QRY_ACCOUNT_INFO)
    Observable<HttpResult<User>> qryAccountInfo();

    /**
     * 修改个人信息
     *
     * @param id            用户id
     * @param password      密码
     * @param cellPhone     手机号码
     * @param account       账号
     * @param address       地址
     * @param email         邮箱
     * @param landLine      座机
     * @param invoiceNumber 发票
     * @param sex           性别
     */
    @FormUrlEncoded
    @POST(Url.EDIT_ACCOUNT_INFO)
    Observable<HttpResult<String>> editAccountInfo(@Field("id") int id, @Field("password") String password, @Field("cellPhone") String cellPhone, @Field("account") String account, @Field("address") String address, @Field("email") String email, @Field("landLine") String landLine, @Field("invoiceNumber") String invoiceNumber, @Field("sex") String sex);

    /**
     * 添加消息
     *
     * @param userId   用户ID
     * @param question 问题详情描述
     * @param title    标题
     * @param type     类型 1=服务、2=通知
     * @param name     用户姓名
     */
    @FormUrlEncoded
    @POST(Url.ADD_MSG_INFO)
    Observable<HttpResult<String>> addMsgInfo(@Field("userId") Integer userId, @Field("question") String question, @Field("title") String title, @Field("type") Integer type, @Field("name") String name);

    /**
     * 查询消息列表
     *
     * @param userId 用户ID
     * @param title  标题
     * @param status 1=待处理 2=已处理
     * @param yema   页码(可不传)
     * @param length 每页显示个数(可不传)
     * @return
     */
    @FormUrlEncoded
    @POST(Url.QRY_MSG_LIST)
    Observable<HttpResult<Page<Message>>> qryMsgList(@Field("userId") Integer userId, @Field("title") String title, @Field("status") String status, @Field("yema") Integer yema, @Field("length") Integer length);

    /**
     * 查询设备列表
     *
     * @param userId    用户ID
     * @param isAppShow n=不显示的设备 y=显示的设备
     * @param yema      页码(可不传)
     * @param length    每页显示个数(可不传)
     * @param name      设备名称(模糊)
     * @return
     */
    @FormUrlEncoded
    @POST(Url.QRY_DEVICE_LIST)
    Observable<HttpResult<Page<Device>>> qryDeviceList(@Field("userId") Integer userId, @Field("isAppShow") String isAppShow, @Field("yema") Integer yema, @Field("length") Integer length, @Field("name") String name);

    /**
     * 编辑设备
     *
     * @param id        设备ID
     * @param isAppShow 是否显示 y=显示 n=不显示
     * @return
     */
    @FormUrlEncoded
    @POST(Url.EDIT_DEVICE)
    Observable<HttpResult<String>> editDevice(@Field("id") Integer id, @Field("isAppShow") String isAppShow);

    /**
     * 设备详情
     *
     * @param id 设备id
     * @return
     */
    @FormUrlEncoded
    @POST(Url.GET_DEVICE_INFO)
    Observable<HttpResult<DeviceDetial>> getDeviceInfo(@Field("id") Integer id);

    /**
     * 设备详情
     *
     * @param id 设备id
     * @return
     */
    @FormUrlEncoded
    @POST(Url.GET_DEVICE_INFO)
    Observable<HttpResult<DeviceDetial>> qryOrderObject(@Field("orderNo") String orderNo);


}
