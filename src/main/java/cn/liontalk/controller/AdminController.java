package cn.liontalk.controller;

import cn.liontalk.constanrt.GlobalConstant;
import cn.liontalk.entity.admin.Admin;
import cn.liontalk.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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


    @RequestMapping(value="/index")
    public String index(HttpSession httpSession){
        Admin admin =(Admin) httpSession.getAttribute(GlobalConstant.ADMIN);
        if(admin==null){
            return "login";
        }
        return "index";
    }


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String adminLogin(HttpServletRequest request,ModelMap modelMap,HttpSession httpSession){
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        if(account==null || ("").equals(account.trim())){
           modelMap.put("error","请输入登录账号");
            return "login";
        }
        if(password==null || ("").equals(password.trim())){
            modelMap.put("error","请输入登录密码");
            return "login";
        }
        Admin admin = adminService.adminLogin(account,password);
        if(admin==null){
            modelMap.put("error","该管理员不存在");
            return "login";
        }
        httpSession.setAttribute(GlobalConstant.ADMIN,admin);
        return "redirect:/admin/index";
    }

}
