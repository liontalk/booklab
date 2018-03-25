package cn.liontalk.mapper;

import cn.liontalk.entity.user.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: 周哲
 * @package: cn.liontalk.mapper
 * @description:
 * @date: 2018/3/25 20:22
 * @version: V1.0
 */
@Mapper
public interface UserMapper {
     List<User> findUserInfo();
     int addUserInfo(User user);
     int delUserInfo(int id);
}
