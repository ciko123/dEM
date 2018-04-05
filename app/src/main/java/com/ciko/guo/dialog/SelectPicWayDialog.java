package com.ciko.guo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.ciko.guo.R;
import com.imnjh.imagepicker.SImagePicker;

/**
 * 创建时间: 2018/3/20 下午3:49
 * 类描述:
 *
 * @author Ciko
 */
public class SelectPicWayDialog extends Dialog implements View.OnClickListener {


    private View bgGetPhoto;
    private View viewTakePhotoGetPhoto;
    private View viewTPhotoAlbumGetPhoto;
    private View viewCannelGetPhoto;

    public SelectPicWayDialog(@NonNull Context context) {
        super(context, R.style.Dialog);
        setContentView(R.layout.layout_select_pic);


        bgGetPhoto = findViewById(R.id.bgGetPhoto);
        viewTakePhotoGetPhoto = findViewById(R.id.viewTakePhotoGetPhoto);
        viewTPhotoAlbumGetPhoto = findViewById(R.id.viewTPhotoAlbumGetPhoto);
        viewCannelGetPhoto = findViewById(R.id.viewCannelGetPhoto);

        bgGetPhoto.setOnClickListener(this);
        viewTakePhotoGetPhoto.setOnClickListener(this);
        viewTPhotoAlbumGetPhoto.setOnClickListener(this);
        viewCannelGetPhoto.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bgGetPhoto:
                dismiss();
                break;

            case R.id.viewTakePhotoGetPhoto:




                break;

            case R.id.viewTPhotoAlbumGetPhoto:
                dismiss();
                break;

            case R.id.viewCannelGetPhoto:
                dismiss();
                break;

        }
    }
}
