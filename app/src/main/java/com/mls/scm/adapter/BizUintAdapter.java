package com.mls.scm.adapter;

import com.mls.scm.entity.response.BizUnitResponse;
import com.mls.scm.holder.BaseHolder;
import com.mls.scm.holder.BizUintHolder;

import java.util.List;

/**
 * Created by chenxiuxiang on 2017/1/5.
 */

public class BizUintAdapter extends MyBaseAdapter<BizUnitResponse.DataBean> {
    public BizUintAdapter(List<BizUnitResponse.DataBean> mDatas) {
        super(mDatas);
    }

    @Override
    protected BaseHolder getHolder() {
        return new BizUintHolder();
    }

}
