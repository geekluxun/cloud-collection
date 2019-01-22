package com.geekluxun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.client.RestTemplate;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Date: 2018-05-03
 * @Description:
 * @Others:
 */
@Configuration
@ImportResource(locations = {
//        "classpath:spring/dubbo-service.xml",
//        "classpath:spring/dubbo-client.xml"
})
public class SpringConfig {

    @Bean
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
