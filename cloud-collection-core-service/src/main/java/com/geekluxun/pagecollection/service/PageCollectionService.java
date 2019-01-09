package com.geekluxun.pagecollection.service;

import com.geekluxun.dto.common.ResponseDto;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-09 9:40
 * @Description: 网页收藏夹领域服务
 * @Other:
 */
public interface PageCollectionService {
    ResponseDto<Object> delectCollection(String collectionId);
}
