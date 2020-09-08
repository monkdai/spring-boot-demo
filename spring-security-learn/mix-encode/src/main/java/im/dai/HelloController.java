package im.dai;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @author: roc
 * @date: 2020/9/8 下午 02:14
 * @version: 1.0
 * @description: TODO
 */
@RestController
public class HelloController {
    @GetMapping("/dai")
    public String hello() {
        return "dai";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }
}
