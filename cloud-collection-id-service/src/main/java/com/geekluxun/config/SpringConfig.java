package com.geekluxun.config;

import com.geekluxun.service.impl.provider.IpConfigurableMachineIdProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-08-07 10:54
 * @Description:
 * @Other:
 */
@Configuration
@ImportResource(locations = {
//        "classpath:spring/dubbo-client.xml",
        "classpath:spring/dubbo-service.xml"
})
public class SpringConfig {

    @Bean(initMethod = "init",name = "ipConfigurableMachineIdProvider")
    public IpConfigurableMachineIdProvider springDemoConfig() {
        IpConfigurableMachineIdProvider provider = new IpConfigurableMachineIdProvider();
        provider.setIps("172.16.16.227");
        return provider;
    }
}
