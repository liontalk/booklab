package cn.liontalk.controller;


import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: 周哲
 * @package: cn.liontalk.controller
 * @description:
 * @date: 2018/4/4 21:37
 * @version: V1.0
 */
@Controller
@RequestMapping(value="/error")
public class ErrorController {


    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());


    @RequestMapping(value="/error")
    public String errorTest(){
        logger.debug("错误。。。。。。。");
        return "error/500";

    }

}
