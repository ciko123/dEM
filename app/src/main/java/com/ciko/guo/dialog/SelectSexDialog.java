package com.ciko.guo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.ciko.guo.R;

/**
 * 创建时间: 2018/3/20 下午3:49
 * 类描述:
 *
 * @author Ciko
 */
public class SelectSexDialog extends Dialog implements View.OnClickListener {

    private View bgSelectSex;

    private TextView viewManSelectSex;
    private TextView viewWomanSelectSex;
    private TextView viewCannelSelectSex;

    public SelectSexDialog(@NonNull Context context) {
        super(context, R.style.Dialog);
        setContentView(R.layout.layout_select_sex);


        bgSelectSex = findViewById(R.id.bgSelectSex);
        viewManSelectSex = (TextView) findViewById(R.id.viewManSelectSex);
        viewWomanSelectSex = (TextView) findViewById(R.id.viewWomanSelectSex);
        viewCannelSelectSex = (TextView) findViewById(R.id.viewCannelSelectSex);

        bgSelectSex.setOnClickListener(this);
        viewManSelectSex.setOnClickListener(this);
        viewWomanSelectSex.setOnClickListener(this);
        viewCannelSelectSex.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.viewManSelectSex:
                dismiss();
                break;

            case R.id.viewWomanSelectSex:
                dismiss();
                break;

            case R.id.viewCannelSelectSex:
                dismiss();
                break;

            case R.id.bgSelectSex:
                dismiss();
                break;

        }
    }
}
