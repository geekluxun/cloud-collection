package com.geekluxun.user.repo.dao;

import com.geekluxun.user.domain.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface TUserMapper {
    
    int insert(User record);

}