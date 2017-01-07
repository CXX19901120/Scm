package com.mls.scm.ui.main;

import android.os.Bundle;

import com.mls.scm.R;
import com.mls.scm.ui.BaseActivity;
import com.mls.scm.ui.other.UITest;
import com.mls.scm.util.UIUtils;

/**
 * Created by chenxiuxiang on 2017/1/4.
 */

public class UIWelcome extends BaseActivity {
    @Override
    protected void initView() {
        setContentView(R.layout.ui_welcome);

    }

    @Override
    protected void initData(Bundle bundle) {
        UIUtils.postDelayed(() -> {
            startActivity(UIWelcome.this, UIMain.class);
            finish();
        }, 2000);

    }
}
