package com.ciko.guo.http.business.config;

public interface Url {

    /**
     * 请求地址
     */
    String BASE_URL = "http://47.95.3.231:8090/boilerCloudAPI/";

    /**
     * 登录
     */
    String USER_LOGIN = "userLogin";

    /**
     * 注册
     */
    String ADD_USER = "registerAccount";

    /**
     * 修改密码
     */
    String MOD_PASSWORD = "modPassword";

    /**
     * 查询个人信息
     */
    String QRY_ACCOUNT_INFO = "qryAccountInfo";

    /**
     * 修改个人信息
     */
    String EDIT_ACCOUNT_INFO = "editAccountInfo";

    /**
     * 添加消息
     */
    String ADD_MSG_INFO = "message/addMsgInfo";

    /**
     * 查询消息列表
     */
    String QRY_MSG_LIST = "message/qryMsgList";

    /**
     * 查询设备列表
     */
    String QRY_DEVICE_LIST = "device/qryDeviceList";

    /**
     * 编辑设备
     */
    String EDIT_DEVICE = "device/editDevice";

    /**
     * 设备详情
     */
    String GET_DEVICE_INFO = "device/getDeviceInfo";

    /**
     * 工单查询
     */
    String QRY_ORDER_OBJECT = "order/qryOrderObject";


}
