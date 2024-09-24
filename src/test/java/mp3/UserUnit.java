package mp3;

import org.example.MainApplication;
import org.example.dao.mapper.UserDao;
import org.example.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = MainApplication.class)
public class UserUnit {
    @Autowired
    private UserDao userMapper;
    @Test
    public void userList(){
        User list=userMapper.selectById(1L);
        System.err.println("咋啥都没有");
        System.out.println(list);
    }
}
