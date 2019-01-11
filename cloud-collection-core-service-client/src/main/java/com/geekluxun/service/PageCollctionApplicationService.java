package com.geekluxun.service;

import com.geekluxun.dto.common.RequestDto;
import com.geekluxun.dto.common.ResponseDto;
import com.geekluxun.dto.pagecollection.PageListDto;
import com.geekluxun.dto.pagecollection.QueryPageDto;

import javax.xml.ws.Response;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-11 10:45
 * @Description:
 * @Other:
 */
public interface PageCollctionApplicationService {
    ResponseDto<PageListDto> queryPages(RequestDto<QueryPageDto> request);
}
