package com.geekluxun.pagecollection.domain.valobj;

import com.geekluxun.common.ValueObject;
import lombok.Data;

import java.util.Date;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-04 14:53
 * @Description:
 * @Other:
 */
@Data
public class PageBrowse extends ValueObject {
    private int browseTotalCount;
    private Date lastBrowseTime;
    private boolean readed;

    public PageBrowse(int browseTotalCount, Date lastBrowseTime, boolean readed){
        this.browseTotalCount = browseTotalCount;
        this.lastBrowseTime = lastBrowseTime;
        this.readed = readed;
    }
}
