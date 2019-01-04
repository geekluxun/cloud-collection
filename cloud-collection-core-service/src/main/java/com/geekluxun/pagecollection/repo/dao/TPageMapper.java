package com.geekluxun.pagecollection.repo.dao;

import com.geekluxun.pagecollection.repo.DO.TPage;
import org.springframework.stereotype.Repository;

@Repository
public interface TPageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TPage record);

    int insertSelective(TPage record);

    TPage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TPage record);

    int updateByPrimaryKey(TPage record);
}