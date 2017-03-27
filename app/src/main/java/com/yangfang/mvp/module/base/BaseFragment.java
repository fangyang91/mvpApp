package com.yangfang.mvp.module.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle.components.support.RxFragment;

import butterknife.ButterKnife;

/**
 * Description:
 * 碎片基类
 * Author     : yangfang
 * Date       : 2017/3/27 15:25
 */

public abstract class BaseFragment<T extends IBasePresenter> extends RxFragment implements IBaseView {

    protected Context mContext;

    /**
     * 注意，资源的ID一定要一样
     */
    //缓存Fragement View
    private View mRootView;
    private boolean mIsMulti = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(attachLayoutRes(), null);
            ButterKnife.bind(this, mRootView);
            initInjector();
            initViews();
            initSwipeRefresh();
        }
        ViewGroup parent = (ViewGroup) mRootView.getParent();
        if (parent != null) {
            parent.removeView(mRootView);
        }
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getUserVisibleHint() && mRootView != null && !mIsMulti) {
            mIsMulti = true;
            updateViews(false);
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisibleToUser && isVisible() && mRootView != null && !mIsMulti) {
            mIsMulti = true;
            updateViews(false);
        } else {
            super.setUserVisibleHint(isVisibleToUser);
        }
    }

    /**
     * 更新视图控件
     * @param isRefresh
     *         新增参数，用来判断是否为下来刷新调用，下拉刷新的时候不应该再显示加载界面和异常界面
     */
    protected abstract void updateViews(boolean isRefresh);

    /**
     * 初始化下拉刷新
     */
    protected abstract void initSwipeRefresh();

    /**
     * 初始化视图控件
     */
    protected abstract void initViews();

    /**
     * Dagger 注入
     */
    protected abstract void initInjector();

    /**
     * 绑定布局文件
     * @return 布局文件ID
     */
    protected abstract int attachLayoutRes();
}
