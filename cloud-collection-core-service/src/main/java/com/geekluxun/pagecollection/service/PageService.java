package com.geekluxun.pagecollection.service;

import com.geekluxun.dto.common.RequestDto;
import com.geekluxun.dto.common.ResponseDto;
import com.geekluxun.dto.pagecollection.PageListDto;
import com.geekluxun.dto.pagecollection.QueryPageDto;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-09 10:13
 * @Description:
 * @Other:
 */
public interface PageService {
    ResponseDto<Object> deletePage(String pageId);

    ResponseDto<PageListDto> queryPageOfCollection(RequestDto<QueryPageDto> requestDto);
}
