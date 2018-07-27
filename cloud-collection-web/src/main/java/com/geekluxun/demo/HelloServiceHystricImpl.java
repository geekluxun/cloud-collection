package com.geekluxun.demo;

import org.springframework.stereotype.Service;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-26 13:52
 * @Description:
 * @Other:
 */
@Service
public class HelloServiceHystricImpl implements HelloService {
    @Override
    public String sayHello(Object para) {
        return "服务不可用222!!!";
    }
}
