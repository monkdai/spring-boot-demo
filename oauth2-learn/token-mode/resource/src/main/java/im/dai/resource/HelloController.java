package im.dai.resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @author: roc
 * @date: 2020/8/28 上午 11:30
 * @version: 1.0
 * @description: 测试接口
 */
@RestController
//因为简化模式没有服务端，我们只能通过 js 来请求资源服务器上的数据，所以资源服务器需要支持跨域，添加 @CrossOrigin 注解使之支持跨域
@CrossOrigin(value = "*")
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
    @GetMapping("/admin/hello")
    public String admin() {
        return "admin";
    }
}
