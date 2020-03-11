package cn.gzst.gov.cloud.gateway.filter;

import cn.gov.gzst.admin.feign.LogFeign;
import cn.gov.gzst.common.utils.StringUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SEND_RESPONSE_FILTER_ORDER;

/**
 * @author lengleng
 * @date 2017/11/20
 * 在RateLimitPreFilter 之前执行，不然又空指针问题
 */
@Component
public class AccessFilter extends ZuulFilter {

    @Autowired
    LogFeign logFeign;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return SEND_RESPONSE_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        //加入token
        String token = ctx.getRequest().getHeader("X-Token");
        if (!StringUtils.isEmpty(token)){
            ctx.addZuulRequestHeader("token", token);
            ctx.addZuulRequestHeader("kissoTokenAttr", token);
        }
        return null;
    }
}
