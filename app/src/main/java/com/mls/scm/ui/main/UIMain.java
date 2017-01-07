package com.mls.scm.ui.main;

import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.mls.scm.R;
import com.mls.scm.application.ActivityManager;
import com.mls.scm.constant.Common;
import com.mls.scm.ui.BaseActivity;
import com.orhanobut.logger.Logger;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by chenxiuxiang on 2017/1/4.
 */

public class UIMain extends BaseActivity {
    @Bind(R.id.web_main)
    WebView webMain;

    @Override
    protected void initView() {
        setContentView(R.layout.ui_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void initData(Bundle bundle) {
        webMain.loadUrl(Common.WEB_SHOW_URL);

        webMain.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });
        //启用支持javascript
        WebSettings settings = webMain.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
    }

    private boolean isExit = false;

    @Override
    public void onBackPressed() {
        Logger.d(webMain.getUrl().equals(Common.WEB_SHOW_URL + "pages/vendor/main.html"));
        if (webMain.getUrl().equals(Common.WEB_SHOW_URL + "pages/vendor/main.html") || webMain.getUrl().equals(Common.WEB_SHOW_URL)) {
            if (!isExit) {
                isExit = true;
                showToast("再按一次退出程序");
                new Handler().postDelayed(() -> isExit = false, 2000);
            } else {
                ActivityManager.getActivityManager().popAllActivity();
                finish();
            }
        } else {
            webMain.loadUrl("javascript:androidBack()");
        }
    }

}
