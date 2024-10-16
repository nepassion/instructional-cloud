package org.example.pojo.vo;

import lombok.*;

/**
 * (User)VO
 *
 * @author michael
 * @since 2024-09-24 15:31:35
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
public class UserVO {

    private Long id;

    private String username;

    private String password;

    private String phone;

    private String info;

    private Integer status;

    private Integer balance;

    private String createTime;

    private String updateTime;


}

