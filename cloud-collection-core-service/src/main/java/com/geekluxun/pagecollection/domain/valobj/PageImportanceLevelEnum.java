package com.geekluxun.pagecollection.domain.valobj;

import com.geekluxun.common.ValueObject;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-04 15:08
 * @Description:
 * @Other:
 */
public enum  PageImportanceLevelEnum  {
    
    HiGH(3, "重要"),
    NORMAL(2, "一般"),
    LOW(1,"低");
    
    private int level;
    private String desc;

    PageImportanceLevelEnum(int level, String desc){
        this.level = level;
        this.desc = desc;
    }
}
