package com.geekluxun.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-26 13:30
 * @Description:
 * @Other:
 */
@FeignClient(value = "cloud-collection-core-service", fallback = HelloServiceHystricImpl.class)
public interface HelloService {


    /**
     * sayhello
     * @param para
     * @return
     */
    @RequestMapping(value = "/hello")
    String sayHello(@RequestBody Object para);
}

