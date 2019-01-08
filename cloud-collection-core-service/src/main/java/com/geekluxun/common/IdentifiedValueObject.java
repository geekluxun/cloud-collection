package com.geekluxun.common;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-08 13:37
 * @Description:
 * @Other:
 */
@Data
public class IdentifiedValueObject extends AssertionConcern implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private Date createTime;
    private Date modifyTime;
    private int concurrencyVersion;


    public IdentifiedValueObject() {
        super();
        this.setConcurrencyVersion(0);
        this.setCreateTime(new Date());
        this.setModifyTime(new Date());
    }
}