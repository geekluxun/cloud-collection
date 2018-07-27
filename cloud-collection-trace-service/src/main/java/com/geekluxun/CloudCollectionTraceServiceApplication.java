package com.geekluxun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Date: 2018-07-27 17:45
 * @Description:
 * @Others:
 */
@EnableZipkinServer
@SpringBootApplication
public class CloudCollectionTraceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudCollectionTraceServiceApplication.class, args);
    }
}
