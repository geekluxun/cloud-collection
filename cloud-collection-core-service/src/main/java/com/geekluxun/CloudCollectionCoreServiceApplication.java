package com.geekluxun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Date: 2018-05-03
 * @Description:
 * @Others:
 */
@EnableEurekaClient
@EnableHystrix
@EnableCircuitBreaker
@SpringBootApplication
public class CloudCollectionCoreServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudCollectionCoreServiceApplication.class, args);
    }
}
