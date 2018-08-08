package com.geekluxun.dao;

import com.geekluxun.entity.TOrderItem;

import java.util.List;

public interface TOrderItemMapper {
    int insert(TOrderItem record);

    int insertSelective(TOrderItem record);
    
    int count();
    
    List<TOrderItem> selectAll();
}