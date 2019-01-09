package com.geekluxun.dto.pagecollection;

import com.geekluxun.dto.common.PageViewDto;
import com.geekluxun.dto.common.ResponseDataDto;
import lombok.Data;

import java.util.List;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-09 11:13
 * @Description:
 * @Other:
 */
@Data
public class PageListDto extends ResponseDataDto {
    /**
     * 分页显示
     */
    private PageViewDto pageView;
    /**
     * 当前页网页数据
     */
    private List<PageDto> pageList;
}
