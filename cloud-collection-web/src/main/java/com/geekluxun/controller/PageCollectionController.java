package com.geekluxun.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.geekluxun.dto.common.RequestDto;
import com.geekluxun.dto.common.ResponseDto;
import com.geekluxun.dto.pagecollection.PageListDto;
import com.geekluxun.dto.pagecollection.QueryPageDto;
import com.geekluxun.service.PageCollctionApplicationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-11 10:41
 * @Description:  网页收藏服务web接入层
 * @Other:
 */
@Controller
@RequestMapping("/pagecollection")
public class PageCollectionController {
    
    @Reference
    private PageCollctionApplicationService pageCollctionService;
    
    
    @GetMapping
    @ResponseBody
    @RequestMapping("/queryPages")
    @CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 7200, methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.OPTIONS})
    public Object queryPage(){
        RequestDto<QueryPageDto> requestDto = new RequestDto<>();
        QueryPageDto queryPageDto = new QueryPageDto();
        queryPageDto.setCollectionId("" + 111333);
        requestDto.setRequestPara(queryPageDto);
        
        ResponseDto<PageListDto>  responseDto= pageCollctionService.queryPages(requestDto);
        return responseDto;
    }
    
}
