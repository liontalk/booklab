package cn.liontalk.controller;

import cn.liontalk.constanrt.GlobalConstant;
import cn.liontalk.entity.admin.Admin;
import cn.liontalk.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author: 周哲
 * @package: cn.liontalk.controller
 * @description:
 * @date: 2018/4/10 20:57
 * @version: V1.0
 */
@Controller
@RequestMapping(value="/admin")
public class AdminController {


    @Autowired
    AdminService adminService;


    @RequestMapping(value="/index",method = RequestMethod.GET)
    public String index(HttpSession httpSession){
        Admin admin =(Admin) httpSession.getAttribute(GlobalConstant.ADMIN);
        if(admin==null){
            return "login";
        }
        return "index";
    }






}
