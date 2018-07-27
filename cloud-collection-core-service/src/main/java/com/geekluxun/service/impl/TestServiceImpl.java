package com.geekluxun.service.impl;

import com.geekluxun.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Date: 2018-07-27 17:45
 * @Description:
 * @Others:
 */
@Service
public class TestServiceImpl implements TestService {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void test() {
        logger.info("TestService test ok!!!");
    }
}
