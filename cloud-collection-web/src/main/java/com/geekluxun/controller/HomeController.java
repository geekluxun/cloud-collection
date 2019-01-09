package com.geekluxun.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.geekluxun.demo.thymeleaf.entity.Knowledge;
import com.geekluxun.service.IdService;
import com.geekluxun.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Date: 2018-05-15
 * @Description:
 * @Others:
 */

@Controller
@RequestMapping("/")
public class HomeController {

    @Reference
    TestService testService;
    @Reference
    IdService idService;

    Logger logger = LoggerFactory.getLogger(getClass());


    @RequestMapping("/")
    public String home(HttpServletRequest request, HttpServletResponse response, Model model) {

        Knowledge knowledge = new Knowledge();
        knowledge.setTitle("知识就是力量");
        knowledge.setUrl("https://github.com/geekluxun");
        List<Knowledge> knowledges = new ArrayList<>();
        knowledges.add(knowledge);

        knowledge = new Knowledge();
        knowledge.setTitle("helloword");
        knowledge.setUrl("http://baidu.com");

        knowledges.add(knowledge);
        model.addAttribute("knowledges", knowledges);
        return "index";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("luxun");
        logger.info("luxun");
        return "index";
    }


    @RequestMapping("core")
    @ResponseBody
    public Object testCoreSevie() {
        String coreServieUrl = "http://cloud-collection-core-service.local/test";
        Map response = new HashMap(10);
        logger.info("core service test!!!");

        RestTemplate restTemplate = new RestTemplate();
        Object response2 = restTemplate.postForObject(coreServieUrl, null, Object.class);

        response.put("code", "111888");
        response.put("msg", "success");
        response.put("data", JSON.toJSONString(response2));
        return response;
    }


    @RequestMapping("/idtest")
    public String idTest(Model model) {
        long id = idService.genId();
        System.out.println("id:" + id);
        return "index";
    }

    @RequestMapping("/dubbo")
    public void dubbo() {
        testService.test();
    }

}
