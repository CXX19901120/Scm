package com.mls.scm.http;

import android.app.Activity;
import android.content.Intent;
import android.os.Looper;
import android.support.v4.app.Fragment;

import com.mls.scm.application.ActivityManager;
import com.mls.scm.application.AppContext;
import com.mls.scm.constant.Common;
import com.mls.scm.entity.response.common.CommResponse;
import com.mls.scm.fragment.BaseFragment;
import com.mls.scm.ui.BaseActivity;
import com.mls.scm.ui.MySwipeBackActivity;
import com.mls.scm.util.NetworkUtil;
import com.mls.scm.util.UIUtils;
import com.mls.scm.widget.LoadingDialog;
import com.mls.scm.widget.MessageDialog;
import com.orhanobut.logger.Logger;

import java.util.List;

import rx.Subscriber;

/**
 * Created by CXX on 2016/8/29.
 */
public abstract class MySubscriber<T> extends Subscriber<T> {
    private LoadingDialog loadingDialog;
    @Override
    public void onCompleted() {
    }

    @Override
    public void onError(Throwable e) {
        dissMissLoadingDialog();
        e.printStackTrace();
        Logger.d("onError"+e);
        final Activity activity = ActivityManager.getActivityManager().currentActivity();
        removeLodingView(activity);
        if (!NetworkUtil.hasNetwork(UIUtils.getContext())) {
            AppContext.showToast("网络错误");
              error(Common.ERROR_NET);
            return ;
        }

        Logger.d("error:" + e.getMessage());
        remmoveNetErrorView(activity);
        this.error(Common.APP_ERROR);
    }

    protected abstract void error(int errorCode);


    @Override
    public void onNext(T o) {
        dissMissLoadingDialog();
        CommResponse commResponse = (CommResponse) o;
        final Activity activity = ActivityManager.getActivityManager().currentActivity();

        removeLodingView(activity);
        remmoveNetErrorView(activity);
        if (commResponse.getResultCode().equals(Common.SUCCESS)) {
            if (activity instanceof BaseActivity) {
                ((BaseActivity) activity).removeEmptyView();
                List<Fragment> fragments = ((BaseActivity) activity).getSupportFragmentManager().getFragments();
                if (fragments != null && fragments.size() > 0) {
                    Fragment fragment1 = fragments.get(0);
                    if (fragment1 instanceof BaseFragment) {
                        ((BaseFragment)fragment1).removeEmptyView();
                    }

                }
            } else if (activity instanceof MySwipeBackActivity) {
                ((MySwipeBackActivity) (activity)).removeEmptyView();
                List<Fragment> fragments = ((MySwipeBackActivity) activity).getSupportFragmentManager().getFragments();
                if (fragments != null && fragments.size() > 0) {
                    Fragment fragment1 = fragments.get(0);
                    if (fragment1 instanceof BaseFragment) {
                        ((BaseFragment)fragment1).removeEmptyView();
                    }
                }
            }
            onSuccess((T) o);
        } else {
            if (commResponse.getResultCode().equals(Common.NO_DATA)) {
                error(Common.NO_DATA_ERRO);
            } else if (commResponse.getResultCode().equals(Common.INVALID_TOKEN)) {
                //TODO 用户登录失效需要清除用户数据
                MessageDialog messageDialog = new MessageDialog(activity);
                messageDialog.getDialog("登录提醒", "登录失效，请重新登陆。");
                messageDialog.seteditDialogListener(new MessageDialog.MessageDialogListener() {
                    @Override
                    public void sure() {
                        //TODO 当登录失效点击确定需要做的处理如跳转到登录界面
                    }

                    @Override
                    public void cancel() {
                        //TODO 当登录失效点击取消按钮需要做的处理
                    }
                });
            } else {
                AppContext.showToast(commResponse.getErrorMsg());
                error(Common.APP_ERROR);
            }

        }


    }

    private void remmoveNetErrorView(Activity activity) {
        if (activity instanceof BaseActivity) {
            ((BaseActivity) activity).removeNetErrorView();
            List<Fragment> fragments = ((BaseActivity) activity).getSupportFragmentManager().getFragments();
            if (fragments != null && fragments.size() > 0) {
                Fragment fragment1 = fragments.get(0);
                if (fragment1 instanceof BaseFragment) {
                    for (int i=0;i<fragments.size();i++) {
                        if (fragments.get(i) instanceof BaseFragment) {
                            BaseFragment fragment = (BaseFragment)fragments.get(i);
                            fragment.removeNetErrorView();
                        }
                    }
                }
            }
        } else if (activity instanceof MySwipeBackActivity) {
            ((MySwipeBackActivity) activity).removeNetErrorView();
            List<Fragment> fragments = ((MySwipeBackActivity) activity).getSupportFragmentManager().getFragments();
            if (fragments != null && fragments.size() > 0) {
                Fragment fragment1 = fragments.get(0);
                if (fragment1 instanceof BaseFragment) {
                    for (int i=0;i<fragments.size();i++) {
                        Logger.e("是否可见：" + fragments.get(i).isVisible());
                        if (fragments.get(i) instanceof BaseFragment) {
                            BaseFragment fragment = (BaseFragment)fragments.get(i);
                            fragment.removeNetErrorView();
                        }
                    }
                }
            }
        }
    }

    private void removeLodingView(Activity activity) {
        if (activity instanceof BaseActivity) {
            ((BaseActivity) activity).removeLodingView();
            List<Fragment> fragments = ((BaseActivity) activity).getSupportFragmentManager().getFragments();
            if (fragments != null && fragments.size() > 0) {
                Fragment fragment1 = fragments.get(0);
                if (fragment1 instanceof BaseFragment) {
                    for (int i=0;i<fragments.size();i++) {
                        if (fragments.get(i) instanceof BaseFragment) {
                            BaseFragment fragment = (BaseFragment)fragments.get(i);
                            fragment.removeLodingView();
                        }
                    }
                }

            }
        } else if (activity instanceof MySwipeBackActivity) {
            ((MySwipeBackActivity) activity).removeLodingView();
            List<Fragment> fragments = ((MySwipeBackActivity) activity).getSupportFragmentManager().getFragments();
            if (fragments != null && fragments.size() > 0) {
                Fragment fragment1 = fragments.get(0);
                if (fragment1 instanceof BaseFragment) {
                    for (int i=0;i<fragments.size();i++) {
                        if (fragments.get(i) instanceof BaseFragment) {
                            BaseFragment fragment = (BaseFragment)fragments.get(i);
                            fragment.removeLodingView();
                        }
                    }
                }
            }
        }
    }

    protected abstract void onSuccess(T response);

    public void showLoadingDialog(Activity activity, String info) {
        loadingDialog = new LoadingDialog(activity);
        loadingDialog.getDialog(info);
    }

    private void dissMissLoadingDialog() {
        if (loadingDialog != null) {
            loadingDialog.dissMissDialog();
        }
    }
}
