package com.github.hlc.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Liang on 2018/3/5.
 */
@Component
public class LogZuulFilter extends ZuulFilter{

    private static Logger log= LoggerFactory.getLogger(LogZuulFilter.class);

    /*
        过滤器执行类型：
            pre：路由之前
            routing：路由之时
            post： 路由之后
            error：发送错误调用
     */
    @Override
    public String filterType() {
        return "pre";
    }

    //过滤器执行的顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    //逻辑判断，是否要过滤，本文true,永远过滤
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request =context.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("name");
        if(accessToken == null) {
            log.warn("name is empty");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            try {
                context.getResponse().getWriter().write("name is empty");
            }catch (Exception e){}
            return null;
        }
        log.info("ok");
        return null;
    }

}
