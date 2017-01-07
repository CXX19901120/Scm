package com.mls.scm.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


import com.mls.scm.holder.BaseHolder;

import java.util.List;


/**
 * Created by CXX on 2015/9/24.
 */
public abstract class MyBaseAdapter<T> extends BaseAdapter {
    private List<T> mDatas;
    private BaseHolder holder;
    protected int mPageIndex;
    public Activity context;

    public MyBaseAdapter(List<T> mDatas) {
        this.mDatas = mDatas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            holder = getHolder();
            convertView = holder.getRootView();
        } else {
            holder = (BaseHolder) convertView.getTag();
        }
        holder.setContext(context);
        holder.setAllData(mDatas);
        holder.setAdapter(this);
        holder.setData(mDatas.get(position), mDatas.size(), position);

        return convertView;
    }

    protected abstract BaseHolder getHolder();

    public void addData(List<T> mData) {
        mDatas.addAll(mData);
        notifyDataSetChanged();
    }

    public void addAllData(List<T> mData) {
        mDatas.clear();
        mDatas.addAll(mData);
        notifyDataSetChanged();
    }

    public void setIndex(int index) {
        mPageIndex = index;
    }

    public int getPageIndex() {
        return mPageIndex;
    }

    public void setContext(Activity context) {
        this.context = context;
    }
}
