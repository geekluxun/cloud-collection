package com.geekluxun.pagecollection.domain.entity;

import com.geekluxun.common.Entity;
import com.geekluxun.pagecollection.domain.valobj.PageBrowse;
import com.geekluxun.pagecollection.domain.valobj.PageId;
import com.geekluxun.pagecollection.domain.valobj.PageImportanceLevelEnum;
import lombok.Data;

import java.sql.Timestamp;

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
                PageBrowse pageBrowse) {
        this.pageId = pageId;
        this.name = name;
        this.url = url;
        this.iconUri = iconUri;
        this.level = level;
        this.pageBrowse = pageBrowse;
    }

    public Page(Long id,
                String pageId,
                String name,
                String url,
                String iconUri,
                Integer level,
                Integer browseTotalCount,
                Timestamp lastBrowseTime,
                Integer readed,
                Integer concurrencyVersion,
                Timestamp createTime,
                Timestamp modifyTime
    ) {
        super(id, concurrencyVersion, createTime, modifyTime);
        this.pageId = new PageId(pageId);
        this.iconUri = iconUri;
        Boolean tmpReaded;
        if (readed.intValue() == 0) {
            tmpReaded = false;
        } else {
            tmpReaded = true;
        }
        this.pageBrowse = new PageBrowse(browseTotalCount, lastBrowseTime, tmpReaded);
        this.level = PageImportanceLevelEnum.getPageImportanceLevelEnumByLevel(level);
        this.name = name;
        this.url = url;
    }


}
