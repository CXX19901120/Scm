package com.mls.scm.http.impl;

import com.mls.scm.entity.request.BizUnitListRequest;
import com.mls.scm.entity.response.BizUnitResponse;
import com.mls.scm.http.RetrofitManager;
import com.mls.scm.http.server.DemoInterfaceServer;

import rx.Observable;

/**
 * Created by chenxiuxiang on 2017/1/5.
 */

public class DemoApi extends RetrofitManager {


    /**
     * 获取人员单位列表
     * @param bizUnitListRequest 请求参数
     * @return 查询结果
     */
    public static Observable<BizUnitResponse> getBizUnitList(BizUnitListRequest bizUnitListRequest) {
        Observable<BizUnitResponse> bizUnitList = retrofit().create(DemoInterfaceServer.class).getBizUnitList(bizUnitListRequest);
        return schedules(bizUnitList);

    }

}
