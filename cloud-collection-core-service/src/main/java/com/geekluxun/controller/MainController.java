package com.geekluxun.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

@RestController
@RefreshScope
public class MainController {
    @Value("${server.port}")
    private String port;

    @Value("${server.name}")
    private String name;

    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("test")
    @ResponseBody
    public Object test() {
        Map response = new HashMap(10);
        logger.info("test cloud collection core service");
        logger.debug("hello debug!!!");


        response.put("code", "111333");
        response.put("msg", "success");
        return response;
    }

    @RequestMapping("hello")
    @ResponseBody
    public Object hello(@RequestBody Map requestPara) {
        logger.info("helloword! name:"
                + requestPara.get("name")
                + " age:"
                + requestPara.get("age")
                + " port:" + port + "sever.name" + name);
        return "HelloWorld!!!";
    }
}
