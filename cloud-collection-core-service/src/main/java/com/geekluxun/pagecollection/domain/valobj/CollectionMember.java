package com.geekluxun.pagecollection.domain.valobj;

import com.geekluxun.common.IdentifiedValueObject;
import com.geekluxun.common.ValueObject;
import sun.text.normalizer.UBiDiProps;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-04 15:28
 * @Description:
 * @Other:
 */
public class CollectionMember extends IdentifiedValueObject {
    private String memberId;
    private String name;
    private CollectionMemberTypeEnum type;
    private CollectionId collectionId;
    
    public CollectionMember(String memberId,
                            String name,
                            CollectionMemberTypeEnum type,
                            CollectionId collectionId){
        super();
        this.memberId = memberId;
        this.name = name;
        this.type = type;
        this.collectionId = collectionId;
    }
}
