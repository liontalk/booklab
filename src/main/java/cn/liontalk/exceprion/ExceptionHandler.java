package cn.liontalk.exceprion;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;

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
public class ExceptionHandler {



    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public String errorHandler(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){

        String url = request.getRequestURI();
        logger.debug("异常请求地址是:"+url);
        modelMap.put("url",url);
        return "error/500";
    }

}
