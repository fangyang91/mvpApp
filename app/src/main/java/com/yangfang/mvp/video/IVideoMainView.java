package com.yangfang.mvp.video;

/**
 * Description: video 主界面接口
 * Copyright  : Copyright (c) 2016
 * Author     : yangfang
 * Date       : 2017/3/27 15:51
 */

public interface IVideoMainView {

    /**
     * 更新数据
     * @param loveCount 收藏数
     */
    void updateLoveCount(int loveCount);

    /**
     * 更新数据
     * @param downloadCount 下载中的个数
     */
    void updateDownloadCount(int downloadCount);
}
