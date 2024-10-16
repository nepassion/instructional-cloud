package org.example.pojo.entity;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * (User)表实体类
 *
 * @author michael
 * @since 2024-09-24 15:31:35
 */
@TableName("t_user")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Alias("user")
@Data
public class UserEntity extends Model<UserEntity> {

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

    @TableLogic
    private Integer delFlag;

    @Version
    private Integer version;

    public static List<String> nameList = Arrays.asList("Anna", "Ben", "Carer");

    public static UserEntity buildUserEntity() {
        // 创建 UserEntity 对象实例
        UserEntity user1 = new UserEntity();
        user1.setUsername(nameList.get(new Random().nextInt(3)));
        user1.setPassword("password123");
        user1.setPhone("1234567890");

        user1.setStatus(1);
        user1.setBalance(100);
        JSONObject jsonInfo = new JSONObject();
        jsonInfo.put("info", "information");
        user1.setInfo(jsonInfo.toString());
        return user1;
    }


}

