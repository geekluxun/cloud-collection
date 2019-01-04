package com.geekluxun.pagecollection.domain.entity;

import com.geekluxun.common.Entity;
import com.geekluxun.pagecollection.domain.valobj.PageBrowse;
import com.geekluxun.pagecollection.domain.valobj.PageId;
import com.geekluxun.pagecollection.domain.valobj.PageImportanceLevelEnum;

import java.net.URI;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-04 14:41
 * @Description: 网页实体类
 * @Other:
 */
public class Page extends Entity {
    private PageId pageId;
    private String title;
    private String url;
    private URI iconUri;
    private PageImportanceLevelEnum level;
    private PageBrowse pageBrowse;
    
}
