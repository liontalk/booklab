package cn.liontalk.mapper;

import cn.liontalk.entity.user.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author: 周哲
 * @package: cn.liontalk.mapper
 * @description:
 * @date: 2018/3/25 20:22
 * @version: V1.0
 */
@Mapper
public interface UserMapper {


    /**
     * 查询用户信息
     *
     * @param map
     * @return
     **/
    List <User> findUserInfo(Map <String, Object> map);


    /**
     * 添加用户信息
     * @param user
     * @param
     * @return
     **/
    Integer addUserInfo(User user);

    /**
    * 删除用户数据
    * @param id
    * @return
    **/
    int delUserInfo(int id);


    /**
    * 查询用户列表
    * @param
    * @return List <User>
    **/
    List <User> queryUserList();
    
}
