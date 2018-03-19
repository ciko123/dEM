package com.ciko.guo.base.adapter;

import android.content.Context;

/**
 * 创建时间: 2017/10/14 下午8:32
 * 类描述:
 *
 * @author 木棉
 */
public abstract class MultiItemView<T> implements ItemViewDelegate<T> {

    private MultiItemTypeAdapter adapter;

    public MultiItemView(MultiItemTypeAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void convert(ViewHolder holder, T data, int position) {

    }

    public Context getContext() {
        return adapter.getContext();
    }

    public MultiItemTypeAdapter getAdapter() {
        return adapter;
    }

}