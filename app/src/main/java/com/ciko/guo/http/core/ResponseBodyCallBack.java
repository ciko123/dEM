package com.ciko.guo.http.core;

import com.ciko.guo.bean.HttpResult;
import com.ciko.guo.http.business.config.ApiException;
import com.ciko.guo.utils.ContextUtil;
import com.ciko.guo.utils.NetWorkUtil;
import com.ciko.guo.utils.ToastUtil;
import com.google.gson.JsonSyntaxException;

import rx.Subscriber;

/**
 * 创建时间: 2018/3/29 下午3:55
 * 类描述:
 *
 * @author Ciko
 */
public abstract class ResponseBodyCallBack<T> extends Subscriber<HttpResult<T>> {

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

        e.printStackTrace();

        if (!NetWorkUtil.isNetWorkAvailable(ContextUtil.getContext())) { //这里自行替换判断网络的代码
            error("网络不可用");
        } else if (e instanceof ApiException) {
            error(e.getMessage());
        } else if (e instanceof ClassCastException) {
            error("JSON 解析错误");
        } else if (e instanceof JsonSyntaxException) {

        } else {
            error("请求失败，请稍后再试...");
        }
    }

    @Override
    public void onNext(HttpResult<T> result) {
        success(result);
    }

    //    @Override
//    public void onNext(ResponseBody responseBody) {
//        try {
//            String context = responseBody.string();
//            HttpResultCode httpResultCode = JSON.parseObject(context, HttpResultCode.class);
//            if (1000 == httpResultCode.getResultCode()) {
//                HttpResult<UserLogin> httpResult = JSON.parseObject(context, new TypeReference<HttpResult<UserLogin>>() {
//                });
//                success(httpResult);
//            } else {
//                HttpResultError httpResultError = JSON.parseObject(context, HttpResultError.class);
//                error(httpResultError.getReturnObject());
//            }
//        } catch (IOException e) {
//            onError(e);
//        }
//
//    }

    protected abstract void success(HttpResult<T> result);

    protected void error(String message) {
        ToastUtil.show(message);
    }

}
