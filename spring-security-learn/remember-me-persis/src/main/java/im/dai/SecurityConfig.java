package im.dai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;

import javax.sql.DataSource;

/**
 * @ClassName SecurityConfig
 * @author: roc
 * @date: 2020/9/2 下午 03:51
 * @version: 1.0
 * @description: 方案二：配置类
 * BCryptPasswordEncoder 使用 BCrypt 强哈希函数，开发者在使用时可以选择提供 strength 和 SecureRandom 实例。
 * strength 越大，密钥的迭代次数越多，密钥迭代次数为 2^strength。strength 取值在 4~31 之间，默认为 10。
 * 相对比 shiro 需要自己处理密码加盐，BCryptPasswordEncoder 就自带了盐。
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Autowired
    DataSource dataSource;
    @Bean
    JdbcTokenRepositoryImpl jdbcTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }

    /**
     *  数据库支持
     */

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("admin").roles("admin");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/me").rememberMe() //二次验证，必须是通过自动登录认证后才能访问
                .antMatchers("/admin").fullyAuthenticated() //fullyAuthenticated不包含自动登录的形式，必须要用户名密码二次认证之后才能访问
                .anyRequest().authenticated() //authenticated包含自动登录的形式，无论是通过用户名密码认证还是通过自动登录认证，只要认证了，就可以访问
                .and()
                .formLogin()
                .and()
                .rememberMe()   //自动登录
                .key("demo")
                .tokenRepository(jdbcTokenRepository()) //持久化令牌
                .and()
                .csrf().disable();
    }

}
