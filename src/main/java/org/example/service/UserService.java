package org.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.pojo.common.OriginalResult;
import org.example.pojo.dto.PageDTO;
import org.example.pojo.entity.UserEntity;
import org.example.pojo.query.UserQuery;
import org.example.pojo.vo.UserVO;

import java.util.List;

/**
 * (User)表服务接口
 *
 * @author michael
 * @since 2024-09-24 15:31:35
 */
public interface UserService extends IService<UserEntity> {


    UserEntity deductionBalance(Long id, Double money);

    List<UserEntity> queryUser(UserQuery userQuery);

    String saveUserBatch();

    OriginalResult<PageDTO<UserVO>> queryUserPage(UserQuery query);
}

