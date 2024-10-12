package org.example.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.dao.entity.User;
import org.example.dao.mapper.UserMapper;
import org.example.service.UserService;
import org.springframework.stereotype.Service;

/**
 * (User)表服务实现类
 *
 * @author michael
 * @since 2024-09-24 15:31:35
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    /**
     * @param id
     * @param money
     * @return
     */
    @Override
    public int deductionBalance(Long id, Double money) {

        //1.查询用户
        User user = getById(id);
        //2.校验用户状态
        if (ObjectUtil.isEmpty(user) || user.getStatus() == 2) {
            //用户状态异常
            throw new RuntimeException("User status exception!");
        }
        //3.校验余额是否重组
        if (user.getBalance() < money) {
            //用户余额不足 insufficient 不足
            throw new RuntimeException("Insufficient user balance!");
        }
        //4.扣减余额
        return baseMapper.deductBalance(id, money);
    }
}

