package im.dai;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * @ClassName SecurityConfig
 * @author: roc
 * @date: 2020/9/2 下午 03:51
 * @version: 1.0
 * @description: 禁止同时登录在线的两种办法
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
        //return new BCryptPasswordEncoder();
    }

    /**
     * 通过监听 session 的销毁事件，来及时的清理 session 的记录
     */
    @Bean
    HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }

    /**
     * 自定义用户名/密码
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("admin")
                //.password(new BCryptPasswordEncoder().encode("admin"))
                .roles("admin")
                .and()  //多个用户用 and() 相连
                .withUser("user")
                .password("user")
                //.password(new BCryptPasswordEncoder().encode("user"))
                .roles("user");
    }

    /**
     * 自定义登录页面
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        //web.ignoring() 用来配置忽略掉的 URL 地址，一般对于静态文件
        web.ignoring().antMatchers("/js/**","/css/**","/images/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //authorizeRequests 对应了 <intercept-url>
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()    //formLogin 对应了 <form-login>
                .loginPage("/login.html")   //此时登录接口和登录页面都是 /login.html
                .permitAll() //permitAll 表示登录相关的页面/接口不要被拦截
                .and()
                .csrf().disable()
                .sessionManagement() //踢掉已经登录的用户
                .maximumSessions(1)
                .maxSessionsPreventsLogin(true); //不踢掉，改成不允许登录
    }

}
