package com.ciko.guo.utils;

import android.widget.Toast;

/**
 * 创建时间: 2018/3/29 上午11:24
 * 类描述:
 *
 * @author Ciko
 */
public class ToastUtil {

    public static void show(Object msg) {
        Toast.makeText(ContextUtils.getContext(), msg.toString(), Toast.LENGTH_SHORT).show();
    }

}
