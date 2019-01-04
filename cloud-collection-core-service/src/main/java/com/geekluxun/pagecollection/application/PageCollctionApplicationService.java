package com.geekluxun.pagecollection.application;

import com.geekluxun.dto.PageCollectRequestDto;
import com.geekluxun.dto.RequestDto;
import com.geekluxun.dto.ResponseDto;
import com.geekluxun.pagecollection.repo.dao.TCollectionMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-04 17:21
 * @Description: 网页收藏应用服务层(对应DDD的应用服务)
 * @Other: 应用服务层的主要职责包括事务控制、服务编排（调用内部领域服务或应用服务或者外部应用服务），一个方法对应一个用例流
 */
public class PageCollctionApplicationService {
    
    @Autowired
    TCollectionMapper collectionMapper;

    /**
     *  网页收藏
     * @param pageCollectRequestDto
     * @return
     */
    public ResponseDto<Object> pageCollect(RequestDto<PageCollectRequestDto> pageCollectRequestDto){
        ResponseDto<Object> responseDto = new ResponseDto<>();
        
        
        return responseDto;
    }
}
