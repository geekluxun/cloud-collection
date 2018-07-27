package com.geekluxun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Date: 2018-07-27 17:45
 * @Description:
 * @Others:
 */
@EnableConfigServer
@SpringBootApplication
public class CloudCollectionConfigCenterServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudCollectionConfigCenterServiceApplication.class, args);
    }
}
