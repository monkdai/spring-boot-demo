package im.dai;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @ClassName SecurityConfig
 * @author: roc
 * @date: 2020/9/7 上午 09:58
 * @version: 1.0
 * @description:
 * migrateSession 表示在登录成功之后，创建一个新的会话，然后讲旧的 session 中的信息复制到新的 session 中，「默认」。
 * none 表示不做任何事情，继续使用旧的 session。
 * changeSessionId 表示 session 不变，但是会修改 sessionid，这实际上用到了 Servlet 容器提供的防御会话固定攻击。
 * newSession 表示登录后创建一个新的 session。
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .httpBasic()
                .and()
                .sessionManagement()
                .sessionFixation().none() //sessionid无变化
                .and()
                .csrf().disable();
    }
}
