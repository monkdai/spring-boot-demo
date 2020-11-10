package im.dai.mapper;

import im.dai.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author: roc
 * @date: 2020/9/16 下午 02:03
 * @description: 注解的形式
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USER WHERE NAME = #{name}")
    User findByName(@Param("name") String name);

    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    //@Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER})")
    //int insertByMap(Map<String, Object> map);

    @Update("UPDATE user SET age=#{age} WHERE name=#{name}")
    void update(User user);

    @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(Integer id);

    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    @Select("SELECT name, age FROM user")
    List<User> findAll();
}
