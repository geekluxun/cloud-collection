package com.geekluxun.dto;

import lombok.Data;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-04 18:23
 * @Description:
 * @Other:
 */
@Data
public class PageCollectDto extends RequestParaDto{
    /**
     *  网页url
     */
    private String url;
    /**
     * 网页标题
     */
    private String title;
    /**
     * 网页名字
     */
    private String name;
    /**
     * 网页重要等级
     */
    private int level;

    /**
     * 网页所属收藏夹id
     */
    private String parentCollectionId;
}
