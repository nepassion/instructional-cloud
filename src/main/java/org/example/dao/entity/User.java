package org.example.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.util.Date;

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
@Alias("User")
public class User extends Model<User> {

    @TableId(type = IdType.ASSIGN_ID)
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

