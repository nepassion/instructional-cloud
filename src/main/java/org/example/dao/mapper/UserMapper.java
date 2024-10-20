package org.example.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.example.pojo.entity.UserEntity;

/**
 * (User)表数据库访问层
 *
 * @author michael
 * @since 2024-09-24 15:31:34
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

    @Update("update t_user set balance=balance-#{money} where id=#{id}")
    int deductBalance(@Param("id") Long userId, @Param("money") Double money);

}

