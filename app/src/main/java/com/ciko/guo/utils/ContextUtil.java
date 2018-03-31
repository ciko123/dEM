package com.ciko.guo.utils;

import android.app.Application;
import android.content.Context;

/**
 * 创建时间: 2017/8/24 上午11:33
 * 类描述:ContextUtil
 *
 * @author 木棉
 */
public final class ContextUtil {

    private static Application app;

    private ContextUtil() {
    }

    /**
     * 初始化工具类
     *
     * @param app 应用
     */
    public static void init(final Application app) {
        ContextUtil.app = app;
    }

    /**
     * 获取Application
     */
    public static Context getContext() {
        if (app != null) return app;
        throw new NullPointerException("u should init first");
    }

}
