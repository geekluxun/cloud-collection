package com.geekluxun;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Date: 2018-05-03
 * @Description:
 * @Others:
 */
@SpringBootApplication
@DubboComponentScan(basePackages = "com.geekluxun")
@MapperScan(basePackages = {"com.geekluxun.user.repo.dao"})
public class CloudCollectionUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudCollectionUserServiceApplication.class, args);
    }
}
