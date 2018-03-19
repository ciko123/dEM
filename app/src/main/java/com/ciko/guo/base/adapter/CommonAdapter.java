package com.ciko.guo.base.adapter;

import android.content.Context;

public abstract class CommonAdapter<T> extends MultiItemTypeAdapter<T> {

    public CommonAdapter(Context context, final int layoutId) {
        super(context);

        addItemViewDelegate(new ItemViewDelegate<T>() {
            @Override
            public int getItemViewLayoutId() {
                return layoutId;
            }

            @Override
            public boolean isForViewType(T item, int position) {
                return true;
            }

            @Override
            public void convert(ViewHolder holder, T t, int position) {
                CommonAdapter.this.convert(holder, t, position);
            }
        });
    }

    protected abstract void convert(ViewHolder viewHolder, T item, int position);

}
