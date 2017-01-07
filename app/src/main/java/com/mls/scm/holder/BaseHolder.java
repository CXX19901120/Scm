package com.mls.scm.holder;

import android.app.Activity;
import android.view.View;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by CXX on 2015/9/24.
 */
public abstract class BaseHolder<T> {
    private T mDatas;
    private View view;
    private int totalNumber,position;
    public Activity context;
    private List<T> allDatas;
    private BaseAdapter adapter;
    public BaseHolder() {
        view=initView();
        view.setTag(this);
    }

    protected abstract View initView();

    public void setData(T mDatas) {
        this.mDatas = mDatas;
        refreshView();
    }
    public void setData(T mDatas,int totalNumber,int position) {
        this.mDatas = mDatas;
        this.totalNumber = totalNumber;
        this.position = position;
        refreshView();
    }
    protected abstract void refreshView();

    public T getData() {
        return mDatas;
    }

    public List<T> getAllData() {
        return allDatas;
    }

    public void setAllData(List<T> allData) {
        this.allDatas = allData;

    }


    public void setAdapter(BaseAdapter adapter) {
        this.adapter = adapter;
    }

    public BaseAdapter getAdapter() {
        return adapter;
    }
    public int getTotalNumber() {
        return totalNumber;
    }

    public int getPosition() {
        return position;
    }
    public View getRootView() {
        return view;
    }

    public void setContext(Activity context) {
        this.context = context;
    }
    public Activity getContext() {

        return context;
    }
}
