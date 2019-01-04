package com.geekluxun.pagecollection.domain.valobj;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-04 15:34
 * @Description:
 * @Other:
 */
public enum CollectionMemberTypeEnum {
    PAGE(1, "网页"),
    COLLECTION(2, "收藏夹");
    
    private int type;
    private String desc;

    CollectionMemberTypeEnum(int type, String desc){
        this.type = type;
        this.desc = desc;
    }
}
