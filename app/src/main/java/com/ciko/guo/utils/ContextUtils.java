package com.ciko.guo.utils;

import android.app.Application;
import android.content.Context;

/**
 * 创建时间: 2017/8/24 上午11:33
 * 类描述:ContextUtils
 *
 * @author 木棉
 */
public final class ContextUtils {

    private static Application app;

    private ContextUtils() {
    }

    /**
     * 初始化工具类
     *
     * @param app 应用
     */
    public static void init(final Application app) {
        ContextUtils.app = app;
    }

    /**
     * 获取Application
     */
    public static Context getContext() {
        if (app != null) return app;
        throw new NullPointerException("u should init first");
    }

}
