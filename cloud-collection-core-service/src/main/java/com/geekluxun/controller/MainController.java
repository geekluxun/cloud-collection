package com.geekluxun.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 * @Author: luxun
 * @Date: 2018-05-16
 * @Description:
 * @Others:
 */

@RestController
public class MainController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("test")
    @ResponseBody
    public Object test(){
        Map response = new HashMap(10);
        logger.info("test cloud collection core service");

        response.put("code", "111333");
        response.put("msg", "success");
        return  response;
    }
}
