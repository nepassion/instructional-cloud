package mp3;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.example.MainApplication;
import org.example.dao.entity.User;
import org.example.dao.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = MainApplication.class)
public class UserUnit {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void userList() {
        User list = userMapper.selectById(1L);
        System.err.println("咋啥都没有");
        System.out.println(list);
    }

    @Test
    public void userUpdate() {
        User user = new User();
        user.setId(4L);
        user.setBalance(2000);
        int flag = userMapper.updateById(user);
        System.out.println(flag);
    }

    @Test
    public void queryOne() {
        User user = new User();
        user.setBalance(1000);
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        QueryWrapper<User> gt = queryWrapper.select("id", "username", "info", "balance")
                .like("username", "o")
                .gt("balance", 1000);
        List<User> users = userMapper.selectList(gt);
        users.stream().forEach(System.out::println);
    }

    @Test
    public void insertTwo() {
        User user1 = new User();
        user1.setUsername("Alice");
        user1.setPassword("password123");
        user1.setPhone("1234567890");
        user1.setInfo("\"{\\\"description\\\":\\\"Alice is a regular user\\\"}\"");
        user1.setStatus(1);
        user1.setBalance(100);
        int key = userMapper.insert(user1);
        System.err.println(user1.getId());
    }

    @Test
    public void updateUnit() {
        UpdateWrapper updateWrapper = new UpdateWrapper<User>()
                .setSql("balance = balance - 200")
                .eq("id", 1L);
        int key = userMapper.update(updateWrapper);
        System.err.println(key);
    }

}
