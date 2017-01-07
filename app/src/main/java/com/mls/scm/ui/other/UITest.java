package com.mls.scm.ui.other;

import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;
import com.mls.scm.R;
import com.mls.scm.adapter.BizUintAdapter;
import com.mls.scm.entity.request.BizUnitListRequest;
import com.mls.scm.entity.response.BizUnitResponse;
import com.mls.scm.http.MySubscriber;
import com.mls.scm.http.impl.DemoApi;
import com.mls.scm.ui.BaseActivity;
import com.mls.scm.util.UIUtils;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by chenxiuxiang on 2017/1/5.
 */

public class UITest extends BaseActivity {
    @Bind(R.id.lv_content)
    ListView lvContent;
    private BizUintAdapter adapter;
    private List<BizUnitResponse.DataBean> mDatas = new ArrayList<>();

    @Override
    protected void initView() {
        setContentView(R.layout.ui_test);
        ButterKnife.bind(this);
        adapter = new BizUintAdapter(mDatas);
        lvContent.setAdapter(adapter);

    }

    @Override
    protected void initData(Bundle bundle) {
        addLodingView();
        UIUtils.postDelayed(() -> {
            getBizUnitList();
        }, 2000);
    }

    public void getBizUnitList() {

        BizUnitListRequest bizUnitListRequest = new BizUnitListRequest();
        bizUnitListRequest.setPageNumber(1);
        bizUnitListRequest.setPageSize(10);
        bizUnitListRequest.setBizType("hr");
        DemoApi.getBizUnitList(bizUnitListRequest).subscribe(new MySubscriber<BizUnitResponse>() {

            @Override
            protected void error(int errorCode) {

            }

            @Override
            protected void onSuccess(BizUnitResponse response) {
                Logger.d(new Gson().toJson(response));
                mDatas.addAll(response.getData());
                adapter.notifyDataSetChanged();
                UIUtils.postDelayed(() -> {
                    addEmptyView();

                }, 2000);
                UIUtils.postDelayed(() -> {
                    removeEmptyView();
                }, 9000);

                UIUtils.postDelayed(() -> {
                    addNetErrorView();
                }, 12000);
                UIUtils.postDelayed(() -> {
                    removeNetErrorView();
                }, 18000);
                UIUtils.postDelayed(() -> {
                    addLodingView();
                }, 22000);
                UIUtils.postDelayed(() -> {
                    removeLodingView();
                }, 25000);
            }
        });
    }


}
