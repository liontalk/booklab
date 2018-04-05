package cn.liontalk.exceprion;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author: 周哲
 * @package: cn.liontalk.exceprion
 * @description: 定义全局异常信息
 * @date: 2018/4/4 21:15
 * @version: V1.0
 */
@ControllerAdvice
public class AllExceptionHandler {



    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request,Exception e) throws  Exception {

        e.printStackTrace();
        String url = request.getRequestURI();
        ModelAndView mv = new ModelAndView();
        mv.addObject("url",url);
        mv.addObject("exception",e);
        mv.setViewName("error/500");
        logger.debug("异常请求地址是:"+url);
        return mv;
    }

}
