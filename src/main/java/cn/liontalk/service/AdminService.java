package cn.liontalk.service;

import cn.liontalk.entity.admin.Admin;

/**
 * @author: 周哲
 * @package: cn.liontalk.service
 * @description:
 * @date: 2018/4/10 20:59
 * @version: V1.0
 */
public interface AdminService {

    Admin adminLogin(String account, String password);
}
