package com.geekluxun;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 * @Author: luxun
 * @Date: 2018-05-03
 * @Description:
 * @Others:
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CloudCollectionWebApplication.class);
	}

}
