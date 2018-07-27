package com.geekluxun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Date: 2018-07-27 17:45
 * @Description:
 * @Others:
 */
@EnableEurekaServer
@SpringBootApplication
public class CloudCollectionDiscoveryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudCollectionDiscoveryServiceApplication.class, args);
    }
}
