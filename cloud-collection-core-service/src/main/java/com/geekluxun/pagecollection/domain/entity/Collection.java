package com.geekluxun.pagecollection.domain.entity;

import com.geekluxun.common.Entity;
import com.geekluxun.pagecollection.domain.valobj.CollectionId;
import com.geekluxun.pagecollection.domain.valobj.CollectionMember;

import java.util.Set;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-04 15:26
 * @Description:
 * @Other:
 */
public class Collection extends Entity {
    private CollectionId collectionId;
    private Set<CollectionMember> content;
}
