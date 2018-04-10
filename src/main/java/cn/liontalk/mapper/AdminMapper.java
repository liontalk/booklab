package cn.liontalk.mapper;

import cn.liontalk.entity.admin.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: 周哲
 * @package: cn.liontalk.mapper
 * @description:
 * @date: 2018/4/10 20:59
 * @version: V1.0
 */
@Mapper
public interface AdminMapper {

    Admin adminLogin(@Param("account") String account, @Param("password") String password);
}
