package im.dai.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: roc
 * @date: 2020/9/11 下午 05:03
 * @description: TODO
 */
@Data
@NoArgsConstructor
public class User {

    private Integer id;

    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}