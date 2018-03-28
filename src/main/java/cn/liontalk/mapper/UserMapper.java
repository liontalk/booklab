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
     List<User> findUserInfo(Map<String,Object> map);
     int addUserInfo(User user);
     int delUserInfo(int id);

     /**
     * @author: zhouzhe
     * @param:
     * @className: UserMapper
     * @package: cn.liontalk.mapper
     * @describe: 查询用户列表
     * @return:
     * @date: 2018/3/28 22:21
     **/
     List<User> queryUserList();
}
