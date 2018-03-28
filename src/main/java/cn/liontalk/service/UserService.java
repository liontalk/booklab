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
      * @author: zhouzhe
      * @param:
      * @className: UserService
      * @package: cn.liontalk.service
      * @describe:
      * @return:
      * @date: 2018/3/25 21:00
      **/
     List<User> findUserInfo(Map<String,Object> map);


     /**
     * @author: zhouzhe
     * @param:
     * @className: UserService
     * @package: cn.liontalk.service
     * @describe: 查询用户列表
     * @return:
     * @date: 2018/3/28 22:20
     **/
     List<User> queryUserList();

     int addUserInfo(User user);
     int delUserInfo(int id);

}
