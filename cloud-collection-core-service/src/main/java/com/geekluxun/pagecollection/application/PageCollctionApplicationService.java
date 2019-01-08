package com.geekluxun.pagecollection.application;

import com.geekluxun.dto.PageCollectRequestDto;
import com.geekluxun.dto.RequestDto;
import com.geekluxun.dto.ResponseDto;
import com.geekluxun.pagecollection.domain.entity.Page;
import com.geekluxun.pagecollection.domain.valobj.PageBrowse;
import com.geekluxun.pagecollection.domain.valobj.PageId;
import com.geekluxun.pagecollection.domain.valobj.PageImportanceLevelEnum;
import com.geekluxun.pagecollection.repo.dao.TCollectionMapper;
import com.geekluxun.pagecollection.repo.dao.TPageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-04 17:21
 * @Description: 网页收藏应用服务层(对应DDD的应用服务)
 * @Other: 应用服务层的主要职责包括事务控制、服务编排（调用内部领域服务或应用服务或者外部应用服务），一个方法对应一个用例流
 */
@Service
public class PageCollctionApplicationService {
    
    @Autowired
    private TCollectionMapper collectionMapper;

    @Autowired
    private TPageMapper pageMapper;

    /**
     *  网页收藏
     * @param pageCollectRequestDto
     * @return
     */
    public ResponseDto<Object> pageCollect(RequestDto<PageCollectRequestDto> pageCollectRequestDto){
        ResponseDto<Object> responseDto = new ResponseDto<>();
        PageId id = new PageId(new Random().nextInt() + "");
        PageBrowse pageBrowse = new PageBrowse(0, null, false);

        Page page = new Page(id,"我的网页","www.baidu.com", "/tmp/img/icon1", PageImportanceLevelEnum.HiGH,pageBrowse);

        int reslut = pageMapper.insert(page);
        if (reslut == 1){
            responseDto.setRetCode(0);
        }else {
            responseDto.setRetCode(-1);
        }
        return responseDto;
    }
}
