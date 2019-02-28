package com.geekluxun.zuul.config;

import com.geekluxun.zuul.filter.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-02-28 19:05
 * @Description:
 * @Other:
 */
@Configuration
public class SpringConfig {

    @Bean
    public MyZuulFilter myZuulFilter() {
        return new MyZuulFilter();
    }


    @Bean
    public AddResponseHeaderFilter addResponseHeaderFilter() {
        return new AddResponseHeaderFilter();
    }

    @Bean
    public ModifyResponseBodyFilter modifyResponseHeaderFilter() {
        return new ModifyResponseBodyFilter();
    }

    @Bean
    public ModifyResponseDataStreamFilter modifyResponseDataStreamFilter() {
        return new ModifyResponseDataStreamFilter();
    }

    @Bean
    public PrefixRequestEntityFilter prefixRequestEntityFilter() {
        return new PrefixRequestEntityFilter();
    }

    @Bean
    public QueryParamPortPreFilter queryParamPortPreFilter() {
        return new QueryParamPortPreFilter();
    }

    @Bean
    public QueryParamServiceIdPreFilter queryParamServiceIdPreFilter() {
        return new QueryParamServiceIdPreFilter();
    }

    @Bean
    public UppercaseRequestEntityFilter modifyRequestEntityFilter() {
        return new UppercaseRequestEntityFilter();
    }
}
