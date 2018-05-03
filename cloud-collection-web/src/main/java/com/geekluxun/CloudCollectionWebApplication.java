package com.geekluxun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 * @Author: luxun
 * @Date: 2018-05-03
 * @Description:
 * @Others:
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CloudCollectionWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudCollectionWebApplication.class, args);
	}
}
