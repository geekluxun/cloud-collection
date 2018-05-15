package com.geekluxun.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    
    
    @RequestMapping("test")
    @ResponseBody
    public Object helloWorld(){
        Map response = new HashMap(10);
        
        response.put("code", "12345");
        response.put("msg", "success");
        return  response;
    }
}
