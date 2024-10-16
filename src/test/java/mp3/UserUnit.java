package mp3;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.MainApplication;
import org.example.dao.mapper.UserMapper;
import org.example.pojo.entity.UserEntity;
import org.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = MainApplication.class)
public class UserUnit {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    public void testLogicDeleted() {
        userService.removeById(1838979411120332802L);
        userService.getById(1838979411120332802L);
    }

    @Test
    public void userList() {
        UserEntity list = userMapper.selectById(1L);
        System.err.println("咋啥都没有");
        System.out.println(list);
    }

    @Test
    public void userUpdate() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(4L);
        userEntity.setBalance(2000);
        int flag = userMapper.updateById(userEntity);
        System.out.println(flag);
    }

    @Test
    public void queryOne() {
        UserEntity userEntity = new UserEntity();
        userEntity.setBalance(1000);
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<UserEntity>();
        QueryWrapper<UserEntity> gt = queryWrapper.select("id", "username", "info", "balance")
                .like("username", "o")
                .gt("balance", 1000);
        List<UserEntity> userEntities = userMapper.selectList(gt);
        userEntities.stream().forEach(System.out::println);
    }

    @Test
    public void insertTwo() {
        UserEntity userEntity1 = new UserEntity();
        userEntity1.setUsername("Alice");
        userEntity1.setPassword("password123");
        userEntity1.setPhone("1234567890");
        JSONObject jsonObject = new JSONObject();
        jsonObject.set("description", "Alice is a regular user");
        userEntity1.setInfo(jsonObject.toString());
        userEntity1.setStatus(1);
        userEntity1.setBalance(100);
        int key = userMapper.insert(userEntity1);
        System.err.println(userEntity1.getId());
    }

    @Test
    public void updateUnit() {
        UpdateWrapper updateWrapper = new UpdateWrapper<UserEntity>()
                .setSql("balance = balance - 200")
                .eq("id", 1L);
        int key = userMapper.update(updateWrapper);
        System.err.println(key);
    }

    @Test
    public void saveBatch() {
        long startTime = System.currentTimeMillis();
        long startNano = System.nanoTime();
        ArrayList<UserEntity> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(UserEntity.buildUserEntity());
        }
        userService.saveBatch(list);
        long endTime = System.currentTimeMillis();
        long endNano = System.nanoTime();
        long totalTime = endTime - startTime;
        long totalNano = endNano - startNano;
        System.out.println("总计耗时" + totalTime + "毫秒");
        System.out.println("-----------------------------------------");
        System.out.println("总计耗时" + (totalTime / 1000) + "秒");
        System.err.println("nano时间" + totalNano + "毫秒");
    }

    @Test
    public void testPageQuery() {
        int pageNo = 2, pageSize = 2000;
        //1.1.分页参数
        Page<UserEntity> page = Page.of(pageNo, pageSize);
        //1.2排序参数,通过OrderItem指定
        page.addOrder(OrderItem.desc("balance"));
        //1.3分页查询
        Page<UserEntity> p = userService.page(page);
        System.out.println("total=" + p.getTotal());
        System.out.println("pages=" + p.getPages());
        //分页数据
        List<UserEntity> records = p.getRecords();
        records.forEach(System.out::println);

    }

    @Test
    public void testOptimisticLockUpdate() {
        UserEntity userEntity = userService.lambdaQuery().eq(UserEntity::getId, 1846038170258743297L).one();
        userEntity.setBalance(userEntity.getBalance() - 200);
        userService.updateById(userEntity);
        UserEntity list2 = userService.lambdaQuery().eq(UserEntity::getId, 1846038170258743297L).one();
        System.out.println("before--> " + userEntity + " after--> " + list2);
    }

    @Test
    public void testOptimisticLockUpdate2() {
        List<UserEntity> list = userService.lambdaQuery().eq(UserEntity::getId, 1846038170258743297L).list();
        userService.lambdaUpdate()
                .eq(UserEntity::getId, 1846038170258743297L)
//                .eq(UserEntity::getVersion)
                .set(UserEntity::getBalance, list.get(0).getBalance() - 200)
                .update();
        List<UserEntity> list2 = userService.lambdaQuery().eq(UserEntity::getId, 1846038170258743297L).list();
        System.out.println("before--> " + list + " after--> " + list2);
    }

}
