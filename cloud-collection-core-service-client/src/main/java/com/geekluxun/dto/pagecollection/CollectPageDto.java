package com.geekluxun.dto.pagecollection;

import com.geekluxun.dto.common.RequestParaDto;
import lombok.Data;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-04 18:23
 * @Description: 收藏网页DTO
 * @Other:
 */
@Data
public class CollectPageDto extends RequestParaDto {
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
