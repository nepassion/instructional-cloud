package org.example.convert;

import org.example.pojo.entity.UserEntity;
import org.example.pojo.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Michael
 * @date 2024-10-15
 */
@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserVO UserEntityToUserVO(UserEntity userEntity);
}
