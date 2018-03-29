package com.ciko.guo.http.core;

import android.widget.Toast;

import com.ciko.guo.UserCache;
import com.ciko.guo.activity.LoginActivity;
import com.ciko.guo.base.ActivityLifeCycleEvent;
import com.ciko.guo.base.BaseActivity;
import com.ciko.guo.bean.UserLogin;
import com.ciko.guo.http.business.config.Api;
import com.ciko.guo.http.business.viewIInterface.IDriverListView;
import com.ciko.guo.utils.ContextUtils;

import okhttp3.ResponseBody;
import rx.Observable;

/**
 * 创建时间: 2018/3/29 上午10:42
 * 类描述:
 *
 * @author Ciko
 */
public class ApiServiceImp {

    public static void login(final LoginActivity activity, String account, String password) {
        Observable ob = Api.getDefault().login(account, password);
        HttpUtil.getInstance()
                .toSubscribe(ob, new ProgressSubscriber<UserLogin>(activity.getContext()) {
                    @Override
                    protected void _onNext(UserLogin userLogin) {
                        activity.postUserLoginResult(userLogin);
                    }

                    @Override
                    protected void _onError(String message) {
                        Toast.makeText(ContextUtils.getContext(), message, Toast.LENGTH_SHORT).show();
                    }

                }, "cacheKey", ActivityLifeCycleEvent.PAUSE, activity.lifecycleSubject, false, false);
    }

    public static void getDriveList(BaseActivity activity, final IDriverListView iDriverListView, int yema, int length, String name) {
        Observable ob = Api.getDefault().qryDeviceList(UserCache.getIns().getUserId(), "y", yema, length, name);
        HttpUtil.getInstance()
                .toSubscribe(ob, new ProgressSubscriber<ResponseBody>(activity.getContext()) {

                    @Override
                    protected void _onNext(ResponseBody responseBody) {

                    }

                    @Override
                    protected void _onError(String message) {

                    }

                }, "cacheKey", ActivityLifeCycleEvent.PAUSE, activity.lifecycleSubject, false, false);
    }


}
