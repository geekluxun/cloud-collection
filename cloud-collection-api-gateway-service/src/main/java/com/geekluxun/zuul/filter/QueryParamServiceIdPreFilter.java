package com.geekluxun.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

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
public class QueryParamServiceIdPreFilter extends ZuulFilter {

    public int filterOrder() {
        // run before PreDecorationFilter
        return 5 - 1;
    }

    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = getCurrentContext();
        return ctx.getRequest().getParameter("service") != null;
    }

    public Object run() {
        RequestContext ctx = getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        // put the serviceId in `RequestContext`
        ctx.put("serviceId", request.getParameter("service"));
        return null;
    }
}
