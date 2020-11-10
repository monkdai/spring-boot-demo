package im.dai;

import im.dai.entity.User;
import im.dai.mapper.UserMapper2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author: roc
 * @date: 2020/9/16 下午 02:12
 * @description: TODO
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//@Transactional  //需要被事务管理
public class MybatisTest2 {

    @Resource
    private UserMapper2 userMapper2;

    @Test
    //@Rollback   //在结束时回滚，不会真正写进数据库
    public void update() throws Exception {
        //update一条数据，并select验证
        User u = userMapper2.findByName("aaa");
        u.setAge(55);
        userMapper2.update(u);
        u = userMapper2.findByName("aaa");
        Assert.assertEquals(55, u.getAge().intValue());
    }
}
