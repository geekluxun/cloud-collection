package com.geekluxun.pagecollection.repo.dao;

import com.geekluxun.pagecollection.repo.DO.TCollectionMember;
import org.springframework.stereotype.Repository;

@Repository
public interface TCollectionMemberMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TCollectionMember record);

    int insertSelective(TCollectionMember record);

    TCollectionMember selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TCollectionMember record);

    int updateByPrimaryKey(TCollectionMember record);
}