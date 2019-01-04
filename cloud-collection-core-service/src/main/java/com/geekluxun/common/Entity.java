package com.geekluxun.common;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-04 14:42
 * @Description: 实体抽象基类
 * @Other:
 */
public abstract class Entity extends AssertionConcern {

    private int concurrencyVersion;

    public Entity() {
        super();

        this.setConcurrencyVersion(0);
    }

    public int concurrencyVersion() {
        return this.concurrencyVersion;
    }

    private void setConcurrencyVersion(int aConcurrencyVersion) {
        this.concurrencyVersion = aConcurrencyVersion;
    }
}