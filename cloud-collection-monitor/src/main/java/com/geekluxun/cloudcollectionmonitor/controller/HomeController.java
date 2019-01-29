package com.geekluxun.cloudcollectionmonitor.controller;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Event;
import com.dianping.cat.message.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-29 14:16
 * @Description:
 * @Other:
 */
@Controller
@RequestMapping
public class HomeController {

    @GetMapping("/testCat")
    @ResponseBody
    public Object testCat() {
        Transaction t = Cat.newTransaction("URL", "pageName");

        try {
            Cat.logEvent("URL.Server", "serverIp", Event.SUCCESS, "ip=1122334455");
            Cat.logMetricForCount("metric.key");
            Cat.logMetricForDuration("metric.key", 5);
            t.setStatus(Transaction.SUCCESS);
        } catch (Exception e) {
            t.setStatus(e);
            Cat.logError(e);
        } finally {
            t.complete();
        }

        return "OK";
    }
}
