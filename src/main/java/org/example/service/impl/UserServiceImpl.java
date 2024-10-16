package org.example.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.dao.mapper.UserMapper;
import org.example.pojo.common.OriginalResult;
import org.example.pojo.dto.PageDTO;
import org.example.pojo.entity.UserEntity;
import org.example.pojo.query.PageQuery;
import org.example.pojo.query.UserQuery;
import org.example.pojo.vo.UserVO;
import org.example.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author michael
 * @since 2024-09-24 15:31:35
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    /**
     * @param id
     * @param money
     * @return
     */
    @Override
    public UserEntity deductionBalance(Long id, Double money) {

        //1.查询用户
        UserEntity userEntity = getById(id);
        //2.校验用户状态
        if (ObjectUtil.isEmpty(userEntity) || userEntity.getStatus() == 2) {
            //用户状态异常
            throw new RuntimeException("User status exception!");
        }
        //3.校验余额是否重组
        if (userEntity.getBalance() < money) {
            //用户余额不足 insufficient 不足
            throw new RuntimeException("Insufficient user balance!");
        }
        //4.扣减余额
//        int flag = baseMapper.deductBalance(id, money);
//        if (flag == 0) {
//            throw new RuntimeException("update failure");
//        }
        double remainBalance = userEntity.getBalance() - money;
        lambdaUpdate()
                .set(UserEntity::getBalance, remainBalance)
                .set(remainBalance == 0, UserEntity::getStatus, 2)
                .eq(UserEntity::getId, id)
                .eq(UserEntity::getBalance, userEntity.getBalance()) // 乐观锁
                .update();

        UserEntity newUserEntity = getById(id);
        return newUserEntity;
    }

    /**
     * 查询用户
     *
     * @param userQuery
     * @return
     */
    @Override
    public List<UserEntity> queryUser(UserQuery userQuery) {
        List<UserEntity> list = lambdaQuery()
                .like(StrUtil.isNotEmpty(userQuery.getName()), UserEntity::getUsername, userQuery.getName())
                .eq(userQuery.getStatus() != null, UserEntity::getStatus, userQuery.getStatus())
                .ge(ObjectUtil.isNotNull(userQuery.getMinBalance()), UserEntity::getBalance, userQuery.getMinBalance())
                .le(ObjectUtil.isNotNull(userQuery.getMaxBalance()), UserEntity::getBalance, userQuery.getMaxBalance())
//                .between(userQuery.getMinBalance() != null || userQuery.getMaxBalance() != null,
//                        UserEntity::getBalance,
//                        userQuery.getMinBalance(), userQuery.getMaxBalance())
                .list();
        return list;
    }

    /**
     * 批量插入用户
     *
     * @return
     */
    @Override
    public String saveUserBatch() {
        List<UserEntity> list = new ArrayList<>();
        long a = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            UserEntity userEntity = UserEntity.buildUserEntity();
            list.add(userEntity);
        }
        saveBatch(list);
        long b = System.currentTimeMillis();
        return "耗时" + (b - a);
    }

    /**
     * @param query
     * @return
     */
    @Override
    public OriginalResult<PageDTO<UserVO>> queryUserPage(UserQuery query) {
        String name = query.getName();
        Integer status = query.getStatus();
        String sortBy = query.getSortBy();
        String str = StrUtil.isNotEmpty(sortBy) ? sortBy : "update_time";
        query.setSortBy(str);
        //1.构建查询条件
        Page<UserEntity> page = new PageQuery().getPage();
        //2.分页查询
        Page<UserEntity> userEntityPage = lambdaQuery()
                .like(name != null, UserEntity::getUsername, name)
                .eq(ObjectUtil.isNotNull(status), UserEntity::getStatus, status)
                .page(page);
        //3.封装VO结果
        PageDTO<UserVO> pageDTO = new PageDTO<UserVO>();
        pageDTO.setPages(userEntityPage.getPages());
        pageDTO.setTotal(userEntityPage.getTotal());
        List<UserEntity> records = userEntityPage.getRecords();
        List<UserVO> userVOS = BeanUtil.copyToList(records, UserVO.class);
        pageDTO.setList(userVOS);

        return OriginalResult.success(pageDTO);
    }
}

