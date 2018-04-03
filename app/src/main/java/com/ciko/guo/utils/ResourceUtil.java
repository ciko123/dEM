package com.ciko.guo.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;

public class ResourceUtil {

    private static Context getContext() {
        return ContextUtil.getContext();
    }

    public static String getString(@StringRes int id) {
        return getContext().getString(id);
    }

    public static String getString(@StringRes int id, Object... format) {
        return getContext().getString(id, format);
    }

    public static int getColor(@ColorRes int id) {
        return ContextCompat.getColor(getContext(), id);
    }

    public static Drawable getDrawable(@DrawableRes int id) {
        return ContextCompat.getDrawable(getContext(), id);
    }

}