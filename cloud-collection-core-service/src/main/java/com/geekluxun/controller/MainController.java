package com.geekluxun.controller;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.spring.annotation.ApolloJsonValue;
import com.geekluxun.config.apollo.ConfigDemoBean;
import lombok.extern.slf4j.Slf4j;
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
// 自动刷新配置（对SpringCloud Config和Apollo都有效）
@RefreshScope
@Slf4j
public class MainController {
    @Value("${server.port : 8089}")
    private String port;

    @Value("${server.name : test}")
    private String name;


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ConfigDemoBean configDemo;

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

    /**
     * 通过代码方式从Apollo配置中心获取某一个配置
     * @return
     */
    @GetMapping("/testApolloConfig")
    @ResponseBody
    public Object testApolloConfig() {
        Config config = ConfigService.getAppConfig(); //config instance is singleton for each namespace and is never null
        String someKey = "userName";
        String someDefaultValue = "luxun";
        String value = config.getProperty(someKey, someDefaultValue);
        return "userName:" + value;
    }

    /**
     * 通过注解方式从Apollo配置中心获取配置
     * @return
     */
    @GetMapping("/testApolloConfig2")
    @ResponseBody
    public Object testApolloConfig2() {
        log.info("configDemo:" + configDemo);
        return "userName:" + configDemo.getUserName() + " password:" + configDemo.getPassword();
    }

}
