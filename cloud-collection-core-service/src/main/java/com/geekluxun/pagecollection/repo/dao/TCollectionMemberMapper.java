package com.geekluxun.pagecollection.repo.dao;

import com.geekluxun.pagecollection.domain.valobj.CollectionMember;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TCollectionMemberMapper {

    int insert(CollectionMember record);

    int delectByMemberId(@Param("memberId") String memberId);

    Set<CollectionMember> queryByCollectionId(@Param("collectionId") String collectionId);

}