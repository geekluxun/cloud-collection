package com.geekluxun.controller;

import com.geekluxun.dto.ResponseDto;
import com.geekluxun.pagecollection.application.PageCollctionApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    @Autowired
    private PageCollctionApplicationService pageCollctionService;
    
    @GetMapping ("/collect")
    public Object pageCollect(){
        ResponseDto<Object> responseDto =  pageCollctionService.pageCollect(null);
        return responseDto;
    }
}
