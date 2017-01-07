package com.mls.scm.http.server;

import com.mls.scm.entity.request.BizUnitListRequest;
import com.mls.scm.entity.response.BizUnitResponse;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by chenxiuxiang on 2017/1/5.
 */

public interface DemoInterfaceServer {

    @POST("bizUnit/list")
    Observable<BizUnitResponse> getBizUnitList(@Body BizUnitListRequest bizUnitListRequest);

}
