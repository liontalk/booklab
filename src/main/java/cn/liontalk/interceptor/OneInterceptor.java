package cn.liontalk.interceptor;


import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: 周哲
 * @package: cn.liontalk.interceptor
 * @description:
 * @date: 2018/3/31 16:33
 * @version: V1.0
 */
public class OneInterceptor implements HandlerInterceptor {


    /**
     * 处理请求之前被调用
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("被One拦截,然后放行。。。");
        return true;
    }


    /**
     * 请求结束之后被调用，但是在视图渲染之前被调用（controller 被调用之后调用）
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }


    /**
     * 整个请求结束之后被调用，也就是对应的DispatcherServlet 完成视图的渲染之后执行
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }

}
