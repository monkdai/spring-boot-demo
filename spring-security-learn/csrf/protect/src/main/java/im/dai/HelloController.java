package im.dai;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @author: roc
 * @date: 2020/9/7 上午 11:15
 * @version: 1.0
 * @description: 注意，这个测试接口是一个 POST 请求
 * 默认情况下，GET、HEAD、TRACE 以及 OPTIONS 是不需要验证 CSRF 攻击的
 */
@RestController
public class HelloController {
    @PostMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello")
    public String hello2() {
        return "hello";
    }
}
