package com.geekluxun.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Date: 2018-05-16
 * @Description:
 * @Others:
 */

@Controller
@RequestMapping("/main")
@RefreshScope
@Slf4j
public class MainController {
    @Value("${server.port}")
    private String port;

    @Value("${server.name}")
    private String name;
    
    @Autowired
    private RestTemplate restTemplate;
    
    @PostMapping("/coreServiceTest1")
    @ResponseBody
    public Object test() {
        Map response = new HashMap(10);
        log.info("test cloud collection core service");

        String response2 = restTemplate.postForObject("http://localhost:8082/main/userServiceTest1", new HashMap<>(), String.class);
        log.info("response2:" + response2);
        response.put("code", "111333");
        response.put("msg", "success");
        return response;
    }

    @RequestMapping("hello")
    @ResponseBody
    public Object hello(@RequestBody Map requestPara) {
        log.info("helloword! name:"
                + requestPara.get("name")
                + " age:"
                + requestPara.get("age")
                + " port:" + port + "sever.name" + name);
        return "HelloWorld!!!";
    }
}
