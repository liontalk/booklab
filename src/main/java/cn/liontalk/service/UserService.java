package cn.liontalk.service;

import cn.liontalk.entity.user.User;

import java.util.List;

/**
 * @author: 周哲
 * @package: cn.liontalk.service
 * @description:
 * @date: 2018/3/25 20:17
 * @version: V1.0
 */
public interface UserService {


     List<User> findUserInfo();
     int addUserInfo(User user);
     int delUserInfo(int id);

}
