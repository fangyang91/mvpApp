package com.yangfang.mvp.module.news.main;

import com.trello.rxlifecycle.LifecycleTransformer;
import com.yangfang.mvp.local.table.NewsTypeInfo;
import com.yangfang.mvp.module.base.BaseFragment;
import com.yangfang.mvp.module.base.IRxBusPresenter;
import com.yangfang.mvp.widget.EmptyLayout;

import java.util.List;

/**
 * Description:
 * 新闻主界面
 * Author     : yangfang
 * Date       : 2017/3/20 20:38
 */
public class NewsMainFragment extends BaseFragment<IRxBusPresenter> implements INewsMainView {


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
    public void loadData(List<NewsTypeInfo> checkList) {

    }
}
