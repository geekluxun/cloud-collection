package com.geekluxun.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.util.StreamUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import static com.netflix.zuul.context.RequestContext.getCurrentContext;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.util.ReflectionUtils.rethrowRuntimeException;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-02-28 19:05
 * @Description:
 * @Other:
 */
public class UppercaseRequestEntityFilter extends ZuulFilter {
    public String filterType() {
        return PRE_TYPE;
    }

    public int filterOrder() {
        return 6;
    }

    public boolean shouldFilter() {
        RequestContext context = getCurrentContext();
        return context.getRequest().getParameter("service") == null;
    }

    public Object run() {
        try {
            RequestContext context = getCurrentContext();
            InputStream in = (InputStream) context.get("requestEntity");
            if (in == null) {
                in = context.getRequest().getInputStream();
            }
            String body = StreamUtils.copyToString(in, Charset.forName("UTF-8"));
            // body = "request body modified via set('requestEntity'): "+ body;
            body = body.toUpperCase();
            context.set("requestEntity", new ByteArrayInputStream(body.getBytes("UTF-8")));
        } catch (IOException e) {
            rethrowRuntimeException(e);
        }
        return null;
    }
}
