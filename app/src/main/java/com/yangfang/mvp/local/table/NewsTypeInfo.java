package com.yangfang.mvp.local.table;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Description:
 * 新闻类型
 * Author     : yangfang
 * Date       : 2017/3/22 6:16
 */

public class NewsTypeInfo {

    @Id(autoincrement = true)
    private Long id;
    private String name;
    private String typeId;

    @Generated(hash =1707873593)
    public NewsTypeInfo(Long id, String name, String typeId) {
        this.id = id;
        this.name = name;
        this.typeId = typeId;
    }
    @Generated(hash = 215923915)
    public NewsTypeInfo(){

    }
}
