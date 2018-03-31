package com.ciko.guo.utils;


import com.google.gson.Gson;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

public class LogUtil {

    private LogUtil() {
    }

    public static void init() {
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(true)  // (Optional) Whether to show thread info or not. Default true
                .methodCount(2)         // (Optional) How many method line to show. Default 2
                .methodOffset(5)        // (Optional) Hides internal method calls up to offset. Default 5
//                .logStrategy(customLog) // (Optional) Changes the log strategy to print out. Default LogCat
//                .tag("My custom tag")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build();

        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
    }

    public static void v(String logMsg) {
        Logger.v(logMsg);
    }

    public static void v(String tag, String logMsg) {
        Logger.t(tag).v(logMsg);
    }

    public static void w(String logMsg) {
        Logger.w(logMsg);
    }

    public static void w(String tag, String logMsg) {
        Logger.t(tag).w(logMsg);
    }

    public static void d(String logMsg) {
        Logger.d(logMsg);
    }

    public static void d(String tag, String logMsg) {
        Logger.t(tag).d(logMsg);
    }

    public static void e(String logMsg) {
        Logger.e(logMsg);
    }

    public static void e(String tag, String logMsg) {
        Logger.t(tag).e(logMsg);
    }

    public static void obj(Object object) {
        Logger.json(new Gson().toJson(object));
    }

    public static void obj(String tag, Object object) {
        Logger.t(tag).json(new Gson().toJson(object));
    }

    public static void json(String json) {
        Logger.json(json);
    }

    public static void json(String tag, String json) {
        Logger.t(tag).json(json);
    }


}
