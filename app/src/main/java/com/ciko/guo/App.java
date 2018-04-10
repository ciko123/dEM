package com.ciko.guo;

import android.app.Application;

import com.ciko.guo.utils.ContextUtil;
import com.ciko.guo.utils.LogUtil;
import com.ciko.guo.utils.ResourceUtil;
import com.imnjh.imagepicker.PickerConfig;
import com.imnjh.imagepicker.SImagePicker;
import com.orhanobut.hawk.Hawk;


/**
 * 创建时间: 2018/3/29 上午8:55
 * 类描述:
 *
 * @author Ciko
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Hawk.init(this).build();

        LogUtil.init();

        ContextUtil.init(this);

        SImagePicker.init(new PickerConfig.Builder().setAppContext(this)
                .setImageLoader(new GlideImageLoader())
                .setToolbaseColor(getResources().getColor(R.color.colorPrimary)).build());

    }

}
