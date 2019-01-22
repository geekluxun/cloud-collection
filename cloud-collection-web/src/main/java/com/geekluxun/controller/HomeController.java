package com.geekluxun.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.geekluxun.demo.thymeleaf.entity.Knowledge;
import com.geekluxun.service.IdService;
import com.geekluxun.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/home")
@Slf4j
public class HomeController {

    @Reference
    TestService testService;
    @Reference
    IdService idService;


    @Autowired
    private CloseableHttpClient httpClient;

    @Autowired
    private RequestConfig requestConfig;

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/knowledge")
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
        log.info("luxun");
        return "index";
    }


    @RequestMapping("/core1")
    @ResponseBody
    public Object testCoreService() {
        //String coreServieUrl = "http://cloud-collection-core-service:8078/main/coreServiceTest1";
        /**
         * 如果使用本地局部变量实例化一个RestTemplate ，域名是localhost，而如果使用负载均衡过的RestTemplate的，请参照SpringConfig中说明！！！
         */
        String coreServieUrl = "http://localhost:8078/main/coreServiceTest1";
        //RestTemplate restTemplate = new RestTemplate();

        Map response = new HashMap(10);
        Object response2 = restTemplate.postForObject(coreServieUrl, null, Object.class);

        response.put("code", "111888");
        response.put("msg", "success");
        response.put("data", JSON.toJSONString(response2));
        return response;
    }

    @RequestMapping("/core2")
    @ResponseBody
    public Object testCoreService2() throws Exception {

        String coreServieUrl = "http://localhost:8078/main/coreServiceTest1";
        Map response = new HashMap(10);

        HttpPost post = new HttpPost(coreServieUrl);
        HttpResponse httpResponse = httpClient.execute(post);
        HttpEntity entity;
        String responseBody = "";
        if (httpResponse.getStatusLine().getStatusCode() == 200) {
            log.info("响应成功....");
            entity = httpResponse.getEntity();
            responseBody = EntityUtils.toString(entity);
        } else {
            log.error("响应失败....");
        }

        response.put("code", "111888");
        response.put("msg", "success");
        response.put("data", responseBody);
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
