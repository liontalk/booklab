package cn.liontalk.entity.user;

import lombok.Data;

/**
 * @author: 周哲
 * @package: cn.liontalk.entity
 * @description:
 * @date: 2018/3/25 20:10
 * @version: V1.0
 */
@Data
public class User {

    private Integer id;
    private String name;
    private String password;
    private String phone;

}
