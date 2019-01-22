package com.geekluxun.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-22 15:22
 * @Description:
 * @Other:
 */
@Slf4j
@Controller
@RequestMapping("/main")
public class MainController {
    
    @PostMapping("/userServiceTest1")
    @ResponseBody
    public Object test(){
        log.info("user test1 invoke!!!");
        return "user test1 invoke!!!";
    }
    
}
