package com.geekluxun.controller;

import com.geekluxun.dto.common.RequestDto;
import com.geekluxun.dto.common.ResponseDto;
import com.geekluxun.dto.pagecollection.AddCollectionDto;
import com.geekluxun.dto.pagecollection.CollectPageDto;
import com.geekluxun.pagecollection.application.PageCollctionApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-07 14:03
 * @Description:
 * @Other:
 */
@RestController
@RequestMapping("/page")
public class PageCollectionController {
    @Autowired
    private PageCollctionApplicationService pageCollctionService;
    
    @PostMapping("/collect")
    public Object pageCollect(@RequestBody RequestDto<CollectPageDto> requestDto){
        ResponseDto<Object> responseDto =  pageCollctionService.pageCollect(requestDto);
        return responseDto;
    }
    
    @PostMapping("/addCollection")
    public Object addCollection(@RequestBody RequestDto<AddCollectionDto> requestDto){
        ResponseDto<Object> responseDto = pageCollctionService.addCollection(requestDto);
        return responseDto;
    }
    
}
