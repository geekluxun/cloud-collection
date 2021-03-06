package com.geekluxun.common;

import lombok.Data;

import java.util.Date;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-04 14:42
 * @Description: 实体抽象基类
 * @Other:
 */
@Data
public abstract class Entity extends AssertionConcern {
    private long id;
    private int concurrencyVersion;
    private Date createTime;
    private Date modifyTime;

    public Entity() {
        super();
        this.setConcurrencyVersion(0);
        this.setCreateTime(new Date());
        this.setModifyTime(new Date());
    }
    
    public Entity(Long id, Integer concurrencyVersion, Date createTime, Date modifyTime){
        this.id = id;
        this.concurrencyVersion = concurrencyVersion;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
    }
}