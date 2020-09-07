package im.dai;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @author: roc
 * @date: 2020/9/7 上午 10:57
 * @version: 1.0
 * @description: TODO
 */
@RestController
public class HelloController {

    /**
     * 模拟转账
     */
    @PostMapping("/transfer")
    public void transferMoney(String name, Integer money) {
        System.out.println("name：" + name);
        System.out.println("money损失：" + money);
    }
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
