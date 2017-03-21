package com.yangfang.mvp.module.base;

import rx.functions.Action1;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Author     : yangfang
 * Date       : 2017/3/22 6:03
 */

public interface IRxBusPresenter extends IBasePresenter{
    /**
     * 注册
     */
    <T> void registerRxBus(Class<T> eventType, Action1<T> action1);

    /**
     * 注销
     */
    void unregisterRxBus();
}
