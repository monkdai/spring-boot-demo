package im.dai.protect2;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * @ClassName SecurityConfig
 * @author: roc
 * @date: 2020/9/7 上午 11:23
 * @version: 1.0
 * @description: 前后端分离的防御方案
 * 将服务端生成的随机数放在 Cookie 中，前端需要从 Cookie 中自己提取出来 _csrf 参数，然后拼接成参数传递给后端
 * 单纯的将 Cookie 中的数据传到服务端是没用的，所以放在Cookie中也是安全的
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html")
                .successHandler((req,resp,authentication)->{
                    resp.getWriter().write("success");
                })
                .permitAll()
                .and()
                //允许前端通过 js 操作
                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    }
}
