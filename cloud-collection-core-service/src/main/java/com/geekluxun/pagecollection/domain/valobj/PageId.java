package com.geekluxun.pagecollection.domain.valobj;

import com.geekluxun.common.AbstractId;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-04 15:21
 * @Description:
 * @Other:
 */
public class PageId extends AbstractId {

    public PageId(String id) {
        super(id);
    }

    @Override
    protected int hashOddValue() {
        return 0;
    }

    @Override
    protected int hashPrimeValue() {
        return 0;
    }
}
