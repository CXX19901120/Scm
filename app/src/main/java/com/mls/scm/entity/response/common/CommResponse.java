package com.mls.scm.entity.response.common;

/**
 * Created by CXX on 2016/5/30.
 */
public class CommResponse extends ErroResponse  {
    private String state;

    public String getResultCode() {
        return state;
    }

    public void setResultCode(String state) {
        this.state = state;
    }
}
