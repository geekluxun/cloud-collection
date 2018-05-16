package com.geekluxun.controller;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;



/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 * @Author: luxun
 * @Date: 2018-05-15
 * @Description: 
 * @Others:
 */

@RestController
public class HomeController {
         
    
    Logger logger = LoggerFactory.getLogger(getClass());
    
    @RequestMapping("test")
    @ResponseBody
    public Object helloWorld(){
        Map response = new HashMap(10);
        logger.info("hello test!!!");

        response.put("code", "12345");
        response.put("msg", "success");
        return  response;
    }


    @RequestMapping("core")
    @ResponseBody
    public Object testCoreSevie(){
        String coreServieUrl = "http://cloud-collection-core-service.local/test";
        Map response = new HashMap(10);
        logger.info("core service test!!!");

        RestTemplate restTemplate = new RestTemplate();
        //Object response2  = restTemplate.postForObject("http://cloud-collection-core-service:8083/test", null, Object.class);
        Object response2  = restTemplate.postForObject(coreServieUrl, null, Object.class);

        response.put("code", "111888");
        response.put("msg", "success");
        response.put("data", JSON.toJSONString(response2));
        return  response;
    }
}
