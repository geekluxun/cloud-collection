package com.geekluxun.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by luxun on 2018/5/16.
 */

@Configuration
@ImportResource(locations = {
        "classpath:spring/dubbo-client.xml"
        })
public class SpringConfig {
}
