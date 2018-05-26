package cn.liontalk.service;

import cn.liontalk.entity.user.User;
import cn.liontalk.util.plugins.PageView;

import java.util.List;
import java.util.Map;
/**
 * @author: 周哲
 * @package: cn.liontalk.service
 * @description:
 * @date: 2018/3/25 20:17
 * @version: V1.0
 */
public interface UserService {

     /**
     * 查询用户信息
     * @param  map
     * @param  map
     * @param  map
     * @return  List<User>
     **/
     List<User> findUserInfo(Map<String,Object> map);


     /**
     * 查询用户列表
     *
     * @param
     * @param
     * @param
     * @return
     **/
     List<User> queryUserList(Map<String, Object> params);


     /**
     * 添加用户信息
     *
     * @param user
     * @param user
     * @param user
     * @return
     **/
     int addUserInfo(User user);


     /**
     * 删除用户信息

     * @param  id
     * @param  id
     * @param  id
     * @return
     **/
     int delUserInfo(int id);

}
