package com.geekluxun.user.domain.valobj;

import com.geekluxun.common.AbstractId;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-09 14:16
 * @Description:
 * @Other:
 */
public class UserId extends AbstractId {

    @Override
    protected int hashOddValue() {
        return 0;
    }

    @Override
    protected int hashPrimeValue() {
        return 0;
    }

    public UserId(String id) {
        super(id);
    }
}
