package com.ciko.guo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;

import com.ciko.guo.R;

/**
 * 创建时间: 2018/3/20 下午3:49
 * 类描述:
 *
 * @author Ciko
 */
public class SelectSexDialog extends Dialog{


    public SelectSexDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.layout_select_sex);
    }


}
