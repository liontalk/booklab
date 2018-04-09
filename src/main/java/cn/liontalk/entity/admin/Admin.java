package cn.liontalk.entity.admin;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.Entity;
import java.util.Date;

/**
 * @author: 周哲
 * @package: cn.liontalk.entity.Admin
 * @description:
 * @date: 2018/3/25 20:32
 * @version: V1.0
 */
@Data
@Entity
public class Admin {

    @NonNull
    private int id;

    private String account;

    private String password;

    private String name;

    private Date createTime;

    private int parentId;

    private String status;

}
