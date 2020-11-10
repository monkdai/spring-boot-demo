package im.dai;

import im.dai.entity.User;
import im.dai.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: roc
 * @date: 2020/9/16 下午 02:12
 * @description: TODO
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional  //需要被事务管理
public class MybatisTest {

    @Resource
    private UserMapper userMapper;

    @Test
    @Rollback
    public void insert() throws Exception {
        // insert一条数据，并select验证
        userMapper.insert("bbb", 22);
        User u = userMapper.findByName("bbb");
        Assert.assertEquals(22, u.getAge().intValue());

        //Map<String, Object> map = new HashMap<>();
        //map.put("name","bbb");
        //map.put("age",23);
        //userMapper.insertByMap(map);
    }

    @Test
    @Rollback
    public void update() throws Exception {
        //update一条数据，并select验证
        User u = userMapper.findByName("aaa");
        u.setAge(44);
        userMapper.update(u);
        u = userMapper.findByName("aaa");
        Assert.assertEquals(44, u.getAge().intValue());
    }

    @Test
    @Rollback
    public void delete() throws Exception {
        //delete一条数据，并select验证
        User u = userMapper.findByName("aaa");
        userMapper.delete(u.getId());
        u = userMapper.findByName("aaa");
        Assert.assertEquals(null, u);
    }

    @Test
    @Rollback
    public void findAll() throws Exception {
        //查询数据
        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            Assert.assertEquals(null, user.getId());
            Assert.assertEquals(null, user.getAge());
        }
    }
}
