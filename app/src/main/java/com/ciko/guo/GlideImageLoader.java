package com.ciko.guo;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ciko.guo.utils.ContextUtil;
import com.imnjh.imagepicker.ImageLoader;

/**
 * 创建时间: 2018/4/10 下午9:57
 * 类描述:
 *
 * @author Ciko
 */
public class GlideImageLoader implements ImageLoader {

    @Override
    public void bindImage(ImageView imageView, Uri uri, int width, int height) {
        Glide.with(ContextUtil.getContext()).load(uri).placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher).override(width, height).dontAnimate().into(imageView);
    }

    @Override
    public void bindImage(ImageView imageView, Uri uri) {
        Glide.with(ContextUtil.getContext()).load(uri).placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher).dontAnimate().into(imageView);
    }

    @Override
    public ImageView createImageView(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return imageView;
    }

    @Override
    public ImageView createFakeImageView(Context context) {
        return new ImageView(context);
    }
}
