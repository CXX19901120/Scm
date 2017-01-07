package com.mls.scm.holder;

import android.view.View;
import android.widget.TextView;

import com.mls.scm.R;
import com.mls.scm.entity.response.BizUnitResponse;
import com.mls.scm.util.UIUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by chenxiuxiang on 2017/1/5.
 */

public class BizUintHolder extends BaseHolder<BizUnitResponse.DataBean> {
    @Bind(R.id.tv_name)
    TextView tvName;

    @Override
    protected View initView() {
        View view = UIUtils.inflate(R.layout.view_listitem_biz_unit);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    protected void refreshView() {
        BizUnitResponse.DataBean data = getData();
        tvName.setText(data.getName());
    }
}
