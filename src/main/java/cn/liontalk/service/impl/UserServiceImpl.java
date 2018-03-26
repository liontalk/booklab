package cn.liontalk.service.impl;

import cn.liontalk.entity.user.User;
import cn.liontalk.mapper.UserMapper;
import cn.liontalk.service.UserService;
import cn.liontalk.util.plugins.PageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
/**
 * @author: 周哲
 * @package: cn.liontalk.service.impl
 * @description:
 * @date: 2018/3/25 20:17
 * @version: V1.0
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> findUserInfo(Map<String,Object> map) {

        return userMapper.findUserInfo(map);
    }

    @Override
    public int addUserInfo(User user) {
        return userMapper.addUserInfo(user);
    }

    @Override
    public int delUserInfo(int id) {
        return userMapper.delUserInfo(id);
    }
}
