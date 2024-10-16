package org.example.web;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import org.example.pojo.common.OriginalResult;
import org.example.pojo.dto.PageDTO;
import org.example.pojo.entity.UserEntity;
import org.example.pojo.query.UserQuery;
import org.example.pojo.vo.UserVO;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hello")
public class UserController {
    @Value("${kal}")
    private String val;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String hello() {
        return val;
    }

    @PutMapping("/users/{id}/deduction/{money}")
    public String deductionMoney(
            @PathVariable("id") Long id,
            @PathVariable("money") Double money) {
        UserEntity userEntity = userService.deductionBalance(id, money);
        UserVO userVO = new UserVO();
        //转换VO对象
        BeanUtil.copyProperties(userEntity, userVO);
        // 格式化时间戳为字符串
        userVO.setCreateTime(DateUtil.format(userEntity.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
        userVO.setUpdateTime(DateUtil.format(userEntity.getUpdateTime(), "yyyy-MM-dd HH:mm:ss"));
        return JSONUtil.toJsonStr(userVO);
    }

    /**
     * 复杂条件查询
     *
     * @param userQuery
     * @return
     */
    @GetMapping("/list")
    public List<UserVO> queryUsers(UserQuery userQuery) {
        List<UserEntity> userEntities = userService.queryUser(userQuery);
        return BeanUtil.copyToList(userEntities, UserVO.class);
    }

    @GetMapping("/saveBatch")
    public String saveUsersBatch() {
        String msg = userService.saveUserBatch();
        return msg;
    }

    /**
     * user分页
     *
     * @param query
     * @return
     */
    @GetMapping("/page")
    public OriginalResult<PageDTO<UserVO>> queryUsersPage(UserQuery query) {
        return userService.queryUserPage(query);
    }
}
