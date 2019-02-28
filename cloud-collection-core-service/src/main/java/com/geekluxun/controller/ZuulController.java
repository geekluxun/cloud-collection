package com.geekluxun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-02-28 13:51
 * @Description:
 * @Other:
 */
@Controller
@RequestMapping("/zuul")
public class ZuulController {

    @GetMapping("/demo1")
    @ResponseBody
    public Object demo1(HttpServletRequest request) {
        System.out.println("请求头Cookie:" + request.getHeader("Cookie"));
        Cookie[] cookies = request.getCookies();
        System.out.println("======所有Cookie======");
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                System.out.println("name:" + cookies[i].getName());
                System.out.println("value:" + cookies[i].getValue());
            }
        }

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            System.out.println("header名字:" + headerNames.nextElement());
        }
        return "测试zuul路由成功";
    }

}
