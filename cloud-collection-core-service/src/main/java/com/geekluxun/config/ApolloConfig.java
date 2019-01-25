package com.geekluxun.config;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.geekluxun.config.apollo.ConfigDemoBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-24 11:01
 * @Description:
 * @Other:
 */
@Configuration
@EnableApolloConfig
public class ApolloConfig {
    
    @Bean
    public ConfigDemoBean ConfigDemoBean() {
        return new ConfigDemoBean();
    }
}
