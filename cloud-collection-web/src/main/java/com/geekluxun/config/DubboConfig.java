package com.geekluxun.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @Author: luxun
 * @Create: 2018-08-13 21:07
 * @Description:
 * @Other:
 */
@Configuration
// 不需要这个配置，否则导致RESTFul和dubbo无法同时被zipkin跟踪 问题还未解决！！！
//@ImportResource(locations = {
//        "classpath:spring/zipkin-dubbo.xml",
//})
public class DubboConfig {

    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("consumer-test");
        return applicationConfig;
    }

    @Bean
    public ConsumerConfig consumerConfig() {
        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setTimeout(3000);
        return consumerConfig;
    }

    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://116.62.63.81:2181");
        registryConfig.setClient("curator");
        return registryConfig;
    }
}
