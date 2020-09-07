package im.dai;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName SecurityConfig
 * @author: roc
 * @date: 2020/9/7 下午 05:21
 * @version: 1.0
 * @description: 用户信息配置
 */
@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE) //方案二
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("admin")
                .and()
                .withUser("user")
                .password(passwordEncoder().encode("user"))
                .roles("user");
    }

    //@Override
    //protected void configure(HttpSecurity http) throws Exception {
    //    http.csrf().disable().formLogin();
    //}

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requestMatchers().antMatchers(HttpMethod.OPTIONS, "/oauth/**")
                .and()
                .csrf().disable().formLogin()
                .and()
                .cors();
    }
}