package cn.liontalk.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: 周哲
 * @package: cn.liontalk.filter
 * @description: 配置登录过滤器
 * @date: 2018/4/10 22:41
 * @version: V1.0
 */
@Component
@WebFilter(urlPatterns = "/admin/index",filterName = "LoginFilter")
public class LoginFilter implements Filter {


    protected final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        logger.info("拦截器实现。。。");
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
