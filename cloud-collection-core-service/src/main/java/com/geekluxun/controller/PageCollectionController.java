package com.geekluxun.controller;

import com.geekluxun.dto.common.RequestDto;
import com.geekluxun.dto.common.ResponseDto;
import com.geekluxun.dto.pagecollection.AddCollectionDto;
import com.geekluxun.dto.pagecollection.CollectPageDto;
import com.geekluxun.pagecollection.application.PageCollctionApplicationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    //@Autowired
    private PageCollctionApplicationServiceImpl pageCollctionService;

    @PostMapping("/collect")
    public Object pageCollect(@RequestBody RequestDto<CollectPageDto> requestDto) {
        ResponseDto<Object> responseDto = pageCollctionService.pageCollect(requestDto);
        return responseDto;
    }

    @PostMapping("/addCollection")
    public Object addCollection(@RequestBody RequestDto<AddCollectionDto> requestDto) {
        ResponseDto<Object> responseDto = pageCollctionService.addCollection(requestDto);
        return responseDto;
    }

}
