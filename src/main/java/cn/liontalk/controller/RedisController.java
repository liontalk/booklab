package cn.liontalk.controller;

import cn.liontalk.util.ajaxresult.AjaxResult;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 周哲
 * @package: cn.liontalk.controller
 * @description: 测试Redis配置
 * @date: 2018/3/31 12:35
 * @version: V1.0
 */
@RestController
@RequestMapping(value="/redis")
public class RedisController {


    @Autowired
    StringRedisTemplate redisTemplate;

    @RequestMapping(value="/test")
    public AjaxResult redisTest(){
        AjaxResult ajaxResult = new AjaxResult(true);
        try{
            redisTemplate.opsForValue().set("Hello","SpringBoot Redis!");
            ajaxResult.setData(redisTemplate.opsForValue().get("Hello"));
        }catch (Exception e){
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage(e.getMessage());
        }
       return ajaxResult;
    }
}
