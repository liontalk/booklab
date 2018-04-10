package cn.liontalk.service.impl;

import cn.liontalk.entity.admin.Admin;
import cn.liontalk.mapper.AdminMapper;
import cn.liontalk.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: 周哲
 * @package: cn.liontalk.service.impl
 * @description:
 * @date: 2018/4/10 21:00
 * @version: V1.0
 */
@Service
public class AdminServiceImpl implements AdminService {


    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin adminLogin(String account, String password) {
        return adminMapper.adminLogin(account,password);
    }
}
