package com.geekluxun.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.geekluxun.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Date: 2018-07-27 17:45
 * @Description:
 * @Others:
 */
@Service(timeout = 5000)
public class TestServiceImpl implements TestService {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void test() {
        logger.info("TestService test ok!!!");
    }
}
