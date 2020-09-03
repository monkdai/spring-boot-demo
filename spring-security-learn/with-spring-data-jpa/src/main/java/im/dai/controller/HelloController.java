package im.dai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @author: roc
 * @date: 2020/9/3 下午 02:50
 * @version: 1.0
 * @description: TODO
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello everybody";
    }

    @GetMapping("/admin/hello")
    public String admin() {
        return "hello admin";
    }

    @GetMapping("/user/hello")
    public String user() {
        return "hello user";
    }
}
