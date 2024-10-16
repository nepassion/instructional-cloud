package org.example.pojo.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * (UserQuery)UserQuery查询对象
 *
 * @author Michael
 * @since 2024-10-13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserQuery<T> extends PageQuery<T> {
    private String name;
    private Integer status;
    private Integer minBalance;
    private Integer maxBalance;
}
