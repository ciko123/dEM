package com.ciko.guo.http;


import com.ciko.guo.enity.HttpResult;
import com.ciko.guo.enity.UserEntity;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public interface ApiService {

    /**
     * 登录
     *
     * @param account     用户名
     * @param password    密码
     * @param accountType 账号类型
     * @param clientType  客户端类型
     */
    @FormUrlEncoded
    @POST(Url.USER_LOGIN)
    Observable<HttpResult<UserEntity>> login(@Field("account") String account, @Field("password") String password, @Field("accountType") String accountType, @Field("clientType") String clientType);


    /**
     * 查询个人信息
     *
     * @param account     用户名
     * @param accountType 账号类型
     * @param clientType  客户端类型
     */
    @FormUrlEncoded
    @POST(Url.QRY_ACCOUNT_INFO)
    Observable<HttpResult<UserEntity>> qryAccountInfo(@Field("account") String account, @Field("accountType") String accountType, @Field("clientType") String clientType);

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
     * @param accountType   账号类型
     * @param clientType    客户端类型
     */
    @FormUrlEncoded
    @POST(Url.EDIT_ACCOUNT_INFO)
    Observable<HttpResult<UserEntity>> editAccountInfo(@Field("id") int id, @Field("password") String password, @Field("cellPhone") String cellPhone, @Field("account") String account, @Field("address") String address, @Field("email") String email, @Field("landLine") String landLine, @Field("invoiceNumber") String invoiceNumber, @Field("sex") String sex, @Field("accountType") String accountType, @Field("clientType") String clientType);

    /**
     * 添加消息
     *
     * @param userId   用户ID
     * @param question 问题详情描述
     * @param title    标题
     * @param type     类型 1=服务、2=通知
     * @param name     用户姓名
     * @param account  用户账号
     */
    @FormUrlEncoded
    @POST(Url.ADD_MSG_INFO)
    Observable<HttpResult<UserEntity>> addMsgInfo(@Field("userId") int userId, @Field("question") String question, @Field("title") String title, @Field("type") int type, @Field("name") String name, @Field("account") String account);

    /**
     * 查询消息列表
     *
     * @param userId 用户ID
     * @param title  标题
     * @param status 1=待处理 2=已处理
     */
    @FormUrlEncoded
    @POST(Url.QRY_MSG_LIST)
    Observable<HttpResult<UserEntity>> qryMsgList(@Field("userId") int userId, @Field("title") String title, @Field("status") String status);

    /**
     * 查询设备列表
     *
     * @param userId 用户ID
     * @param title  标题
     * @param status 1=待处理 2=已处理
     * @return
     */
    @FormUrlEncoded
    @POST(Url.QRY_DEVICE_LIST)
    Observable<HttpResult<UserEntity>> qryDeviceList(@Field("userId") int userId, @Field("title") String title, @Field("status") String status);

    /**
     * 编辑设备
     *
     * @param id        设备ID
     * @param isAppShow 是否显示 y=显示 n=不显示
     * @return
     */
    @FormUrlEncoded
    @POST(Url.EDIT_DEVICE)
    Observable<HttpResult<UserEntity>> editDevice(@Field("id") int id, @Field("isAppShow") String isAppShow);


}
