package com.geekluxun.pagecollection.repo.dao;

import com.geekluxun.pagecollection.domain.entity.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TPageMapper {
    int insert(Page record);
    
    int delectByPageId(@Param("pageId") String pageId);
    
    int updateByPageId(Page page);

    Page queryByPageId(@Param("pageId") String pageId);
    
}