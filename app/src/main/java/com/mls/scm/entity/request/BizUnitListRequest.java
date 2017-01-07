package com.mls.scm.entity.request;

/**
 * 获取往来单位列表
 * Created by chenxiuxiang on 2017/1/5.
 */

public class BizUnitListRequest {
    private int pageNumber;
    private int pageSize;
    private String bizType;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }
}
