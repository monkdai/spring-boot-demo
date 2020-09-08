package im.dai;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @ClassName SecurityConfig
 * @author: roc
 * @date: 2020/9/8 上午 10:44
 * @version: 1.0
 * @description: HttpBasic认证流程
 * 浏览器发出请求，说要访问 /hello 接口。
 * 服务端返回 401，表示未认证。同时在响应头中携带 WWW-Authenticate 字段来描述认证形式。
 * 浏览器收到 401 响应之后，弹出对话框，要求用户输入用户名/密码，用户输入完用户名/密码之后，浏览器会将之进行 Base64 编码，编码完成后，发送到服务端。
 * 服务端对浏览器传来的信息进行解码，并校验，当没问题的时候，给客户端作出响应。
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }
}
