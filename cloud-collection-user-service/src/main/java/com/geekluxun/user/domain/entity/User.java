package com.geekluxun.user.domain.entity;

import com.geekluxun.common.Entity;
import com.geekluxun.user.domain.valobj.UserId;
import lombok.Data;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-09 14:20
 * @Description:
 * @Other:
 */
@Data
public class User extends Entity {
    private UserId userId;
    private String name;
    private String email;
    private String password;


    public User(UserId userId,
                String name,
                String email,
                String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
