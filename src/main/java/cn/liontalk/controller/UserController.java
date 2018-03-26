package cn.liontalk.controller;

import cn.liontalk.entity.user.User;
import cn.liontalk.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author: 周哲
 * @package: cn.liontalk.controller
 * @description:
 * @date: 2018/3/25 20:13
 * @version: V1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {


    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;


    @RequestMapping(value="/query")
    public String test(ModelMap modelMap){
        logger.info("查询个人用户数据！");
        List<User> list = userService.findUserInfo();
        if(list!=null&& list.size()>0){
            modelMap.put("user",list.get(0));
        }
        return "user";
    }


    @RequestMapping(value="/delete")
    public String deleteUser(ModelMap modelMap){
        int result  = userService.delUserInfo(1);
        modelMap.put("result",result);
        return "user";
    }


}
