package com.geekluxun.service.impl;

import com.geekluxun.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by luxun on 2018/5/16.
 */
@Service
public class TestServiceImpl implements TestService{
    Logger logger = LoggerFactory.getLogger(getClass());
    
    @Override
    public void test() {
        logger.info("TestService test ok!!!");
    }
}
