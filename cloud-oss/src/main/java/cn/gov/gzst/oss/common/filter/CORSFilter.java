package cn.gov.gzst.oss.common.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CORSFilter implements Filter {

    @Override
    public void init(FilterConfig var1) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse  response= (HttpServletResponse) servletResponse;
        response.addHeader("Access-Control-Allow-Origin", "*");
       // response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Headers", "X-Requested-With,X_Requested_With");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {}
}