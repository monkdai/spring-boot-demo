package im.dai.mapper;

import im.dai.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: roc
 * @date: 2020/9/11 下午 05:02
 * @description: 配置的形式
 */
@Mapper
public interface UserMapper2 {

    User findByName(@Param("name") String name);

    void update(User user);
}
