package org.example.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * (User)表实体类
 *
 * @author michael
 * @since 2024-09-24 15:31:35
 */
@TableName("t_user")
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends Model<User> {

    private Long id;

    private String username;

    private String password;

    private String phone;

    private String info;

    private Integer status;

    private Integer balance;

    private Date createTime;

    private Date updateTime;


}

