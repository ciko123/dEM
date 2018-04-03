package com.ciko.guo.base.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.ciko.guo.utils.EmptyUtil;

import java.util.ArrayList;
import java.util.List;

public class MultiItemTypeAdapter<T> extends BaseAdapter {

    protected Context mContext;
    protected List<T> mDatas;

    private ItemViewDelegateManager mItemViewDelegateManager;


    public MultiItemTypeAdapter(Context context) {
        this.mContext = context;
        this.mDatas = new ArrayList<>();
        mItemViewDelegateManager = new ItemViewDelegateManager();
    }

    public MultiItemTypeAdapter addItemViewDelegate(ItemViewDelegate<T> itemViewDelegate) {
        mItemViewDelegateManager.addDelegate(itemViewDelegate);
        return this;
    }

    private boolean useItemViewDelegateManager() {
        return mItemViewDelegateManager.getItemViewDelegateCount() > 0;
    }

    @Override
    public int getViewTypeCount() {
        if (useItemViewDelegateManager())
            return mItemViewDelegateManager.getItemViewDelegateCount();
        return super.getViewTypeCount();
    }

    @Override
    public int getItemViewType(int position) {
        if (mDatas.size() > 0 && useItemViewDelegateManager()) {
            int viewType = mItemViewDelegateManager.getItemViewType(mDatas.get(position), position);
            return viewType;
        }
        return super.getItemViewType(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemViewDelegate itemViewDelegate = mItemViewDelegateManager.getItemViewDelegate(mDatas.get(position), position);
        int layoutId = itemViewDelegate.getItemViewLayoutId();
        ViewHolder viewHolder = null;
        if (convertView == null) {
            View itemView = LayoutInflater.from(mContext).inflate(layoutId, parent,
                    false);
            viewHolder = new ViewHolder(mContext, itemView, parent, position);
            viewHolder.mLayoutId = layoutId;
            onViewHolderCreated(viewHolder, viewHolder.getConvertView());
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            viewHolder.mPosition = position;
        }


        convert(viewHolder, getItem(position), position);
        return viewHolder.getConvertView();
    }

    protected void convert(ViewHolder viewHolder, T item, int position) {
        mItemViewDelegateManager.convert(viewHolder, item, position);
    }

    public void onViewHolderCreated(ViewHolder holder, View itemView) {
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    protected Context getContext() {
        return mContext;
    }

    /**
     * 清除数据
     */
    public void clearData() {
        mDatas.clear();
        notifyDataSetChanged();
    }

    /**
     * 重新加载
     */
    public void reLoadData(List<T> datas) {
        mDatas.clear();
        if (EmptyUtil.isNotEmpty(datas)) {
            mDatas.addAll(datas);
        }
        notifyDataSetChanged();
    }

    /**
     * 重新加载
     */
    public void reLoadData(T data) {
        mDatas.clear();
        mDatas.add(data);
        notifyDataSetChanged();
    }

    /**
     * 添加数据
     */
    public void addData(List<T> datas) {
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }

    /**
     * 添加数据
     */
    public void addData(T data) {
        mDatas.add(data);
        notifyDataSetChanged();
    }

    public void removeData(int position) {
        mDatas.remove(position);
        notifyDataSetChanged();
    }

}
