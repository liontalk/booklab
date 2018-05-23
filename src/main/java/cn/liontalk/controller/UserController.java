package cn.liontalk.controller;

import cn.liontalk.entity.user.User;
import cn.liontalk.service.UserService;
import cn.liontalk.util.ajaxresult.AjaxResult;
import cn.liontalk.util.exception.MyException;
import cn.liontalk.util.plugins.PageView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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


    @RequestMapping(value="/list")
    public String userListPage(){
        logger.info("跳转到用户列表。。");
        return "user/userlist";
    }

    @RequestMapping(value="/queryUserList",method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult queryUserList(){
        AjaxResult ajaxResult = new AjaxResult(true);
        try{
            List<User> list = userService.queryUserList();
            ajaxResult.setData(list);

        }catch (MyException e){
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage(e.getMessage());
        }
        return ajaxResult;
    }


    @RequestMapping(value="/delete")
    public String deleteUser(ModelMap modelMap){
        int result  = userService.delUserInfo(1);
        modelMap.put("result",result);
        return "user";
    }



    @RequestMapping(value = "/error")
    public String toError(){

        return "error/500";
    }


}
