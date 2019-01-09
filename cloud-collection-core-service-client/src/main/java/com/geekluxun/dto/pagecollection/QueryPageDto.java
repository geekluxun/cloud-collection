package com.geekluxun.dto.pagecollection;

import com.geekluxun.dto.common.RequestParaDto;
import lombok.Data;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-09 13:45
 * @Description:
 * @Other:
 */
@Data
public class QueryPageDto extends RequestParaDto {
    /**
     * 网页所在收藏夹id
     */
    private String collectionId;
    /**
     * 页数(从1开始)
     */
    private Integer pageNum;
}
