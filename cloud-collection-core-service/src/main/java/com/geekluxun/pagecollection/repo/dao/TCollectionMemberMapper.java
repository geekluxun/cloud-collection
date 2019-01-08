package com.geekluxun.pagecollection.repo.dao;

import com.geekluxun.entity.TCollectionMember;
import com.geekluxun.pagecollection.domain.valobj.CollectionMember;
import org.springframework.stereotype.Repository;

@Repository
public interface TCollectionMemberMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CollectionMember record);

    int insertSelective(TCollectionMember record);

    TCollectionMember selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TCollectionMember record);

    int updateByPrimaryKey(TCollectionMember record);
}