package com.geekluxun.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.geekluxun.service.IdService;
import com.geekluxun.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Date: 2018-07-27 17:45
 * @Description:
 * @Others:
 */
@Service(timeout = 5000, filter = "tracing")
@Slf4j
public class TestServiceImpl implements TestService {
    @Autowired
    private RestTemplate restTemplate;
    
    @Reference(filter = "tracing")
    IdService idService;
    
    
    @Override
    public void test() {
        String response = restTemplate.postForObject("http://localhost:8082/main/userServiceTest1", new HashMap<>(), String.class);
        // TODO dubbo中调用另一个dubbo 调用链跟踪还有问题，在zipkin显示上还有问题，需要解决！！！            
        long id = idService.genId();
        log.info("id:" + id);
        log.info("TestService test ok!!! response:" + response);
    }
}
