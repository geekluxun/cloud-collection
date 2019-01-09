package com.geekluxun.pagecollection.domain.entity;

import com.geekluxun.common.Entity;
import com.geekluxun.pagecollection.domain.valobj.*;
import lombok.Data;
import sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.nio.charset.Charset;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-04 14:41
 * @Description: 网页实体类
 * @Other:
 */
@Data
public class Page extends Entity {
    private PageId pageId;
    private String name;
    private String url;
    private String iconUri;
    private PageImportanceLevelEnum level;
    private PageBrowse pageBrowse;

    public Page(PageId pageId,
         String name,
         String url,
         String iconUri,
         PageImportanceLevelEnum level,
         PageBrowse pageBrowse){
        this.pageId = pageId;
        this.name = name;
        this.url = url;
        this.iconUri = iconUri;
        this.level = level;
        this.pageBrowse = pageBrowse;
    }
    
}
