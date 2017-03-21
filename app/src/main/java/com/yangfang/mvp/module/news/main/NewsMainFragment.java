package com.yangfang.mvp.module.news.main;

import com.yangfang.mvp.R;
import com.yangfang.mvp.local.table.NewsTypeInfo;
import com.yangfang.mvp.module.base.BaseActivity;
import com.yangfang.mvp.module.base.IRxBusPresenter;

import java.util.List;

/**
 * Description:
 * 新闻主界面
 * Author     : yangfang
 * Date       : 2017/3/20 20:38
 */
public class NewsMainFragment extends BaseActivity<IRxBusPresenter> implements INewsMainView{
    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_news_main;
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
    public void loadData(List<NewsTypeInfo> checkList) {

    }
}
