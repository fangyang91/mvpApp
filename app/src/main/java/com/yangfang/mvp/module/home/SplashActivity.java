package com.yangfang.mvp.module.home;
/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Author     : yangfang
 * Date       : 2017/3/12 19:58
 */

import android.content.Intent;

import com.dl7.tag.TagView;
import com.yangfang.mvp.R;
import com.yangfang.mvp.module.base.BaseActivity;
import com.yangfang.mvp.utils.RxHelper;

import butterknife.BindView;
import rx.Subscriber;

/**
 * 开机界面
 */
public class SplashActivity extends BaseActivity {

    @BindView(R.id.tag_skip)
    TagView mTagSkip;
    private boolean mIsSkip = false;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView() {
        mTagSkip.setTagClickListener(new TagView.OnTagClickListener() {
            @Override
            public void onTagClick(int pos, String text, int mode) {
                doSkip();
            }
        });
    }
    @Override
    protected void updateViews(boolean isRefresh) {
        RxHelper.countdown(3)
                .compose(this.<Integer>bindToLife())
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {
                        doSkip();
                    }

                    @Override
                    public void onError(Throwable e) {
                        doSkip();
                    }

                    @Override
                    public void onNext(Integer integer) {
                        mTagSkip.setText("跳过 " + integer);
                    }
                });
    }

    private void doSkip() {
        if (!mIsSkip) {
            mIsSkip = true;
            finish();
            startActivity(new Intent(SplashActivity.this, HomeActivity.class));
            overridePendingTransition(R.anim.hold, R.anim.zoom_in_exit);
        }
    }

    /*@Override
    public void onBackPressed() {
        //不响应后退键
        return;
    }*/
}
