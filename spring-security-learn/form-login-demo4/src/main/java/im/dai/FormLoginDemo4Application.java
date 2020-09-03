package im.dai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 默认用户名为 user，项目启动后会生成一个 UUID 字符串密码，访问 /hello 接口就会重定向到login页面
 * 默认的登录接口和登录页面都是 /login，区别是：一个是 get 请求。一个是 post 请求
 */
@SpringBootApplication
public class FormLoginDemo4Application {

    public static void main(String[] args) {
        SpringApplication.run(FormLoginDemo3Application.class, args);
    }

}
