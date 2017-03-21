package com.yangfang.mvp.module.news.main;

import com.yangfang.mvp.local.table.NewsTypeInfo;

import java.util.List;

/**
 * Description:
 * 主页接口
 * Author     : yangfang
 * Date       : 2017/3/22 6:12
 */

public interface INewsMainView {
    /**
     * 显示数据
     * @param checkList 选中栏目
     */
    void loadData(List<NewsTypeInfo> checkList);
}
