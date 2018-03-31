package com.ciko.guo.bean;

/**
 * 创建时间: 2018/3/29 下午4:18
 * 类描述:
 *
 * @author Ciko
 */
public class HttpResult<T> extends HttpResultCode {

    private T returnObject;

    public T getReturnObject() {
        return returnObject;
    }

    public void setReturnObject(T returnObject) {
        this.returnObject = returnObject;
    }
}
