package com.geekluxun;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboComponentScan(basePackages = "com.geekluxun.service.impl")
public class CloudCollectionIdServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudCollectionIdServiceApplication.class, args);
	}
}
