package com.geekluxun.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.client.RestTemplate;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Date: 2018-07-27 17:45
 * @Description:
 * @Others:
 */

@Configuration
@ImportResource(locations = {
        //"classpath:spring/dubbo-client.xml"
})
public class SpringConfig {

    @Bean
    //@LoadBalanced 如果加上负载均衡，通过RestTemplate调用时使用的host必须是在eureka上注册的application.name,否则报错！！！
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
