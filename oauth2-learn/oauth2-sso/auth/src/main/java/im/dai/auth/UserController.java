package im.dai.auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @ClassName UserController
 * @author: roc
 * @date: 2020/8/27 下午 05:09
 * @version: 1.0
 * @description: 模拟资源服务器提供的接口
 */
@RestController
public class UserController {
    @GetMapping("/user")
    public Principal getCurrentUser(Principal principal) {
        return principal;
    }
}
