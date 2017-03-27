package com.yangfang.mvp.photo.main;

/**
 * Description: 图片界面更新
 * Copyright  : Copyright (c) 2016
 * Author     : yangfang
 * Date       : 2017/3/27 15:57
 */

public interface IPhotoMainView {

    /**
     * 更新数据
     * @param lovedCount 收藏数
     */
    void updateCount(int lovedCount);
}
