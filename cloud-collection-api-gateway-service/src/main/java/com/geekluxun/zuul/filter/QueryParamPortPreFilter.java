package com.geekluxun.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URL;

import static com.netflix.zuul.context.RequestContext.getCurrentContext;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-02-28 19:05
 * @Description:
 * @Other:
 */
public class QueryParamPortPreFilter extends ZuulFilter {

    public int filterOrder() {
        // run after PreDecorationFilter
        return 5 + 1;
    }

    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = getCurrentContext();
        return ctx.getRequest().getParameter("port") != null;
    }

    public Object run() {
        RequestContext ctx = getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        // put the serviceId in `RequestContext`
        String port = request.getParameter("port");
        try {
            URL url = UriComponentsBuilder.fromUri(ctx.getRouteHost().toURI())
                    .port(new Integer(port))
                    .build().toUri().toURL();
            ctx.setRouteHost(url);
        } catch (Exception e) {
            ReflectionUtils.rethrowRuntimeException(e);
        }
        return null;
    }
}
