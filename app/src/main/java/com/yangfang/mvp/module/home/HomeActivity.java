package com.yangfang.mvp.module.home;

import com.trello.rxlifecycle.LifecycleTransformer;
import com.yangfang.mvp.module.base.BaseActivity;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Author     : yangfang
 * Date       : 2017/3/14 12:56
 */
public class HomeActivity extends BaseActivity{
    @Override
    protected int attachLayoutRes() {
        return 0;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void updateViews(boolean isRefresh) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public <T> LifecycleTransformer<T> bindToLife() {
        return null;
    }

    @Override
    public void finishRefresh() {

    }
}
