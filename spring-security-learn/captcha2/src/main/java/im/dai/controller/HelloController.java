package im.dai.controller;

import im.dai.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @author: roc
 * @date: 2020/9/4 下午 04:46
 * @version: 1.0
 * @description: TODO
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    public void hello() {
        System.out.println(helloService.hello());
    }
}
