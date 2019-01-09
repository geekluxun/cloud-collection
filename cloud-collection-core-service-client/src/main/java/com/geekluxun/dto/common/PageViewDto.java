package com.geekluxun.dto.common;

import lombok.Data;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-09 11:21
 * @Description: 分页显示DTO
 * @Other:
 */
@Data
public class PageViewDto extends BaseDto{
    /**
     * 每页大小
     */
    Integer pageSize;
    /**
     * 当前页数
     */
    Integer pageNum;
    /**
     * 当天页条数
     */
    Integer itemCount;
}
