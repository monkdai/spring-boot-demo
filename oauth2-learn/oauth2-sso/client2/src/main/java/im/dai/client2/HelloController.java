package im.dai.client2;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @ClassName HelloController
 * @author: roc
 * @date: 2020/8/27 下午 05:03
 * @version: 1.0
 * @description: 测试接口：返回当前登录用户的姓名和角色信息
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName() + Arrays.toString(authentication.getAuthorities().toArray());
    }
}