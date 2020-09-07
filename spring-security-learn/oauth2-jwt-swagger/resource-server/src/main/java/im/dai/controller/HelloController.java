package im.dai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @author: roc
 * @date: 2020/9/7 下午 05:34
 * @version: 1.0
 * @description: 测试接口
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
    @GetMapping("/admin/hello")
    public String admin() {
        return "hello admin";
    }
}
