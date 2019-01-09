package com.geekluxun.pagecollection.repo.dao;

import com.geekluxun.pagecollection.domain.entity.Collection;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TCollectionMapper {

    int insert(Collection record);

    Collection queryByCollectionId(@Param("collecionId") String collectionId);

    int updateById(Collection record);

    int deleteByCollectionId(@Param("collecionId") String collectionId);

}