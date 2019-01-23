package com.geekluxun.service.impl;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.geekluxun.service.IdService;
import com.geekluxun.service.TestService;
import com.geekluxun.util.ExceptionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Date: 2018-07-27 17:45
 * @Description:
 * @Others:
 */
@Service(timeout = 5000, filter = "tracing")
@Slf4j
public class TestServiceImpl implements TestService {
    @Autowired
    private RestTemplate restTemplate;

    @Reference(filter = "tracing")
    IdService idService;

    private static final String sentinelRes1 = "sentinelRes1";

    private static final String sentinelRes2 = "sentinelRes2";


    @Override
    public void test() {
        String response = restTemplate.postForObject("http://localhost:8082/main/userServiceTest1", new HashMap<>(), String.class);
        // TODO dubbo中调用另一个dubbo 调用链跟踪还有问题，在zipkin显示上还有问题，需要解决！！！            
        long id = idService.genId();
        log.info("id:" + id);
        log.info("TestService test ok!!! response:" + response);
    }

    /**
     * 定义Sentinel资源
     */
    @SentinelResource(value = sentinelRes1, blockHandler = "handleException", blockHandlerClass = {ExceptionUtil.class})
    @Override
    public void sentinelDemo1() {
        log.info("通过注解方式实现限流--->模拟业务处理1...");
    }

    @Override
    public void sentinelDemo2() {
        Entry entry = null;
        try {
            entry = SphU.entry(sentinelRes2);
            // 资源中的逻辑.
            log.info("通过代码方式实现限流--->模拟业务处理2...");
        } catch (BlockException e1) {
            log.warn("业务2被限流了!!!");
        } finally {
            if (entry != null) {
                entry.exit();
            }
        }
    }


    /**
     * 定义Sentinel规则
     */
    @PostConstruct
    private void initFlowRules() {
        List<FlowRule> rules = new ArrayList<>();
        /**
         * 资源1QPS限流15
         */
        FlowRule rule = new FlowRule();
        rule.setResource(sentinelRes1);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(15);
        rules.add(rule);

        /**
         * 资源2 QPS限流12
         */
        rule = new FlowRule();
        rule.setResource(sentinelRes2);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(12);

        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }
}
