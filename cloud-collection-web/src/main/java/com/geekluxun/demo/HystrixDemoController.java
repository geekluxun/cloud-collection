package com.geekluxun.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-26 15:16
 * @Description:
 * @Other:
 */
@Controller
@RequestMapping("/hello")
public class HystrixDemoController {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    HelloService helloService;

    @RequestMapping("/test1")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "error")
    public Object test1() {
        Map requestPara = new HashMap(10);
        requestPara.put("name", "geekluxun");
        requestPara.put("age", 100);
        String response = restTemplate.postForObject("http://cloud-collection-core-service/hello", requestPara, String.class);
        return response;
    }

    @RequestMapping("/test2")
    @ResponseBody
    public Object test2() {
        Map requestPara = new HashMap(10);
        requestPara.put("name", "luxun");
        requestPara.put("age", 20);
        String response = helloService.sayHello(requestPara);
        return response;
    }

    private String error() {
        return "helloService服务不可用";
    }
}
