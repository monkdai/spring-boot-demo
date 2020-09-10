package im.dai;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @author: roc
 * @date: 2020/9/10 上午 09:41
 * @version: 1.0
 * @description: TODO
 */
@RestController
public class HelloController {
    @GetMapping("/user")
    public String hello() {
        return "user";
    }
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}
