package com.ciko.guo.http;

import android.widget.Toast;

import com.ciko.guo.BuildConfig;
import com.ciko.guo.activity.LoginActivity;
import com.ciko.guo.base.ActivityLifeCycleEvent;
import com.ciko.guo.bean.UserLogin;
import com.ciko.guo.utils.ContextUtils;

import rx.Observable;

/**
 * 创建时间: 2018/3/29 上午10:42
 * 类描述:
 *
 * @author Ciko
 */
public class ApiServiceImp {

    public static void login(final LoginActivity activity, String account, String password) {
        Observable ob = Api.getDefault().login(account, password, "android", BuildConfig.VERSION_NAME);
        HttpUtil.getInstance()
                .toSubscribe(ob, new ProgressSubscriber<UserLogin>(activity.getContext()) {
            @Override
            protected void _onNext(UserLogin userLogin) {
                activity.loginResult(userLogin);
            }

            @Override
            protected void _onError(String message) {
                Toast.makeText(ContextUtils.getContext(), message, Toast.LENGTH_SHORT).show();
            }

        }, "cacheKey", ActivityLifeCycleEvent.PAUSE, activity.lifecycleSubject, false, false);
    }

}
