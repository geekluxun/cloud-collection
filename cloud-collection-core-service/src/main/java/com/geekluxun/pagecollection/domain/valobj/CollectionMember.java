package com.geekluxun.pagecollection.domain.valobj;

import com.geekluxun.common.IdentifiedValueObject;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-04 15:28
 * @Description:
 * @Other:
 */
@Data
public class CollectionMember extends IdentifiedValueObject {
    private String memberId;
    private String name;
    private CollectionMemberTypeEnum type;
    private CollectionId collectionId;

    public CollectionMember(String memberId,
                            String name,
                            CollectionMemberTypeEnum type,
                            CollectionId collectionId) {
        super();
        this.memberId = memberId;
        this.name = name;
        this.type = type;
        this.collectionId = collectionId;
    }

    public CollectionMember(Long id,
                            String memberId,
                            String name,
                            Integer type,
                            String  collectionId,
                            Integer concurrencyVersion,
                            Timestamp createTime,
                            Timestamp modifyTime
                           ) {
        super(id, createTime, modifyTime, concurrencyVersion);
        this.memberId = memberId;
        this.name = name;
        this.type = CollectionMemberTypeEnum.getCollectionMemberTypeEnumByType(type);
        this.collectionId = new CollectionId(collectionId);
    }
}
