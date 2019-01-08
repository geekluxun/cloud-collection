package com.geekluxun.pagecollection.domain.entity;

import com.geekluxun.common.Entity;
import com.geekluxun.pagecollection.domain.valobj.CollectionId;
import com.geekluxun.pagecollection.domain.valobj.CollectionMember;
import lombok.Data;

import java.util.Set;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-04 15:26
 * @Description:
 * @Other:
 */
@Data
public class Collection extends Entity {
    /**
     * 收藏夹Id
     */
    private CollectionId collectionId;
    /**
     * 收藏夹名字
     */
    private String name;
    /**
     * 是否是最顶层收藏夹
     */
    private Boolean top;
    /**
     * 收藏夹下内容（通过CollectionId业务逻辑上关联）
     */
    private Set<CollectionMember> content;
    
    public Collection(CollectionId id, String name, Boolean top, Set<CollectionMember> content){
        this.collectionId = id;
        this.name = name;
        this.top = top;
        this.content = content;
    }
}
