package com.geekluxun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Date: 2018-07-27 17:45
 * @Description:
 * @Others:
 */

@EnableHystrixDashboard
@EnableTurbine
@SpringBootApplication
public class CloudCollectionHystrixDashboradServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudCollectionHystrixDashboradServiceApplication.class, args);
    }
}
