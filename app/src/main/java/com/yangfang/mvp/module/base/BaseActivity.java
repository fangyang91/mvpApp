package com.yangfang.mvp.module.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import com.trello.rxlifecycle.LifecycleTransformer;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.yangfang.mvp.R;
import com.yangfang.mvp.widget.EmptyLayout;

import javax.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Author     : yangfang
 * Date       : 2017/3/12 10:54
 */

public abstract class BaseActivity<I extends IBasePresenter> extends RxAppCompatActivity implements IBaseView {

    /**
     * 把EmptyLayout放在基类统一处理，@Nullable表明View可以为null
     */
    @Nullable
    @BindView(R.id.empty_layout)
    protected EmptyLayout mEmptyLayout;

    /**
     * 把Presenter提取到基类需要配合基类的initInjector()进行注入，如果继承这个基类则必定提供一个Presenter注入的方法，
     * 该APP所有Presenter都在Module提供注入实现，也可以提供另外不带Presenter的基类
     */

    /**
     * 刷新控件，注意，资源的ID一定要一样
     */

    /**
     * 绑定布局文件
     */
    @LayoutRes
    protected abstract int attachLayoutRes();

    /**
     * Dagger注入
     */
    protected abstract void initInjector();

    /**
     * 初始化视图控件
     */
    protected abstract void initView();

    /**
     * 更新视图控件
     * @param isRefresh
     */
    protected abstract void updateViews(boolean isRefresh);


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(attachLayoutRes());
        ButterKnife.bind(this);
        initInjector();
        initView();
        initSwipeRefresh();
        updateViews(false);
    }

    @Override
    public void showLoading() {
        if (mEmptyLayout != null) {
            mEmptyLayout.setEmptyStatus(EmptyLayout.STATUS_LOADING);
        }
    }

    @Override
    public void hideLoading() {
        if (mEmptyLayout != null) {
            mEmptyLayout.hide();
        }
    }

    @Override
    public void showNetError(final EmptyLayout.OnRetryListener onRetryListener) {
        if (mEmptyLayout != null) {
            mEmptyLayout.setEmptyStatus(EmptyLayout.STATUS_NO_NET);
            mEmptyLayout.setRetryListener(onRetryListener);
        }
    }

    @Override
    public <T> LifecycleTransformer<T> bindToLife() {
        return this.<T>bindToLifecycle();
    }

    @Override
    public void finishRefresh() {

    }

    /**
     * 初始化下拉刷新
     */
    private void initSwipeRefresh() {
        /*if (mSwipeRefresh != null) {
            SwipeRefreshHelper.init(mSwipeRefresh, new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    updateViews(true);
                }
            });*/
    }

    /**
     * 替换Fragment
     */
    protected void replaceFragment(int containerViewId, Fragment fragment, String tag) {
        if (getSupportFragmentManager().findFragmentByTag(tag) == null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            //设置tag
            fragmentTransaction.replace(containerViewId, fragment, tag);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            //这里设置tag,上面也要设置tag
            fragmentTransaction.addToBackStack(tag);
            fragmentTransaction.commit();
        } else {
            //存在则弹出上面的所有的fragment,并显示对应的fragment
            getSupportFragmentManager().popBackStack(tag, 0);
        }

    }
}

