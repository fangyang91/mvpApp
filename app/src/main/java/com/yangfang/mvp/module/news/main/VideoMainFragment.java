package com.yangfang.mvp.module.news.main;

import com.trello.rxlifecycle.LifecycleTransformer;
import com.yangfang.mvp.module.base.BaseFragment;
import com.yangfang.mvp.module.base.IRxBusPresenter;
import com.yangfang.mvp.video.IVideoMainView;
import com.yangfang.mvp.widget.EmptyLayout;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Author     : yangfang
 * Date       : 2017/3/20 20:51
 */
public class VideoMainFragment extends BaseFragment<IRxBusPresenter> implements IVideoMainView {
    @Override
    protected void updateViews(boolean isRefresh) {

    }

    @Override
    protected void initSwipeRefresh() {

    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected int attachLayoutRes() {
        return 0;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showNetError(EmptyLayout.OnRetryListener onRetryListener) {

    }

    @Override
    public <T> LifecycleTransformer<T> bindToLife() {
        return null;
    }

    @Override
    public void finishRefresh() {

    }

    @Override
    public void updateLoveCount(int loveCount) {

    }

    @Override
    public void updateDownloadCount(int downloadCount) {

    }
}
