package cn.liontalk.entity.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

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


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private String status;

    private String avatar;

    private String nickName;


}
