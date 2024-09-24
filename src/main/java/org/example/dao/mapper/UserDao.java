package org.example.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.dao.entity.User;

/**
 * (User)表数据库访问层
 *
 * @author michael
 * @since 2024-09-24 15:31:34
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

}

