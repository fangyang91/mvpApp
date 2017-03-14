package com.yangfang.mvp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.IntDef;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.yangfang.mvp.R;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Author     : yangfang
 * Date       : 2017/3/12 16:19
 * 加载、空视图
 */

public class EmptyLayout extends FrameLayout {

    public static final int STATUS_HIDE    = 1001;
    public static final int STATUS_LOADING = 1;
    public static final int STATUS_NO_NET  = 2;
    public static final int STATUS_NO_DATA = 3;

    @BindView(R.id.tv_net_error)
    TextView    mTvNetError;
    @BindView(R.id.rl_empty_container)
    FrameLayout mRlEmptyContainer;
    @BindView(R.id.empty_layout)
    FrameLayout mEmptyLayout;
    private Context mContext;
    private int mBgColor;
    private int mEmptyStatus;
    private OnRetryListener mOnRetryListener;

    public EmptyLayout(Context context) {
        this(context, null);
    }

    public EmptyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init(attrs);
    }

    /**
     * 初始化
     * @param attrs
     */
    private void init(AttributeSet attrs) {
        TypedArray typedArray = mContext.obtainStyledAttributes(attrs, R.styleable.EmptyLayout);

        typedArray.getColor(R.styleable.EmptyLayout_background_color, Color.WHITE);
        typedArray.recycle();

        View.inflate(mContext, R.layout.layout_empty_local, this);
        ButterKnife.bind(this);
        mEmptyLayout.setBackgroundColor(mBgColor);
        switchEmptyView();
    }
    /**
     * 切换视图
     */
    private void switchEmptyView() {
        switch (mEmptyStatus) {
            case STATUS_LOADING:
                setVisibility(VISIBLE);
                mRlEmptyContainer.setVisibility(GONE);
            break;
            case STATUS_NO_DATA:
            case STATUS_NO_NET:
                setVisibility(VISIBLE);
                mRlEmptyContainer.setVisibility(GONE);
                mRlEmptyContainer.setVisibility(VISIBLE);
                break;

            case STATUS_HIDE:
                setVisibility(GONE);
                break;
        }
    }

    /**
     * 隐藏视图
     */
    public void hide(){
        mEmptyStatus = STATUS_HIDE;
    }

    /**
     * 设置状态
     */
    public void setEmptyStatus(@EmptyStatus int emptyStatus){
        switchEmptyView();
    }
    /**
     * 获取状态
     */
    public int getEmptyStatus(){
        return mEmptyStatus;
    }
    /**
     * 设置异常消息
     */
    public void setEmptyMessage(String msg){
        //mTvEmptyMessage.setText(msg);
    }

    public void hideErrorIcon() {

        //mTvEmptyMessage.setCompoundDrawables(null, null, null, null);
    }
    /**
     * 设置重试监听器
     */
    public void setRetryListener(OnRetryListener retryListener){
        this.mOnRetryListener = retryListener;
    }
    /**
     * 点击重试监听器
     */
    public interface OnRetryListener{
        void onRetry();
    }


    @OnClick(R.id.tv_net_error)
    public void onClick(){
        if (mOnRetryListener != null) {
            mOnRetryListener.onRetry();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({STATUS_LOADING, STATUS_NO_NET, STATUS_NO_DATA})
    public @interface EmptyStatus{

    }

}

