package com.mls.scm.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.mls.scm.R;
import com.mls.scm.constant.Common;
import com.mls.scm.util.UIUtils;
import com.mls.scm.widget.PtrDefaultHeader;
import com.mls.scm.widget.PullToLoadMoreListView;
import com.orhanobut.logger.Logger;

import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * 所有Fragment的基类
 * 说明：
 * ==================================
 * addXxxxView()：表示添加界面为空时的布局
 * 、添加界面加载中的布局、添加网络错误时的布局
 * 使用说明：
 * 在子类中直接调如addEmptyView（）界面将会显示数据为空显示的布局
 * 注意：在子类的fragment中的布局文件中需要有FrameLayout为子节点的布局
 * 因为如果为线性布局添加的view不会在布局中显示并且id要为fl_main
 * 对网络错误的点击处理子类可以覆写 onNetErrorClick（）方法
 * 移除布局的方法都放在了网络处理层子类无需调用
 * ======================================
 */

public abstract class BaseFragment extends Fragment implements View.OnClickListener {

    protected View mView;
    protected int mViewId;
    private LinearLayout relArea;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onFragmentCreate(savedInstanceState);
    }

    protected abstract void onFragmentCreate(Bundle savedInstanceState);

    protected void setContentView(int resourceId) {
        mViewId = resourceId;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = LayoutInflater.from(getActivity()).inflate(mViewId, null);

        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Logger.e("onActivityCreated");
        initView(mView);
        initData(savedInstanceState);
    }

    /**
     * 当子类需要刷新时 直接调用此方法会生成对应的refresh如果需要上拉加载会生成loadMore方法
     * refresh和loadMore为两个空实现
     * @param ptrMain
     * @param lvContent
     */
    public void addRefresh(PtrFrameLayout ptrMain, final ListView lvContent) {
        PtrDefaultHeader header = new PtrDefaultHeader(getActivity());
        ptrMain.setHeaderView(header);
        ptrMain.addPtrUIHandler(header);
        ptrMain.disableWhenHorizontalMove(true);
        ptrMain.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                Logger.e("canRefresh"+canRefresh);
                if (canRefresh) {
                    return true;
                }
                int firstVisiblePosition = lvContent.getFirstVisiblePosition();
                View childAt = lvContent.getChildAt(0);
                if (childAt == null) {
                    return false;
                }
                int top = lvContent.getChildAt(0).getTop();
                return (top == 0 && firstVisiblePosition == 0) ? true : false;
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                refresh(frame);
            }
        });

        if (lvContent instanceof PullToLoadMoreListView) {
            ((PullToLoadMoreListView)lvContent).setOnLoadMoreListener(() -> loadMore());
        }

    }
    /**
     * 下拉刷新
     *
     * @param frame
     */
    public void refresh(PtrFrameLayout frame) {
        canRefresh = false;
    }


    /**
     * 上拉加载
     */
    public void loadMore() {

    }
    protected abstract void initView(View view);

    protected abstract void initData(Bundle savedInstanceState);

    protected View findViewById(int resourceId) {
        return mView.findViewById(resourceId);
    }

    protected ListView initTitle(String title) {
        TextView txtTitle = (TextView) findViewById(R.id.txt_action_title);
        txtTitle.setText(title);
        findViewById(R.id.txt_action_right).setVisibility(View.GONE);
        findViewById(R.id.img_action_left).setOnClickListener(this);
        return null;
    }

    protected void initTitle(String title, String content) {
        TextView txtTitle = (TextView) findViewById(R.id.txt_action_title);
        txtTitle.setOnClickListener(this);
        TextView txtRight = (TextView) findViewById(R.id.txt_action_right);
        txtTitle.setText(title);
        txtRight.setText(content);
        txtRight.setVisibility(View.VISIBLE);
        txtRight.setOnClickListener(this);
        txtTitle.setOnClickListener(this);
        findViewById(R.id.img_action_left).setOnClickListener(this);
    }

    protected void initTitle(String title, String content, boolean isShow) {
        TextView txtTitle = (TextView) findViewById(R.id.txt_action_title);
        txtTitle.setOnClickListener(this);
        TextView txtRight = (TextView) findViewById(R.id.txt_action_right);
        txtTitle.setText(title);
        txtRight.setText(content);
        txtRight.setVisibility(View.VISIBLE);
        txtRight.setOnClickListener(this);
        txtTitle.setOnClickListener(this);
        if (!isShow) {
            findViewById(R.id.img_action_left).setVisibility(View.GONE);
        } else {
            findViewById(R.id.img_action_left).setOnClickListener(this);
        }
    }


    protected void initTitle(String title, boolean isShow) {
        TextView txtTitle = (TextView) findViewById(R.id.txt_action_title);
        txtTitle.setOnClickListener(this);
        txtTitle.setText(title);
        txtTitle.setOnClickListener(this);
        if (!isShow) {
            findViewById(R.id.img_action_left).setVisibility(View.GONE);
        } else {
            findViewById(R.id.img_action_left).setVisibility(View.VISIBLE);
            findViewById(R.id.img_action_left).setOnClickListener(this);
        }
    }

    /**
     * 显示toast
     *
     * @param resId
     */
    public void showToast(int resId) {
        Toast.makeText(getActivity(), this.getResources().getText(resId), Toast.LENGTH_SHORT).show();

    }

    /**
     * 显示toast
     *
     * @param text
     */
    public void showToast(String text) {

        Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();

    }

    public void startActivity(Context fromClass, Class<?> toClass) {
        Intent intent = new Intent();
        intent.setClass(fromClass, toClass);
        fromClass.startActivity(intent);
    }

    public void startActivity(Context fromClass, Class<?> toClass, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(fromClass, toClass);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        fromClass.startActivity(intent);
    }

    public void startActivityForResult(Context fromClass, Class<?> toClass, int requsetCode, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(fromClass, toClass);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requsetCode);
    }

    public void startActivityForResult(Context fromClass, Class<?> toClass, int requsetCode) {
        startActivityForResult(fromClass, toClass, requsetCode, null);
    }


    @Override
    public void onClick(View v) {

    }

    protected void onRightActionPressed() {

    }

    View emptyView;
    public boolean canRefresh = false;

    /**
     * 添加界面为空的布局 根布局要为FrameLayout
     */
    public void addEmptyView() {
        canRefresh = true;
        FrameLayout flMain = (FrameLayout) mView.findViewById(R.id.fl_main);
        if (emptyView == null) {
            emptyView = UIUtils.inflate(R.layout.view_empty);
            emptyView.findViewById(R.id.lin_main).setOnClickListener(v -> {

            });
            flMain.addView(emptyView);
        }
    }
    /**
     * 添加界面为空的布局 根布局要为FrameLayout
     */
    public void addEmptyViewOrder() {
        canRefresh = true;
        FrameLayout flMain = (FrameLayout) mView.findViewById(R.id.fl_main);
        if (emptyView == null) {
            emptyView = UIUtils.inflate(R.layout.view_empty);
            emptyView.findViewById(R.id.lin_main).setOnClickListener(v -> {

            });
            flMain.addView(emptyView);
        }
    }


    /**
     * 添加界面为空的布局 根布局要为FrameLayout
     */
    public void addEmptyView(int imgSrc, String content) {
        canRefresh = true;
        FrameLayout flMain = (FrameLayout) mView.findViewById(R.id.fl_main);
        Logger.d("addEmptyView" + emptyView);
        if (emptyView == null) {
            emptyView = UIUtils.inflate(R.layout.view_empty);
            ImageView ivContent = (ImageView) emptyView.findViewById(R.id.img_content);
            TextView tvContent = (TextView) emptyView.findViewById(R.id.tv_content);
            ivContent.setImageResource(imgSrc);
            tvContent.setText(content);
            emptyView.findViewById(R.id.lin_main).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            flMain.addView(emptyView);
        }

    }
    public void addEmptyView(int imgSrc, String content,String content_second) {
        canRefresh = true;
        FrameLayout flMain = (FrameLayout) mView.findViewById(R.id.fl_main);
        Logger.d("addEmptyView" + emptyView);
        if (emptyView == null) {
            emptyView = UIUtils.inflate(R.layout.view_empty);
            ImageView ivContent = (ImageView) emptyView.findViewById(R.id.img_content);
            TextView tvContent = (TextView) emptyView.findViewById(R.id.tv_content);
            TextView textContentSecond= (TextView) emptyView.findViewById(R.id.tv_content_second);
            ivContent.setImageResource(imgSrc);
            tvContent.setText(content);
            textContentSecond.setText(content_second);
            emptyView.findViewById(R.id.lin_main).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            flMain.addView(emptyView);
        }

    }
    /**
     * 移除界面为空的布局
     */
    public void removeEmptyView() {
        canRefresh = false;
        if (emptyView == null) {
            return;
        }
        FrameLayout flMain = (FrameLayout) mView.findViewById(R.id.fl_main);
        if (emptyView != null)
            flMain.removeView(emptyView);
        emptyView = null;
    }

    private View netErrorView;

    /**
     * 添加网络请求错误布局
     */
    public void addNetErrorView() {
        if (netErrorView != null) {
            return;
        }
        netErrorView = UIUtils.inflate(R.layout.view_net_error);
        FrameLayout flMain = (FrameLayout) mView.findViewById(R.id.fl_main);
        flMain.addView(netErrorView);
        LinearLayout linMain = (LinearLayout) netErrorView.findViewById(R.id.lin_net_main);
        linMain.setOnClickListener(v -> onNetErrorClick());
    }

    /**
     * 点击网络错误的按钮 空实现交给子类实现
     */
    public void onNetErrorClick() {
        Logger.d("点击网络错误");
    }


    /**
     * 移除网络错误布局
     */
    public void removeNetErrorView() {
        if (netErrorView == null) {
            return;
        }
        FrameLayout flMain = (FrameLayout) mView.findViewById(R.id.fl_main);

        if (netErrorView != null) {
            canRefresh = true;
            flMain.removeView(netErrorView);
        }
        netErrorView = null;
    }

    /**
     * 添加错误布局界面
     */
    public void addErrorView(int errorCode) {
        if (errorCode == Common.ERROR_NET) {
            addNetErrorView();
        } else if (errorCode == Common.NO_DATA_ERRO) {
            addEmptyView();
        } else {
            addEmptyView();
        }
    }

    /**
     * 添加错误布局界面 需要修改布局显示的图片和内容
     */
    public void addErrorView(int errorCode, int imgSrc, String content) {
        if (errorCode == Common.ERROR_NET) {
            addNetErrorView();
        } else if (errorCode == Common.NO_DATA_ERRO) {
            addEmptyView(imgSrc, content);
        } else {
            addEmptyView();
        }
    }

    /**
     * 添加错误布局界面 需要修改布局显示的图片和内容
     */
    public void addErrorView(int errorCode, int imgSrc, String content,String content_sencond ) {
        if (errorCode == Common.ERROR_NET) {
            addNetErrorView();
        } else if (errorCode == Common.NO_DATA_ERRO) {
            addEmptyView(imgSrc, content,content_sencond);
        } else {
            addEmptyView();
        }
    }


    /**
     * 添加错误布局
     *
     * @param errorCode 错误码
     * @param pageSize  当前listview中有多少个数据
     * @param lvContent 需要上拉加载的listview
     */
    public void addErrorView(int errorCode, int pageSize, PullToLoadMoreListView lvContent, int imgSrc, String content,String content_sencond ) {
        if (errorCode == Common.ERROR_NET) {
            addNetErrorView();
        } else if (errorCode == Common.NO_DATA_ERRO) {
            if (pageSize > 0) {
                lvContent.loadMoreComplete();
                lvContent.setHasMore(false);
            } else {
                addEmptyViewOrder();
            }
        } else {
            addEmptyViewOrder();
        }
    }
    /**
     * 添加错误布局
     *
     * @param errorCode 错误码
     * @param pageSize  当前listview中有多少个数据
     * @param lvContent 需要上拉加载的listview
     */
    public void addErrorView(int errorCode, int pageSize, PullToLoadMoreListView lvContent) {
        if (errorCode == Common.ERROR_NET) {
            addNetErrorView();
        } else if (errorCode == Common.NO_DATA_ERRO) {
            if (pageSize > 0) {
                lvContent.loadMoreComplete();
                lvContent.setHasMore(false);

            } else {
                addEmptyView();
            }

        } else {
            addEmptyView();
        }
    }
    /**
     * 特殊情况 如当获取到数据为第二页返回no_date进行的特殊处理
     * @param errorCode 错误码
     * @param imgSrc 错误提示界面显示的图片
     * @param content 错误提示界面显示错误提醒的文字
     * @param pageSize 每页获取的数据个数
     * @param lvContent 当前的listview
     */
    public void addErrorView(int errorCode, int imgSrc, String content,int pageSize, PullToLoadMoreListView lvContent) {
        if (errorCode == Common.ERROR_NET) {
            addNetErrorView();
        } else if (errorCode == Common.NO_DATA_ERRO) {
            if (pageSize > 0) {
                lvContent.loadMoreComplete();
                lvContent.setHasMore(false);
            } else {
                addEmptyView(imgSrc, content);
            }

        } else {
            addEmptyView();
        }
    }
    public View lodingView;

    /**
     * 添加加载中的布局
     */
    public void addLodingView() {
        if (lodingView != null) {
            return;
        }
        lodingView = UIUtils.inflate(R.layout.view_loding);
        FrameLayout flMain = (FrameLayout) mView.findViewById(R.id.fl_main);
        flMain.addView(lodingView);
    }

    /**
     * 移除加载中的布局
     */
    public void removeLodingView() {
        FrameLayout flMain = (FrameLayout) mView.findViewById(R.id.fl_main);
        Logger.d("netErrorView" + lodingView);
        if (lodingView != null) {
            flMain.removeView(lodingView);
        }
        lodingView = null;
    }
}
