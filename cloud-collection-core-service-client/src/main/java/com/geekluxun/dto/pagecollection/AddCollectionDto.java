package com.geekluxun.dto.pagecollection;

import com.geekluxun.dto.common.RequestParaDto;
import lombok.Data;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-08 10:24
 * @Description:
 * @Other:
 */
@Data
public class AddCollectionDto extends RequestParaDto {
    /**
     * 收藏夹名字
     */
    private String name;
    /**
     * 是否是顶层收藏夹
     */
    private Boolean top;

    /**
     * 上一级收藏夹Id
     */
    private String parentCollectionId;
}
