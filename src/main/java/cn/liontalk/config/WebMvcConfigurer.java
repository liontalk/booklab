package cn.liontalk.config;


import cn.liontalk.interceptor.OneInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author: 周哲
 * @package: cn.liontalk.config
 * @description:
 * @date: 2018/3/31 16:28
 * @version: V1.0
 */

@Component
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {



    @Override
    public void addInterceptors(InterceptorRegistry registry){
        /**
         * 拦截器按照顺序执行
         */

        /**
         * 拦截所有的请求
         */
        // registry.addInterceptor(new OneInterceptor()).addPathPatterns("/*/**");


        /**
         *
         * 拦截多个请求
         */
        registry.addInterceptor(new OneInterceptor()).addPathPatterns("/async/**")
                                                  .addPathPatterns("/user/**");


        super.addInterceptors(registry);
    }
}
