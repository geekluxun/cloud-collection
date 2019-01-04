package com.geekluxun.pagecollection.repo.dao;

import com.geekluxun.pagecollection.repo.DO.TCollection;
import org.springframework.stereotype.Repository;

@Repository
public interface TCollectionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TCollection record);

    int insertSelective(TCollection record);

    TCollection selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TCollection record);

    int updateByPrimaryKey(TCollection record);
}