package com.geekluxun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Date: 2018-07-27 17:45
 * @Description: netflix系列组件已经不再维护了，生产环境不再建议使用了!!!
 * @Others:
 */
@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class CloudCollectionApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudCollectionApiGatewayApplication.class, args);
    }
}
